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
public class Register {
   
    private String email;
     private String name;
    private String password;

    public Register() {
    }

    public Register(String name, String email, String password) {
  
        this.name = name;
        this.email = email;
        this.password = password;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.email = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Register{" + "email=" + email + ", password=" + password + '}';
    }

}
