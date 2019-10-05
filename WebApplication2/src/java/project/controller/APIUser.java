/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.Users;
import project.model.UserModel;

/**
 *
 * @author thonglt
 */
@RestController
public class APIUser {

    @RequestMapping("/admin/user/{name}")
    public List user(@PathVariable("name") String name, Model model) throws ClassNotFoundException, SQLException {
        List<Users> list = new ArrayList<>();
        list = new UserModel().getAllUserByName(name);
        model.addAttribute("list", list);
        return list;
    }
}
