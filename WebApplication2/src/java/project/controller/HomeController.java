/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.config.SendMailSSL;
import project.dto.Info;
import project.dto.KindProd;
import project.dto.Prod_detail;
import project.dto.Prod_images;
import project.dto.Products;
import project.dto.Register;
import project.dto.Users;
import project.model.ProductModel;
import project.model.UserModel;

/**
 *
 * @author thonglt
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "home"})
    public String index(Model model) {
        List<Products> listProdAdvertise = new ArrayList<>();
        List<Products> listProdDiscount = new ArrayList<>();
        List<Products> listProdSell = new ArrayList<>();

        try {
            listProdAdvertise = new ProductModel().getAdvertiseActive();
            listProdDiscount = new ProductModel().getProdDiscount();
            listProdSell = new ProductModel().getProdSell(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("listProdAdvertise", listProdAdvertise);
        model.addAttribute("listProdDiscount", listProdDiscount);
        model.addAttribute("listProdSell", listProdSell);
        return "index";
    }

    @RequestMapping(value = "/đăng ký", method = RequestMethod.GET)
    public String register(Model model) {
        Register rg = new Register();
        rg.setName("Họ tên");
        rg.setEmail("email");
        model.addAttribute("register", rg);
        return "register";
    }

    @RequestMapping(value = "/đăng ký", method = RequestMethod.POST)
    public String register(HttpServletRequest req, Model model, @ModelAttribute("register") Register register, HttpSession session) throws ClassNotFoundException, SQLException {

        Users users = null;
        users = new UserModel().getUserByEmail(register.getEmail());
        if (users != null) {
           
            Random rng = new Random();
            int code = rng.nextInt(899999) + 100000;
            session.setAttribute("code", code);
            String idUser = "";
            Users u = null;
            do {
                int idI = rng.nextInt(899999) + 100000;
                idUser = "U" + idI;
                u = new UserModel().getUserById(idUser);

            } while (u != null);
            session.setAttribute("idUser", idUser);
            session.setAttribute("emailUser", register.getEmail());
            session.setAttribute("pwdUser", register.getPassword());

            SendMailSSL.sendmail("Mã xác nhận Apple Store", String.valueOf(code), register.getEmail());
            model.addAttribute("newUser", register);

            return "checkout";
        } else {
            return "register";
        }

    }

    @RequestMapping("/login")
    public String checkout(HttpServletRequest request, Model model, HttpSession session) {
        String numcheck = request.getParameter("numcheck");
        int code = (int) session.getAttribute("code");
        String emailUser = (String) session.getAttribute("emailUser");
        String pwdUser = (String) session.getAttribute("pwdUser");
        String idUser = (String) session.getAttribute("idUser");
        try {
            if (emailUser != null && pwdUser != null) {
                if (numcheck.equals(String.valueOf(code))) {
                    new UserModel().addInfo(new Info(idUser, "", "", "", null, null));
                    new UserModel().add(new Users(idUser, emailUser, pwdUser));
                    model.addAttribute("userLogin", new Users(idUser, emailUser, pwdUser));
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

    @RequestMapping("/{prod_id}")
    public String deltailProd(@PathVariable("prod_id") int prod_id, Model model) {
        List<Prod_images> listProdImg = new ArrayList<>();
        Products prod = new Products();
        Prod_detail prod_detail = new Prod_detail();
        KindProd kindProd = new KindProd();
        List<Products> togetherProd = new ArrayList<>();
        try {
            ProductModel prodModel = new ProductModel();
            listProdImg = prodModel.getListProdImageByProdId(prod_id);
            prod = prodModel.getProdById(prod_id);
            kindProd = prodModel.getKindProd(prod.getKind_id());
            togetherProd = prodModel.getProdByKind(prod.getKind_id());
            prod_detail = prodModel.getProdDetailById(prod_id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("listProdImg", listProdImg);
        model.addAttribute("prod", prod);
        model.addAttribute("prod_detail", prod_detail);
        model.addAttribute("togetherProd", togetherProd);
        model.addAttribute("kindProd", kindProd);
        return "detailProd";
    }

    @RequestMapping("/upload")
    public String uploadimg() {
        return "temp/upload";
    }

    @RequestMapping("/iPhone")
    public String iPhone(Model model) {
        List<Products> listProd = new ArrayList<>();
        try {
            listProd = new ProductModel().getAllByProd(3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("listProd", listProd);
        return "iphone/iPhone";
    }

    @RequestMapping("/iPad")
    public String iPad(Model model) {
        List<Products> listProd = new ArrayList<>();
        try {
            listProd = new ProductModel().getAllByProd(2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("listProd", listProd);
        return "ipad/iPad";
    }

    @RequestMapping("/MacBook")
    public String MacBook(Model model) {
        List<Products> listProd = new ArrayList<>();
        try {
            listProd = new ProductModel().getAllByProd(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("listProd", listProd);
        return "macbook/MacBook";
    }

    @RequestMapping("/AppleWatch")
    public String AppleWatch(Model model) {
        List<Products> listProd = new ArrayList<>();
        try {
            listProd = new ProductModel().getAllByProd(4);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("listProd", listProd);
        return "applewatch/AppleWatch";
    }

    @RequestMapping("/Phụ kiện")
    public String phuKien(Model model) {
        List<Products> listProd = new ArrayList<>();
        try {
            listProd = new ProductModel().getAllByProd(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("listProd", listProd);
        return "phukien/PhuKien";
    }

    @RequestMapping("/chinh sach bao hanh")
    public String baohanh() {
        return "chinhsach/baohanh";
    }

    @RequestMapping("/chinh sach doi tra")
    public String doitra() {
        return "chinhsach/doitra";
    }

    @RequestMapping("/gioi thieu")
    public String gioithieu() {
        return "gioithieu/gioithieu";
    }

}
