/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.OrderItems;
import project.dto.Orders;
import project.dto.Prod_images;
import project.dto.Products;
import project.model.ProductModel;

/**
 *
 * @author thonglt
 */
@RestController
public class APIProd {

    @RequestMapping("/addtocart/{prodId}")
    public List order(@PathVariable("prodId") int prodId, Model model, HttpSession session) throws SQLException, ClassNotFoundException {
        ProductModel productModel = new ProductModel();
        Products prod = productModel.getProdById(prodId);
        if (prod.getKind_id() != 4 && prod.getKind_id() != 5) {
            prod.setListImg(productModel.getListProdImageByProdId(prodId));
        }
        
        if (session.getAttribute("cart") == null) {
            OrderItems items = new OrderItems();
            items.setQuantity(1);
            items.setProd(prod);
            List<OrderItems> listItem = new ArrayList<>();
            listItem.add(items);
            session.setAttribute("cart", listItem);
            model.addAttribute("cart", listItem);
            return listItem;

        } else {
            List<OrderItems> listItems = new ArrayList<>();
            listItems = (List<OrderItems>) session.getAttribute("cart");
            boolean flag = false;
            for (OrderItems orderItems : listItems) {
                if (orderItems.getProd().getId() == prodId) {
                    orderItems.setQuantity(orderItems.getQuantity() + 1);
                    flag = true;
                }
            }
            if (!flag) {
                OrderItems items = new OrderItems();
                items.setQuantity(1);
                items.setProd(prod);
                listItems.add(items);
            }
            session.setAttribute("cart", listItems);
            model.addAttribute("cart", listItems);
            return listItems;
        }

    }

    @RequestMapping("/addquantity/{prodId}")
    public List addQuantity(@PathVariable("prodId") int prodId, Model model, HttpSession session) throws SQLException, ClassNotFoundException {
        List<OrderItems> listItems = new ArrayList<>();
        listItems = (List<OrderItems>) session.getAttribute("cart");
        boolean flag = false;
        for (OrderItems orderItems : listItems) {
            if (orderItems.getProd().getId() == prodId) {
                orderItems.setQuantity(orderItems.getQuantity() + 1);
                flag = true;
            }
        }
        session.setAttribute("cart", listItems);
        model.addAttribute("cart", listItems);
        return listItems;

    }

    @RequestMapping("/subquantity/{prodId}")
    public List subQuantity(@PathVariable("prodId") int prodId, Model model, HttpSession session) throws SQLException, ClassNotFoundException {
        List<OrderItems> listItems = new ArrayList<>();
        listItems = (List<OrderItems>) session.getAttribute("cart");
        boolean flag = false;
        for (OrderItems orderItems : listItems) {
            if (orderItems.getProd().getId() == prodId) {
                if (orderItems.getQuantity() > 1) {
                    orderItems.setQuantity(orderItems.getQuantity() - 1);
                    flag = true;
                }

            }
        }
        session.setAttribute("cart", listItems);
        model.addAttribute("cart", listItems);
        return listItems;

    }
    
    @RequestMapping("/prod/{prodImgId}")
    public Prod_images prodImg(@PathVariable("prodImgId") int prodImgId) throws ClassNotFoundException, SQLException{
        Prod_images prod_images = new Prod_images();
        prod_images = new ProductModel().getProdImageById(prodImgId);
        return prod_images;
    }
    
    @RequestMapping("/prod-other/{prodImgId}")
    public List prodImgOther(@PathVariable("prodImgId") int prodImgId) throws ClassNotFoundException, SQLException{
        List<Prod_images> list = new ArrayList<>();
        list = new ProductModel().getProdImageByIdOther(prodImgId);
        return list;
    }
    @RequestMapping("/product/{nameProd}")
    public List getProd(@PathVariable("nameProd") String nameProd) throws ClassNotFoundException, SQLException{
        List<Prod_images> list = new ArrayList<>();
        list = new ProductModel().getAllProdByName(nameProd);
        return list;
    }
    
    @RequestMapping("/admin/revenue/date/{date}")
    public List getRevenueByDate(@PathVariable("date") Date date) throws ClassNotFoundException, SQLException{
        List<Orders> listOrderDoneByDate = new ProductModel().getAllOrderDoneByDate(date);
        for (Orders orders : listOrderDoneByDate) {
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }
        return listOrderDoneByDate;
    }
    @RequestMapping("/admin/revenue/month/{month}")
    public List getRevenueByMonth(@PathVariable("month") int month) throws ClassNotFoundException, SQLException{

        List<Orders> listOrderDoneByMonth = new ProductModel().getAllOrderDoneByMonth(month);
        for (Orders orders : listOrderDoneByMonth) {
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }
        return listOrderDoneByMonth;
    }
    @RequestMapping("/admin/revenue/year/{year}")
    public List getRevenueByYear(@PathVariable("year") int year) throws ClassNotFoundException, SQLException{
        List<Orders> listOrderDoneByYear = new ProductModel().getAllOrderDoneByYear(year);
        for (Orders orders : listOrderDoneByYear) {
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }
        return listOrderDoneByYear;
    }
    
}
