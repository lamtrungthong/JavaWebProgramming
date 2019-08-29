/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lds2h
 */
@Controller
public class HomeController {
    
    
    @RequestMapping("/home")
    public String home(Model model) throws ClassNotFoundException, SQLException {
        ProductModel prodModel = new ProductModel();
        List<Product> listProd = new ArrayList<>();
        listProd = prodModel.getProd();
        model.addAttribute("listProd", listProd);
        return "index";
    }
}
