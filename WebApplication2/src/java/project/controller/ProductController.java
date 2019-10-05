/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.config.MyConstants;
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
public class ProductController {

    @RequestMapping("/giỏ hàng")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/đặt hàng")
    public String order(Model model, HttpSession session, HttpServletRequest req) throws ClassNotFoundException, SQLException {
        Cookie[] username = req.getCookies();
        String email = (String) session.getAttribute("username");
        List<OrderItems> listOrder = (List<OrderItems>) session.getAttribute("cart");
        UserModel userModel = new UserModel();
        List<String> listColor = new ArrayList<>();
        for (OrderItems orderItems : listOrder) {
            if (orderItems.getProd().getKind_id() != 4 && orderItems.getProd().getKind_id() != 5) {
                listColor.add(req.getParameter(String.valueOf(orderItems.getProd().getId())));
            }
                
        }
        session.setAttribute("listColor", listColor);
        if (email != null) {
            Users u = userModel.getUserByEmail(email);
            Info info = userModel.getInfoById(u.getId());
            info.setEmail(email);
            model.addAttribute("infoUser", info);
            model.addAttribute("info", info);
            model.addAttribute("email", email);
            
            return "shipping";

        } else {
            Users user1 = new Users();
            user1.setUsername("email");
            user1.setPassword("");
            model.addAttribute("userLogin", user1);

            return "userLogin";
        }
    }

    @RequestMapping(value = "/update-info2", method = RequestMethod.POST)
    public String info(@ModelAttribute("infoUser") Info info, Model model) throws ClassNotFoundException, SQLException {

        Users u = new UserModel().getUserByEmail(info.getEmail());
        info.setUserId(u.getId());

        int rs = new UserModel().updateInfo(info);
        if (rs > 0) {
            model.addAttribute("yes", "Cập nhật thông tin thành công.");

        } else {
            model.addAttribute("no", "Cập nhật thông tin thất bại.");
        }
        info.setEmail(info.getEmail());
        model.addAttribute("info", info);
        model.addAttribute("infoUser", info);
        return "shipping";
    }

    @RequestMapping("/thanh toán")
    public String pay(Model model, HttpServletRequest req, HttpSession session) throws ClassNotFoundException, SQLException {
        String email = (String) session.getAttribute("username");
       List<String> listColor = (List<String>) session.getAttribute("listColor");
        UserModel userModel = new UserModel();
        if (email != null) {
            Users u = userModel.getUserByEmail(email);
            Info info = userModel.getInfoById(u.getId());
            info.setEmail(email);
            model.addAttribute("listColor", listColor);
            model.addAttribute("infoUser", info);
            model.addAttribute("info", info);
            model.addAttribute("email", email);
        }
        return "pay";
    }

    @RequestMapping("/giỏ hàng/xóa/{prodId}")
    public String delCart(@PathVariable("prodId") int prodId, Model model, HttpSession session) {
        if (session.getAttribute("cart") != null) {
            List<OrderItems> list = new ArrayList<>();
            list = (List<OrderItems>) session.getAttribute("cart");
            Iterator<OrderItems> iterator = list.iterator();

            while (iterator.hasNext()) {
                if (iterator.next().getProd().getId() == prodId) {
                    iterator.remove();
                }
            }

            if (list.isEmpty()) {
                session.removeAttribute("cart");
            }
            model.addAttribute("cart", list);
        }

        return "cart";
    }

    @RequestMapping("/đặt mua")
    public String finishOrder(HttpSession session, HttpServletRequest req, Model model) throws ClassNotFoundException, SQLException {
        Random rng = new Random();
        Orders o = new Orders();

        List<OrderItems> list = new ArrayList<>();
        ProductModel pm = new ProductModel();
        String orderID = "";
        String test = null;
        do {
            orderID = "ORDER" + rng.nextInt(1000) + 999;
            test = pm.getOrderId(orderID);
        } while (test != null);
        Cookie[] cs = req.getCookies();
        Users u = new UserModel().getUserByEmail((String) session.getAttribute("username"));
        list = (List<OrderItems>) session.getAttribute("cart");
        o.setId(orderID);
        o.setOrderStatus(1);
        o.setPayId(1);
        o.setUserId(u.getId());
 
        o.setOrderedAt(new Date());
        pm.addOrder(o);
        int i = 0;
        List<String> listColor = (List<String>) session.getAttribute("listColor");
        for (OrderItems items : list) {
            OrderItems oi = new OrderItems();
            oi.setOrderId(orderID);
            oi.setProdId(items.getProd().getId());
            oi.setColor(listColor.get(i).toString());
            oi.setQuantity(items.getQuantity());
            int discout = items.getProd().getDiscount() * items.getQuantity();
            int total = items.getProd().getPrice() * items.getQuantity();
            oi.setAmount((total - discout));
            pm.addOrderItem(oi);
            i++;
        }
        
        
        
        String email = (String) session.getAttribute("username");
        Users u2 = new UserModel().getUserByEmail(email);
        List<Orders> orderlist = pm.getOrderByUserId(u2.getId());
        for (Orders orders : orderlist) {
            orders.setOrderItems(pm.getOrderItemByOrderId(orders.getId()));
            orders.setOs(pm.getOrderStatusById(orders.getOrderStatus()));
            for (OrderItems items : orders.getOrderItems()) {
                items.setProd(pm.getProdById(items.getProdId()));
            }
        }
        
        Info info = new UserModel().getInfoById(u2.getId());
        SendMailSSL.sendmail("AppleStore", MyConstants.orderConfirm(email, info,o, list), email);
        model.addAttribute("orderlist", orderlist);
        
        model.addAttribute("messege", "Đặt hàng thành công");
        session.removeAttribute("cart");
        return "order";
    }

}
