/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project.db.ConnectDB;
import project.dto.Advertise;
import project.dto.KindProd;
import project.dto.OrderItems;
import project.dto.OrderStatus;
import project.dto.Orders;
import project.dto.ProdAndDeltail;
import project.dto.Prod_detail;
import project.dto.Prod_images;
import project.dto.Products;

/**
 *
 * @author thonglt
 */
public class ProductModel {

    Connection conn;

    public ProductModel() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }

    public List getAll() throws SQLException {
        String sql = "SELECT * FROM products";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Products> all = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setQuantityStore(rs.getInt("quantity_store"));
            p.setPriceStore(rs.getInt("price_store"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            p.setDiscount(rs.getInt("discount"));
            all.add(p);
        }
        return all;
    }

    public List getAllActive() throws SQLException {
        String sql = "SELECT * FROM products WHERE actived = 1";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Products> all = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setQuantityStore(rs.getInt("quantity_store"));
            p.setPriceStore(rs.getInt("price_store"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            p.setDiscount(rs.getInt("discount"));
            all.add(p);
        }
        return all;
    }
    public List getAll(int limit, int offset) throws SQLException {
        String sql = "SELECT *"
                + " FROM products "
                + " LIMIT ? OFFSET ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, limit);
        pstmt.setInt(2, offset);
        ResultSet rs = pstmt.executeQuery();
        List<Products> all = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setQuantityStore(rs.getInt("quantity_store"));
            p.setPriceStore(rs.getInt("price_store"));
            p.setPrice(rs.getInt("price"));
            p.setKind_id(rs.getInt("kind_id"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            p.setDiscount(rs.getInt("discount"));
//            p.setDisplay(rs.getInt("display"));
//            p.setOS(rs.getString("os"));
//            p.setRam(rs.getInt("ram"));
//            p.setRom(rs.getInt("rom"));
//            p.setfCamera(rs.getInt("f_camera"));
//            p.setbCamera(rs.getInt("b_camera"));
//            p.setBattery(rs.getInt("battery"));
            all.add(p);
        }
        return all;
    }

    public List getAllDetail() throws SQLException {
        String sql = "SELECT * FROM prod_detail";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Prod_detail> list = new ArrayList<>();
        while (rs.next()) {
            Prod_detail p = new Prod_detail();
            p.setId(rs.getInt("id"));
            p.setProdId(rs.getInt("prod_id"));
            p.setDisplay(rs.getInt("display"));
            p.setOS(rs.getString("os"));
            p.setRam(rs.getInt("ram"));
            p.setRom(rs.getInt("rom"));
            p.setfCamera(rs.getInt("f_camera"));
            p.setbCamera(rs.getInt("b_camera"));
            p.setBattery(rs.getInt("battery"));
            list.add(p);
        }
        return list;
    }

    public List getAllProdByName(String name) throws SQLException {
        String sql = "SELECT * FROM products WHERE name like  ? ";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, "%" + name + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Products> all = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            p.setPriceStore(rs.getInt("price_store"));
            p.setQuantityStore(rs.getInt("quantity_store"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            p.setDiscount(rs.getInt("discount"));
            all.add(p);
        }
        return all;
    }

    public List getAllByProd(int kind) throws SQLException {
        String sql = "SELECT * FROM products where kind_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, kind);
        ResultSet rs = pstmt.executeQuery();
        List<Products> all = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            p.setDiscount(rs.getInt("discount"));
            all.add(p);
        }
        return all;
    }

    public List getProdDiscount() throws SQLException {
        String sql = "SELECT * FROM products where discount > 0 AND actived = 1 AND quantity_store > 5";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Products> discount = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setKind_id(rs.getInt("kind_id"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            discount.add(p);
        }
        return discount;
    }

    public List getProdSell(int sell) throws SQLException {
        String sql = "SELECT * FROM products where sell = ? AND actived = 1 AND quantity_store > 5";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, sell);
        ResultSet rs = pstmt.executeQuery();
        List<Products> list = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setKind_id(rs.getInt("kind_id"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            list.add(p);
        }
        return list;
    }

    public Products getProdById(int id) throws SQLException {
        String sql = "SELECT * FROM products where id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Products p = null;
        while (rs.next()) {
            p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setKind_id(rs.getInt("kind_id"));
            p.setPriceStore(rs.getInt("price_store"));
            p.setQuantityStore(rs.getInt("quantity_store"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
        }

        return p;
    }

    public List getListProdImageByProdId(int id) throws SQLException {
        String sql = "SELECT * FROM prod_images where prod_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<Prod_images> list = new ArrayList<>();
        while (rs.next()) {
            Prod_images p_img = new Prod_images();
            p_img.setId(rs.getInt("id"));
            p_img.setProd_id(rs.getInt("prod_id"));
            p_img.setImage(rs.getString("image"));
            p_img.setName(rs.getString("name"));
            list.add(p_img);
        }
        return list;
    }

    
    
    public Prod_images getProdImageById(int id) throws SQLException {
        String sql = "SELECT * FROM prod_images where id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Prod_images p_img = null;
        while (rs.next()) {
         p_img = new Prod_images();
            p_img.setId(rs.getInt("id"));
            p_img.setProd_id(rs.getInt("prod_id"));
            p_img.setImage(rs.getString("image"));
            p_img.setName(rs.getString("name"));

        }
        return p_img;
    }
    
    

    public List getProdImageByIdOther(int id) throws SQLException {
        String sql = "SELECT * FROM `prod_images` WHERE id NOT IN (SELECT id FROM prod_images WHERE id = ?);";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<Prod_images> list = new ArrayList<>();
        while (rs.next()) {
            Prod_images p_img = new Prod_images();
            p_img.setId(rs.getInt("id"));
            p_img.setProd_id(rs.getInt("prod_id"));
            p_img.setImage(rs.getString("image"));
            p_img.setName(rs.getString("name"));
            list.add(p_img);
        }
        return list;
    }

    public Prod_detail getProdDetailById(int id) throws SQLException {
        String sql = "SELECT * FROM prod_detail where prod_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Prod_detail p_detail = new Prod_detail();
        p_detail.setId(rs.getInt("id"));
        p_detail.setProdId(rs.getInt("prod_id"));
        p_detail.setDisplay(rs.getDouble("display"));
        p_detail.setOS(rs.getString("os"));
        p_detail.setRam(rs.getInt("ram"));
        p_detail.setRom(rs.getInt("rom"));
        p_detail.setfCamera(rs.getInt("f_camera"));
        p_detail.setBattery(rs.getInt("battery"));
        p_detail.setbCamera(rs.getInt("b_camera"));
        return p_detail;
    }

    public List getProdByKind(int kindId) throws SQLException {
        String sql = "SELECT * FROM products where kind_id = ? limit 4";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, kindId);
        ResultSet rs = pstmt.executeQuery();
        List<Products> list = new ArrayList<>();
        while (rs.next()) {
            Products p = new Products();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setKind_id(rs.getInt("kind_id"));
            p.setPrice(rs.getInt("price"));
            p.setDiscount(rs.getInt("discount"));
            p.setImages(rs.getString("images"));
            p.setDescription(rs.getString("description"));
            p.setActived(rs.getInt("actived"));
            p.setSell(rs.getInt("sell"));
            p.setCreatedAt(rs.getDate("created_at"));
            p.setUpdatedAt(rs.getDate("updated_at"));
            list.add(p);
        }
        return list;
    }

    public KindProd getKindProd(int kindId) throws SQLException {
        String sql = "SELECT * FROM kind_prod where id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, kindId);
        ResultSet rs = pstmt.executeQuery();
        KindProd kindProd = new KindProd();
        while (rs.next()) {

            kindProd.setId(rs.getInt("id"));
            kindProd.setName(rs.getString("name"));
            kindProd.setCreatedAt(rs.getDate("created_at"));
            kindProd.setUpdatedAt(rs.getDate("updated_at"));
        }

        return kindProd;

    }

    public List getAdvertiseActive() throws SQLException {
        String sql = "SELECT * FROM advertise WHERE state = 1";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Advertise> list = new ArrayList<>();
        while (rs.next()) {
            Advertise advertise = new Advertise();
            advertise.setId(rs.getInt("id"));
            advertise.setProdId(rs.getInt("prod_id"));
            advertise.setImages(rs.getString("images"));
            advertise.setState(rs.getInt("state"));
            advertise.setCreatedAt(rs.getDate("created_at"));
            advertise.setUpdatedAt(rs.getDate("updated_at"));
            list.add(advertise);
        }

        return list;

    }
    public List getAdvertise() throws SQLException {
        String sql = "SELECT * FROM advertise ";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Advertise> list = new ArrayList<>();
        while (rs.next()) {
            Advertise advertise = new Advertise();
            advertise.setId(rs.getInt("id"));
            advertise.setProdId(rs.getInt("prod_id"));
            advertise.setImages(rs.getString("images"));
            advertise.setState(rs.getInt("state"));
            advertise.setCreatedAt(rs.getDate("created_at"));
            advertise.setUpdatedAt(rs.getDate("updated_at"));
            list.add(advertise);
        }

        return list;

    }
    
    public Advertise getAdvertiseById(int id) throws SQLException {
        String sql = "SELECT * FROM advertise WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
            Advertise advertise = new Advertise();
            while (rs.next()) {            
            advertise.setId(rs.getInt("id"));
            advertise.setProdId(rs.getInt("prod_id"));
            advertise.setImages(rs.getString("images"));
            advertise.setState(rs.getInt("state"));
            advertise.setCreatedAt(rs.getDate("created_at"));
            advertise.setUpdatedAt(rs.getDate("updated_at"));
        }
            return advertise;
           
    }

    public int addOrder(Orders o) throws SQLException {
        String sql = "INSERT INTO `orders`(`id`, `user_id`, `pay_id`, `order_status`) VALUES (?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, o.getId());
        pstmt.setString(2, o.getUserId());
        pstmt.setInt(3, o.getPayId());
        pstmt.setInt(4, o.getOrderStatus());

        return pstmt.executeUpdate();
    }

    public int addOrderItem(OrderItems oi) throws SQLException {
        String sql = "INSERT INTO `order_items`( `order_id`, `prod_id`, `color`, `amount`, `quantity` ) VALUES (?,?,?,?,?) ";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, oi.getOrderId());
        pstmt.setInt(2, oi.getProdId());
        pstmt.setString(3, oi.getColor());
        pstmt.setInt(4, oi.getAmount());
        pstmt.setInt(5, oi.getQuantity());
        return pstmt.executeUpdate();
    }

    public String getOrderId(String id) throws SQLException {
        String sql = "SELECT id FROM orders WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        String orderId = null;
        while (rs.next()) {
            orderId = rs.getString("id");
        }
        return orderId;
    }

    public List getOrderByUserId(String userId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, userId);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUpdatetAt(rs.getDate("updated_at"));
            o.setUserId(userId);
            list.add(o);
        }
        return list;
    }

    public List getOrderItemByOrderId(String orderId) throws SQLException {
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, orderId);
        ResultSet rs = pstmt.executeQuery();
        List<OrderItems> list = new ArrayList<>();
        while (rs.next()) {
            OrderItems oi = new OrderItems();
            oi.setAmount(rs.getInt("amount"));
            oi.setId(rs.getInt("id"));
            oi.setOrderId(orderId);
            oi.setProdId(rs.getInt("prod_id"));
            oi.setColor(rs.getString("color"));
            oi.setQuantity(rs.getInt("quantity"));
            list.add(oi);
        }
        return list;
    }

    public OrderStatus getOrderStatusById(int id) throws SQLException {
        String sql = "SELECT * FROM order_status WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        OrderStatus os = new OrderStatus();
        while (rs.next()) {
            os.setId(id);
            os.setName(rs.getString("name"));
        }
        return os;
    }

    public int sumProd() throws SQLException {
        String sql = "SELECT COUNT(*) FROM products";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public long sumPriceStore() throws SQLException {
        String sql = "SELECT SUM(price_store*quantity_store) FROM products";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getLong(1);
    }

    public int sumOrder() throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public int delProd(int id) throws SQLException {
        String sql = "DELETE FROM `products` WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

    public int addProd(Products p) throws SQLException {
        String sql = "INSERT INTO `products`(`id`, `name`, `kind_id`, "
                + "`price_store`, `quantity_store`, `price`, `discount`,"
                + " `description`, `images`, `actived`, `sell`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, p.getId());
        pstmt.setInt(3, p.getKind_id());
        pstmt.setString(2, p.getName());
        pstmt.setInt(4, p.getPriceStore());
        pstmt.setInt(5, p.getQuantityStore());
        pstmt.setInt(6, p.getPrice());
        pstmt.setInt(7, p.getDiscount());
        pstmt.setString(8, p.getDescription());
        pstmt.setString(9, p.getImages());
        pstmt.setInt(10, 1);
        pstmt.setInt(11, 0);
        return pstmt.executeUpdate();
    }

    public int addProdDetail(Prod_detail p) throws SQLException {
        String sql = "INSERT INTO `prod_detail`( `prod_id`, `display`, "
                + "`os`, `ram`, `rom`, `f_camera`, `b_camera`, `battery`)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, p.getProdId());
        pstmt.setString(3, p.getOS());
        pstmt.setDouble(2, p.getDisplay());
        pstmt.setInt(4, p.getRam());
        pstmt.setInt(5, p.getRom());
        pstmt.setInt(6, p.getfCamera());
        pstmt.setInt(7, p.getbCamera());
        pstmt.setInt(8, p.getBattery());
        return pstmt.executeUpdate();
    }

    public int setProdById(Products p) throws SQLException {
        String sql = "UPDATE `products` SET `name`=?,"
                + "`price_store`=?,`quantity_store`=?,`price`=?,`discount`=?,"
                + "`description`=?,`images`=?,`updated_at`= ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, p.getName());
        pstmt.setInt(2, p.getPriceStore());
        pstmt.setString(6, p.getDescription());
        pstmt.setInt(3, p.getQuantityStore());
        pstmt.setString(7, p.getImages());
        pstmt.setInt(4, p.getPrice());
        pstmt.setInt(5, p.getDiscount());
        pstmt.setDate(8, (Date) p.getUpdatedAt());
        pstmt.setInt(9, p.getId());
        return pstmt.executeUpdate();
    }
    
    public int setDetailByProdId(Prod_detail p) throws SQLException{
        String sql = "UPDATE `prod_detail` SET `display`=?,"
                + "`os`=?,`ram`=?,`rom`=?,`f_camera`=?,`b_camera`=?,"
                + "`battery`=? WHERE prod_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setDouble(1, p.getDisplay());
        pstmt.setString(2, p.getOS());
        pstmt.setInt(3, p.getRam());
        pstmt.setInt(4, p.getRom());
        pstmt.setInt(5, p.getfCamera());
        pstmt.setInt(6, p.getbCamera());
        pstmt.setInt(7, p.getBattery());
        pstmt.setInt(8, p.getProdId());
        return pstmt.executeUpdate();
    }
    
    public int addProdImages(Prod_images p) throws SQLException{
        String sql = "INSERT INTO `prod_images`( `prod_id`, `image`, `name`)"
                + " VALUES (?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, p.getProd_id());
        pstmt.setString(2, p.getImage());
        pstmt.setString(3, p.getName());
        return pstmt.executeUpdate();
    }
    
    public int updateProdImages(Prod_images p) throws SQLException{
        String sql = "UPDATE `prod_images` SET `image`=?,`name`=? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(3, p.getId());
        pstmt.setString(1, p.getImage());
        pstmt.setString(2, p.getName());
        return pstmt.executeUpdate();
    }
    public int delProdImages(int id) throws SQLException{
        String sql = "DELETE FROM `prod_images` WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }
    
    public int setStateByIdProd( int state ,int idProd) throws SQLException{
        String sql = "UPDATE `products` SET `actived`= ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, state);
        pstmt.setInt(2, idProd);
        return pstmt.executeUpdate();
    }
    
     public int setSellByIdProd( int sell ,int idProd) throws SQLException{
        String sql = "UPDATE `products` SET `sell`= ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, sell);
        pstmt.setInt(2, idProd);
        return pstmt.executeUpdate();
    }
    
    public List getAllOrder() throws SQLException{
        String sql = "SELECT * FROM orders WHERE order_status NOT LIKE 4 AND order_status NOT LIKE 5";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {            
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
            list.add(o);
        }
        return list;
    }
    
    public List getAllOrderDone() throws SQLException{
        String sql = "SELECT * FROM orders WHERE order_status LIKE 5";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {            
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
            list.add(o);
        }
        return list;
    }
    public List getAllOrderDoneByDate(Date date) throws SQLException{
        String sql = "SELECT * FROM orders WHERE order_status LIKE 5 AND updated_at = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setDate(1, date);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {            
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
            list.add(o);
        }
        return list;
    }
    public List getAllOrderDoneByMonth(int month) throws SQLException{
        String sql = "SELECT * FROM orders WHERE order_status LIKE 5 AND month(updated_at) = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, month);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {            
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
            list.add(o);
        }
        return list;
    }
    
    public List getAllOrderDoneByYear(int month) throws SQLException{
        String sql = "SELECT * FROM orders WHERE order_status LIKE 5 AND year(updated_at) = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, month);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {            
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
            list.add(o);
        }
        return list;
    }
    
    public List getAllOrderCancel() throws SQLException{
        String sql = "SELECT * FROM orders WHERE order_status LIKE 4";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {            
            Orders o = new Orders();
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
            list.add(o);
        }
        return list;
    }
    
    public Orders getOrderById(String idOrder) throws SQLException{
        String sql = "SELECT * FROM orders WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, idOrder);
        ResultSet rs = pstmt.executeQuery();
        Orders o = new Orders();
        while (rs.next()) {            
            
            o.setId(rs.getString("id"));
            o.setOrderStatus(rs.getInt("order_status"));
            o.setOrderedAt(rs.getDate("ordered_at"));
            o.setPayId(rs.getInt("pay_id"));
            o.setUserId(rs.getString("user_id"));
        }
        return o;
    }
    
    public int setOrderStatus(String idOrder, int status, Date updatedAt) throws SQLException{
        String sql = "UPDATE `orders` SET `order_status`= ?, `updated_at` = ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, status);
        pstmt.setDate(2, updatedAt);
        pstmt.setString(3, idOrder);
        return pstmt.executeUpdate();
    }
    
    public int delOrderById(String idOrder) throws SQLException{
        String sql = "DELETE FROM `orders` WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, idOrder);
        return pstmt.executeUpdate();
    }
    
    public int setQuantityStoreByProdId(int prodId, int quantity) throws SQLException{
        String sql = "UPDATE `products` SET `quantity_store`= ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, quantity);
        pstmt.setInt(2, prodId);
        return pstmt.executeUpdate();
    }
    public int delAdById(int adAd) throws SQLException{
        String sql = "DELETE FROM `advertise` WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, adAd);
        return pstmt.executeUpdate();
    }
    public int setStateAdById(int state ,int adAd) throws SQLException{
        String sql = "UPDATE `advertise` SET `state`= ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, state);
        pstmt.setInt(2, adAd);
        return pstmt.executeUpdate();
    }
    
    public int addAdvertise(Advertise ad) throws SQLException{
        String sql = "INSERT INTO `advertise`( `prod_id`, `images`, `state`) VALUES (?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, ad.getProdId());
        pstmt.setString(2, ad.getImages());
        pstmt.setInt(3, ad.getState());
        return pstmt.executeUpdate();
    }
    
}
