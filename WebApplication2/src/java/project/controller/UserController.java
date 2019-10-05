/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.config.EncriptPasswdByMD5;
import project.config.SendMailSSL;
import project.dto.Info;
import project.dto.OrderItems;
import project.dto.Orders;
import project.dto.Products;
import project.dto.Users;
import project.model.ProductModel;
import project.model.UserModel;

/**
 *
 * @author thonglt
 */
@Controller
public class UserController {

    @RequestMapping(value = "/đăng nhập", method = RequestMethod.GET)
    public String login(@ModelAttribute("userLogin") Users user, Model model) {

        Users user1 = new Users();
        user1.setUsername("email");
        user1.setPassword("");
        model.addAttribute("user", user1);

        return "userLogin";
    }

    @RequestMapping(value = "/quên mật khẩu", method = RequestMethod.GET)
    public String forgotPass() {

        return "forgotpassword";
    }

    @RequestMapping(value = "/forgotpass", method = RequestMethod.POST)
    public String forgotPass(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        Random rng = new Random();
        int code = rng.nextInt(899999) + 100000;
        session.setAttribute("code", code);

        session.setAttribute("emailUser", email);
        session.setAttribute("pwdUser", pass);

        SendMailSSL.sendmail("Mã xác nhận quên mật khẩu Apple Store", String.valueOf(code), email);

        return "checkpass";
    }

    @RequestMapping("/checkpass")
    public String checkpass(HttpServletRequest request, Model model, HttpSession session) {
        String numcheck = request.getParameter("numcheck");
        int code = (int) session.getAttribute("code");
        String emailUser = (String) session.getAttribute("emailUser");
        String pwdUser = (String) session.getAttribute("pwdUser");
        try {
            if (emailUser != null && pwdUser != null) {
                if (numcheck.equals(String.valueOf(code))) {
                    int rs = new UserModel().setPass(emailUser, pwdUser);
                    model.addAttribute("userLogin", new Users("", emailUser, pwdUser));
                    return "userLogin";
                } else {
                    String err = "Mã xác nhận không chính sác";
                    model.addAttribute("err", err);
                    return "checkout";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "checkout";

    }

    @RequestMapping(value = "/đăng nhập", method = RequestMethod.POST)
    public String auth(@ModelAttribute("userLogin") Users user,
            Model model, HttpSession session, HttpServletResponse res) {
        try {
            UserModel userModel = new UserModel();
            Users u = userModel.login(user.getUsername(), EncriptPasswdByMD5.md5(user.getPassword()));
            if (u != null) {
                List<Products> listProdAdvertise = new ArrayList<>();
                List<Products> listProdDiscount = new ArrayList<>();
                List<Products> listProdSell = new ArrayList<>();

                listProdAdvertise = new ProductModel().getAdvertiseActive();
                listProdDiscount = new ProductModel().getProdDiscount();
                listProdSell = new ProductModel().getProdSell(1);

                model.addAttribute("listProdAdvertise", listProdAdvertise);
                model.addAttribute("listProdDiscount", listProdDiscount);
                model.addAttribute("listProdSell", listProdSell);
                if (u.getRoleId() == 1) {
                    ProductModel pm = new ProductModel();
                    int sumProd = pm.sumProd();
                    long sumPriceStore = pm.sumPriceStore();
                    int sumOrder = pm.sumOrder();
                    int sumUser = new UserModel().sumUser();

                    List<Orders> listOrderDoneByDate = pm.getAllOrderDoneByDate(new Date(System.currentTimeMillis()));
                    for (Orders orders : listOrderDoneByDate) {
                        orders.setOrderItems(pm.getOrderItemByOrderId(orders.getId()));
                    }
                    Date date = new Date(System.currentTimeMillis());
                    LocalDate localDate = LocalDate.now();
                    int month = localDate.getMonthValue();

                    List<Orders> listOrderDoneByMonth = pm.getAllOrderDoneByMonth(month);
                    for (Orders orders : listOrderDoneByMonth) {
                        orders.setOrderItems(pm.getOrderItemByOrderId(orders.getId()));
                    }

                    model.addAttribute("date", date);
                    model.addAttribute("month", month);
                    model.addAttribute("listOrderDoneByDate", listOrderDoneByDate);
                    model.addAttribute("listOrderDoneByMonth", listOrderDoneByMonth);
                    model.addAttribute("sumProd", sumProd);
                    model.addAttribute("sumPriceStore", sumPriceStore);
                    model.addAttribute("sumOrder", sumOrder);
                    model.addAttribute("sumUser", sumUser);

                    session.setAttribute("abc", u.getUsername());
                    model.addAttribute("username", u.getUsername());
                    return "admin/index";
                } else if (u.getRoleId() == 3) {
                    if (u.getActived() != 1) {
                        model.addAttribute("block", "Đăng nhập thất bại! Tài khoản của bạn đã bị khóa.");
                        model.addAttribute("userLogin", new Users());
                        return "userLogin";
                    } else {
                        session.setAttribute("username", u.getUsername());
                        model.addAttribute("username", u.getUsername());

                        return "index";
                    }

                }
            } else {
                model.addAttribute("userLogin", new Users());
                model.addAttribute("err", "Đăng nhập thất bại!");
                model.addAttribute("err2", "Email hoặc mật khẩu không chính xác!");
                return "userLogin";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        try {
            session.removeAttribute("username");
            List<Products> listProdAdvertise = new ArrayList<>();
            List<Products> listProdDiscount = new ArrayList<>();
            List<Products> listProdSell = new ArrayList<>();

            listProdAdvertise = new ProductModel().getAdvertiseActive();
            listProdDiscount = new ProductModel().getProdDiscount();
            listProdSell = new ProductModel().getProdSell(1);

            model.addAttribute("listProdAdvertise", listProdAdvertise);
            model.addAttribute("listProdDiscount", listProdDiscount);
            model.addAttribute("listProdSell", listProdSell);
            return "index";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/info", params = "id", method = RequestMethod.GET)
    public String info(@RequestParam("id") String userID, Model model) throws ClassNotFoundException, SQLException {
        Info info = new UserModel().getInfoById(userID);
        Users u = new UserModel().getUserById(userID);

        info.setEmail(u.getUsername());
        model.addAttribute("infoUser", info);
        return "infoUser";
    }

    @RequestMapping(value = "/update-info", method = RequestMethod.POST)
    public String info(@ModelAttribute("infoUser") Info info, Model model) throws ClassNotFoundException, SQLException {

        Users u = new UserModel().getUserByEmail(info.getEmail());
        info.setUserId(u.getId());

        int rs = new UserModel().updateInfo(info);
        if (rs > 0) {
            model.addAttribute("yes", "Cập nhật thông tin thành công.");

        } else {
            model.addAttribute("no", "Cập nhật thông tin thất bại.");
        }
        model.addAttribute("infoUser", info);
        return "infoUser";
    }

    @RequestMapping("/order")
    public String orderUser(Model model, HttpSession session) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        String email = (String) session.getAttribute("username");
        Users u = new UserModel().getUserByEmail(email);
        List<Orders> orderlist = pm.getOrderByUserId(u.getId());
        for (Orders orders : orderlist) {
            orders.setOrderItems(pm.getOrderItemByOrderId(orders.getId()));
            orders.setOs(pm.getOrderStatusById(orders.getOrderStatus()));
            for (OrderItems items : orders.getOrderItems()) {
                items.setProd(pm.getProdById(items.getProdId()));
            }
        }

        model.addAttribute("orderlist", orderlist);
        return "order";
    }
}
