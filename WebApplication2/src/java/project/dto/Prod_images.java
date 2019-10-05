/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.dto;

/**
 *
 * @author thonglt
 */
public class Prod_images {
    private int id;
    private int prod_id;
    private String image;
    private String name;

    public Prod_images() {
    }

    public Prod_images(int id, int prod_id, String image, String name) {
        this.id = id;
        this.prod_id = prod_id;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
