/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.Products;

/**
 *
 * @author thonglt
 */
@RestController
public class ProductAPI {
    @RequestMapping("")
    public Products prod(){
        return null;
    }
}
