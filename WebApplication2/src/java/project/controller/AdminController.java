/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import project.api.ProductAPI;
import project.config.MyConstants;
import project.config.SendMailSSL;
import project.dto.Advertise;
import project.dto.Info;
import project.dto.OrderItems;
import project.dto.OrderStatus;
import project.dto.Orders;
import project.dto.Prod_detail;
import project.dto.Prod_images;
import project.dto.Products;
import project.dto.Users;
import project.model.ProductModel;
import project.model.UserModel;

/**
 *
 * @author thonglt
 */
@Controller
public class AdminController {

    @RequestMapping("/admin/home")
    public String index(Model model) throws ClassNotFoundException, SQLException {
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
        return "admin/index";
    }

    @RequestMapping("/admin/revenue")
    public String revenua(Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
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
        int year = localDate.getYear();
        List<Orders> listOrderDoneByYear = pm.getAllOrderDoneByYear(year);
        for (Orders orders : listOrderDoneByYear) {
            orders.setOrderItems(pm.getOrderItemByOrderId(orders.getId()));
        }

        model.addAttribute("date", date);
        model.addAttribute("month", month);
        model.addAttribute("listOrderDoneByDate", listOrderDoneByDate);
        model.addAttribute("listOrderDoneByYear", listOrderDoneByYear);
        model.addAttribute("listOrderDoneByMonth", listOrderDoneByMonth);
        return "admin/revenue";
    }

    @RequestMapping("/admin/order")
    public String order(Model model) throws ClassNotFoundException, SQLException {

        List<Orders> listOrder = new ArrayList<>();
        listOrder = new ProductModel().getAllOrder();
        for (Orders orders : listOrder) {
            orders.setOs(new ProductModel().getOrderStatusById(orders.getOrderStatus()));
            orders.setUsers(new UserModel().getUserById(orders.getUserId()));
            orders.getUsers().setInfo(new UserModel().getInfoById(orders.getUsers().getId()));
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }

        model.addAttribute("listOrder", listOrder);
        return "admin/order";
    }

    @RequestMapping("/admin/order/done")
    public String orderDone(Model model) throws ClassNotFoundException, SQLException {

        List<Orders> listOrder = new ArrayList<>();
        listOrder = new ProductModel().getAllOrderDone();
        for (Orders orders : listOrder) {
            orders.setOs(new ProductModel().getOrderStatusById(orders.getOrderStatus()));
            orders.setUsers(new UserModel().getUserById(orders.getUserId()));
            orders.getUsers().setInfo(new UserModel().getInfoById(orders.getUsers().getId()));
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }

        model.addAttribute("listOrder", listOrder);
        return "admin/orderDone";
    }

    @RequestMapping("/admin/order/cancel")
    public String orderCancel(Model model) throws ClassNotFoundException, SQLException {

        List<Orders> listOrder = new ArrayList<>();
        listOrder = new ProductModel().getAllOrderCancel();
        for (Orders orders : listOrder) {
            orders.setOs(new ProductModel().getOrderStatusById(orders.getOrderStatus()));
            orders.setUsers(new UserModel().getUserById(orders.getUserId()));
            orders.getUsers().setInfo(new UserModel().getInfoById(orders.getUsers().getId()));
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }

        model.addAttribute("listOrder", listOrder);
        return "admin/orderCancel";
    }

    @RequestMapping("/admin/order/view/{idOrder}")
    public String orderDetail(@PathVariable("idOrder") String idOrder, Model model) throws ClassNotFoundException, SQLException {
        Orders orders = new ProductModel().getOrderById(idOrder);
        orders.setUsers(new UserModel().getUserById(orders.getUserId()));
        orders.getUsers().setInfo(new UserModel().getInfoById(orders.getUserId()));
        orders.setOrderItems(new ProductModel().getOrderItemByOrderId(idOrder));
        for (OrderItems items : orders.getOrderItems()) {
            items.setProd(new ProductModel().getProdById(items.getProdId()));
        }
        model.addAttribute("orders", orders);

        return "admin/deltailOrder";
    }

    @RequestMapping("/admin/order/state/{idOrder}")
    public String state(@PathVariable("idOrder") String idOrder, Model model) throws ClassNotFoundException, SQLException {
        Orders o = new ProductModel().getOrderById(idOrder);
        if (o.getOrderStatus() == 1) {
            int rsSet = new ProductModel().setOrderStatus(idOrder, 2, new Date(System.currentTimeMillis()));
            model.addAttribute("rsSet", rsSet);
        } else if (o.getOrderStatus() == 2) {
            o.setOrderItems(new ProductModel().getOrderItemByOrderId(idOrder));
            Users u = new UserModel().getUserById(o.getUserId());
            Info info = new UserModel().getInfoById(u.getId());
            for (OrderItems items : o.getOrderItems()) {
                items.setProd(new ProductModel().getProdById(items.getProdId()));
                new ProductModel().setQuantityStoreByProdId(items.getProdId(),
                        items.getProd().getQuantityStore() - items.getQuantity());
            }
            String subject = "Thông báo giao hàng thành công";
            String content = "Đơn hàng " + o.getId() + " đã được giao thành công "
                    + MyConstants.orderConfirm(u.getUsername(), info, o, o.getOrderItems());
            SendMailSSL.sendmail(subject, content, u.getUsername());
            int rsSet = new ProductModel().setOrderStatus(idOrder, 3, new Date(System.currentTimeMillis()));

            model.addAttribute("rsSet", rsSet);
        } else {
            int rsDel = new ProductModel().setOrderStatus(idOrder, 5, new Date(System.currentTimeMillis()));
            model.addAttribute("rsDel", rsDel);
        }
        List<Orders> listOrder = new ArrayList<>();
        listOrder = new ProductModel().getAllOrder();
        for (Orders orders : listOrder) {
            orders.setOs(new ProductModel().getOrderStatusById(orders.getOrderStatus()));
            orders.setUsers(new UserModel().getUserById(orders.getUserId()));
            orders.getUsers().setInfo(new UserModel().getInfoById(orders.getUsers().getId()));
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }

        model.addAttribute("listOrder", listOrder);
        return "admin/order";
    }
    

    @RequestMapping("/admin/order/delOrder")
    public String delOrder(HttpServletRequest req, Model model) throws ClassNotFoundException, SQLException {
        String idOrder = req.getParameter("idOrder");
        String reason = req.getParameter("reason");
        Orders o = new ProductModel().getOrderById(idOrder);
        o.setOrderItems(new ProductModel().getOrderItemByOrderId(idOrder));
        o.setUsers(new UserModel().getUserById(o.getUserId()));
        o.getUsers().setInfo(new UserModel().getInfoById(o.getUserId()));
        for (OrderItems items : o.getOrderItems()) {
            items.setProd(new ProductModel().getProdById(items.getProdId()));
        }
        String subject = "Thông báo hủy đơn hàng " + idOrder;

        String content = "<p>" + reason + "</p>" + MyConstants.orderConfirm(o.getUsers().getUsername(),
                o.getUsers().getInfo(), o, o.getOrderItems()) + "<p>Một lần nữa chúng tôi xin lỗi quý khách. </p>";
        SendMailSSL.sendmail(subject, content, o.getUsers().getUsername());

        int rsCancel = new ProductModel().setOrderStatus(idOrder, 4, new Date(System.currentTimeMillis()));
        model.addAttribute("rsCancel", rsCancel);
        List<Orders> listOrder = new ArrayList<>();
        listOrder = new ProductModel().getAllOrder();
        for (Orders orders : listOrder) {
            orders.setOs(new ProductModel().getOrderStatusById(orders.getOrderStatus()));
            orders.setUsers(new UserModel().getUserById(orders.getUserId()));
            orders.getUsers().setInfo(new UserModel().getInfoById(orders.getUsers().getId()));
            orders.setOrderItems(new ProductModel().getOrderItemByOrderId(orders.getId()));
        }

        model.addAttribute("listOrder", listOrder);
        return "admin/order";
    }

    @RequestMapping("/admin/user")
    public String user(Model model) throws ClassNotFoundException, SQLException {
        List<Users> listUser = new ArrayList<>();
        listUser = new UserModel().getUserByLimit(5, 0);

        int totalPage = 0;
        int recordPerPage = 5;
        int count = new UserModel().sumUser();
        totalPage = (int) Math.floor(count / recordPerPage) + 1;
        model.addAttribute("totalPage", totalPage);

        model.addAttribute("listUser", listUser);
        return "admin/users";
    }

    @RequestMapping("/admin/user/actived/{id}")
    public String activedUser(@PathVariable("id") String id, Model model) throws ClassNotFoundException, SQLException {
        Users users = new Users();
        users = new UserModel().getUserById(id);
        if (users.getActived() == 1) {
            int rs = new UserModel().setActived(id, 0);
        } else {
            int rs = new UserModel().setActived(id, 1);
        }
        List<Users> listUser = new ArrayList<>();
        listUser = new UserModel().getUserByLimit(5, 0);

        int totalPage = 0;
        int recordPerPage = 5;
        int count = new UserModel().sumUser();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("totalPage", totalPage);

        model.addAttribute("listUser", listUser);
        return "admin/users";
    }

    @RequestMapping("/admin/user/del/{id}")
    public String delUser(@PathVariable("id") String id, Model model) throws ClassNotFoundException, SQLException {
        int rs = new UserModel().delUser(id);
        List<Users> listUser = new ArrayList<>();
        listUser = new UserModel().getUserByLimit(5, 0);

        int totalPage = 0;
        int recordPerPage = 5;
        int count = new UserModel().sumUser();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("rs", rs);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listUser", listUser);
        return "admin/users";
    }

    @RequestMapping(value = "/admin/user/", params = "page")
    public String user(@RequestParam("page") int page, Model model) throws ClassNotFoundException, SQLException {
        List<Users> listUser = new ArrayList<>();
        int totalPage = 0;
        int recordPerPage = 5;
        int currPage = page;
        int count = new UserModel().sumUser();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("curr", currPage);
        listUser = new UserModel().getUserByLimit(recordPerPage, recordPerPage * (currPage - 1));
        model.addAttribute("listUser", listUser);
        return "admin/users";
    }

    @RequestMapping("/admin/product")
    public String product(Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        List<Products> listProd = new ArrayList<>();
        List<Prod_detail> listDetail = new ArrayList<>();
        listProd = pm.getAll(3, 0);
        listDetail = pm.getAllDetail();
        int totalPage = 0;
        int recordPerPage = 3;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        model.addAttribute("listDetail", listDetail);
        return "admin/product";
    }

    @RequestMapping(value = "/admin/product/", params = "page")
    public String product(@RequestParam("page") int page, Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        List<Products> listProd = new ArrayList<>();
        int totalPage = 0;
        int recordPerPage = 3;
        int currPage = page;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        listProd = pm.getAll(recordPerPage, recordPerPage * (currPage - 1));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("sumProd", count);
        model.addAttribute("listProd", listProd);
        model.addAttribute("curr", currPage);
        return "admin/product";
    }

    @RequestMapping("/admin/product/del/{id}")
    public String delProd(@PathVariable("id") int id, Model model) throws ClassNotFoundException, SQLException {
        int rs = new ProductModel().delProd(id);
        List<Products> listProd = new ArrayList<>();
        listProd = new ProductModel().getAll(3, 0);

        int totalPage = 0;
        int recordPerPage = 3;
        int count = new ProductModel().sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("rsDel", rs);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        return "admin/product";
    }

    @RequestMapping("/admin/product/update/{id}")
    public String updateProd(@PathVariable("id") int id, Model model) throws ClassNotFoundException, SQLException {
        Products prod = new Products();
        prod = new ProductModel().getProdById(id);

        if (prod.getKind_id() != 4 && prod.getKind_id() != 5) {
            Prod_detail pd = new Prod_detail();
            pd = new ProductModel().getProdDetailById(id);
            model.addAttribute("prodDetail", pd);
        }

        model.addAttribute("prod", prod);

        return "admin/updateProd";
    }

    @RequestMapping("/admin/product/images/{id}")
    public String imagesProd(@PathVariable("id") int id, Model model) throws ClassNotFoundException, SQLException {
        List<Prod_images> listProdImages = new ArrayList<>();
        listProdImages = new ProductModel().getListProdImageByProdId(id);

        Products products = new ProductModel().getProdById(id);
        model.addAttribute("products", products);
        model.addAttribute("listProdImages", listProdImages);

        return "admin/prodImages";
    }

    @RequestMapping("/admin/product/images/add-images/{idProd}")
    public String addImages(@PathVariable("idProd") int idProd, Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("idProd", idProd);
        return "admin/addImageProd";
    }

    @RequestMapping("/admin/product/images/update-images/{idProd}/{idImg}")
    public String updateImages(@PathVariable("idImg") int idImg,
            @PathVariable("idProd") int idProd,
            Model model) throws ClassNotFoundException, SQLException {
        Prod_images prod_images = new Prod_images();
        prod_images = new ProductModel().getProdImageById(idImg);
        model.addAttribute("idImg", idImg);
        model.addAttribute("idProd", idProd);
        model.addAttribute("prod_images", prod_images);
        return "admin/updateImageProd";
    }

    @RequestMapping("/admin/product/add-product")
    public String addProd(Model model) throws ClassNotFoundException, SQLException {

        return "admin/addProd";
    }

    @RequestMapping("/admin/product/images/add-images/addimages")
    public String addImages(@RequestParam CommonsMultipartFile file, Model model,
            HttpServletRequest req, HttpSession session) throws ClassNotFoundException, SQLException {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        int idProd = Integer.parseInt(req.getParameter("idProd"));
        ProductModel pm = new ProductModel();
        //add images
        Prod_images p = new Prod_images();
        p.setProd_id(idProd);
        p.setImage(filename);
        p.setName(req.getParameter("color"));
        int rsAdd = pm.addProdImages(p);
        model.addAttribute("rsAdd", rsAdd);
        //ghi file
        try {
            BufferedOutputStream bos
                    = new BufferedOutputStream(
                            new FileOutputStream(path + "WEB-INF/resources/images/ " + filename));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
        }
        List<Prod_images> listProdImages = new ArrayList<>();
        listProdImages = new ProductModel().getListProdImageByProdId(idProd);

        Products products = new ProductModel().getProdById(idProd);
        model.addAttribute("products", products);
        model.addAttribute("listProdImages", listProdImages);
        return "admin/prodImages";
    }

    @RequestMapping("/admin/product/images/update-images/{idProd}/updateimages")
    public String updateImages(@RequestParam CommonsMultipartFile file,
            @PathVariable("idProd") int idProd, Model model,
            HttpServletRequest req, HttpSession session) throws ClassNotFoundException, SQLException {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        ProductModel pm = new ProductModel();
        //add images
        Prod_images p = new Prod_images();
        p.setId(Integer.parseInt(req.getParameter("idImg")));
        p.setImage(filename);
        p.setName(req.getParameter("color"));
        int rsSet = pm.updateProdImages(p);
        model.addAttribute("rsSet", rsSet);
        //ghi file
        try {
            BufferedOutputStream bos
                    = new BufferedOutputStream(
                            new FileOutputStream(path + "WEB-INF/resources/images/ " + filename));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
        }
        List<Prod_images> listProdImages = new ArrayList<>();
        listProdImages = new ProductModel().getListProdImageByProdId(idProd);

        Products products = new ProductModel().getProdById(idProd);
        model.addAttribute("products", products);
        model.addAttribute("listProdImages", listProdImages);
        return "admin/prodImages";
    }

    @RequestMapping("/admin/product/images/del-images/{idProd}/{idImg}")
    public String delImages(@PathVariable("idProd") int idProd,
            @PathVariable("idImg") int idImg, Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        int rsDel = pm.delProdImages(idImg);
        model.addAttribute("rsDel", rsDel);

        List<Prod_images> listProdImages = new ArrayList<>();
        listProdImages = new ProductModel().getListProdImageByProdId(idProd);

        Products products = new ProductModel().getProdById(idProd);
        model.addAttribute("products", products);
        model.addAttribute("listProdImages", listProdImages);
        return "admin/prodImages";
    }

    @RequestMapping("/admin/product/addprod")
    public String addProd(@RequestParam CommonsMultipartFile file, Model model,
            HttpServletRequest req, HttpSession session) throws ClassNotFoundException, SQLException {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        //Tao ID
        int idProd;
        Random rng = new Random();
        Products pID = null;
        ProductModel pm = new ProductModel();
        do {
            idProd = rng.nextInt(1000) + 8999;
            pID = pm.getProdById(idProd);
        } while (pID != null);
        //add prod
        Products p = new Products();
        p.setId(idProd);
        p.setKind_id(Integer.parseInt(req.getParameter("kind")));
        p.setName(req.getParameter("name"));
        p.setDescription(req.getParameter("description"));
        p.setPriceStore(Integer.parseInt(req.getParameter("priceStore")));
        p.setPrice(Integer.parseInt(req.getParameter("price")));
        p.setQuantityStore(Integer.parseInt(req.getParameter("quantityStore")));
        p.setDiscount(Integer.parseInt(req.getParameter("discount")));
        p.setImages(filename);
        int rsAddProd = pm.addProd(p);
        model.addAttribute("rsAddProd", rsAddProd);
        //add prod_detail
        if (Integer.parseInt(req.getParameter("kind")) != 4 && Integer.parseInt(req.getParameter("kind")) != 5) {
            Prod_detail pd = new Prod_detail();
            pd.setProdId(idProd);
            pd.setDisplay(Double.valueOf(req.getParameter("display")));
            pd.setOS(req.getParameter("os"));
            pd.setRam(Integer.parseInt(req.getParameter("ram")));
            pd.setRom(Integer.parseInt(req.getParameter("rom")));
            pd.setfCamera(Integer.parseInt(req.getParameter("fCamera")));
            pd.setbCamera(Integer.parseInt(req.getParameter("bCamera")));
            pd.setBattery(Integer.parseInt(req.getParameter("battery")));
            int addProdDetai = pm.addProdDetail(pd);
            model.addAttribute("addProdDetai", addProdDetai);
        }

        //ghi file
        try {
            BufferedOutputStream bos
                    = new BufferedOutputStream(
                            new FileOutputStream(path + "WEB-INF/resources/images/ " + filename));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
        }
        List<Products> listProd = new ArrayList<>();
        List<Prod_detail> listDetail = new ArrayList<>();
        listProd = pm.getAll(3, 0);
        listDetail = pm.getAllDetail();
        int totalPage = 0;
        int recordPerPage = 3;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        model.addAttribute("listDetail", listDetail);
        return "admin/product";
    }

    @RequestMapping("/admin/product/update/updateprod")
    public String updateProd(@RequestParam CommonsMultipartFile file, Model model,
            HttpServletRequest req, HttpSession session) throws ClassNotFoundException, SQLException {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        ProductModel pm = new ProductModel();
        //Tao ID
        //add prod
        Products p = new Products();
        p.setId(Integer.parseInt(req.getParameter("id")));
        p.setKind_id(Integer.parseInt(req.getParameter("kind")));
        p.setName(req.getParameter("name"));
        p.setDescription(req.getParameter("description"));
        p.setPriceStore(Integer.parseInt(req.getParameter("priceStore")));
        p.setPrice(Integer.parseInt(req.getParameter("price")));
        p.setQuantityStore(Integer.parseInt(req.getParameter("quantityStore")));
        p.setDiscount(Integer.parseInt(req.getParameter("discount")));
        p.setImages(filename);
        p.setUpdatedAt(new Date(System.currentTimeMillis()));
        int rsSetProd = pm.setProdById(p);
        model.addAttribute("rsSetProd", rsSetProd);
        //add prod_detail
        if (Integer.parseInt(req.getParameter("kind")) != 4 && Integer.parseInt(req.getParameter("kind")) != 5) {
            Prod_detail pd = new Prod_detail();
            pd.setProdId(Integer.parseInt(req.getParameter("id")));
            pd.setDisplay(Double.valueOf(req.getParameter("display")));
            pd.setOS(req.getParameter("os"));
            pd.setRam(Integer.parseInt(req.getParameter("ram")));
            pd.setRom(Integer.parseInt(req.getParameter("rom")));
            pd.setfCamera(Integer.parseInt(req.getParameter("fCamera")));
            pd.setbCamera(Integer.parseInt(req.getParameter("bCamera")));
            pd.setBattery(Integer.parseInt(req.getParameter("battery")));
            int addSetDetai = pm.setDetailByProdId(pd);
            model.addAttribute("addSetDetai", addSetDetai);
        }

        //ghi file
        try {
            BufferedOutputStream bos
                    = new BufferedOutputStream(
                            new FileOutputStream(path + "WEB-INF/resources/images/ " + filename));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
        }
        List<Products> listProd = new ArrayList<>();
        List<Prod_detail> listDetail = new ArrayList<>();
        listProd = pm.getAll(3, 0);
        listDetail = pm.getAllDetail();
        int totalPage = 0;
        int recordPerPage = 3;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        model.addAttribute("listDetail", listDetail);
        return "admin/product";
    }

    @RequestMapping("/admin/product/state/{idProd}")
    public String state(@PathVariable("idProd") int idProd, Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        Products p = pm.getProdById(idProd);
        if (p.getActived() == 1) {
            int rsSetState = pm.setStateByIdProd(0, idProd);
            model.addAttribute("rsSetState", rsSetState);
        } else {
            int rsSetState = pm.setStateByIdProd(1, idProd);
            model.addAttribute("rsSetState", rsSetState);
        }
        List<Products> listProd = new ArrayList<>();
        List<Prod_detail> listDetail = new ArrayList<>();
        listProd = pm.getAll(3, 0);
        listDetail = pm.getAllDetail();
        int totalPage = 0;
        int recordPerPage = 3;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        model.addAttribute("listDetail", listDetail);
        return "admin/product";
    }
    
    @RequestMapping("/admin/product/sell/{idProd}")
    public String sell(@PathVariable("idProd") int idProd, Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        Products p = pm.getProdById(idProd);
        if (p.getSell()== 1) {
            int rsSetSell = pm.setSellByIdProd(0, idProd);
            model.addAttribute("rsSetSell", rsSetSell);
        } else {
            int rsSetSell = pm.setSellByIdProd(1, idProd);
            model.addAttribute("rsSetSell", rsSetSell);
        }
        List<Products> listProd = new ArrayList<>();
        List<Prod_detail> listDetail = new ArrayList<>();
        listProd = pm.getAll(3, 0);
        listDetail = pm.getAllDetail();
        int totalPage = 0;
        int recordPerPage = 3;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        model.addAttribute("listDetail", listDetail);
        return "admin/product";
    }

    @RequestMapping("admin/product/add-quantity/{idProd}")
    public String addQuantity(@PathVariable("idProd") int idProd, HttpServletRequest req, Model model) throws ClassNotFoundException, SQLException {
        ProductModel pm = new ProductModel();
        Products p = pm.getProdById(idProd);
        int quantity = Integer.parseInt(req.getParameter("q" + idProd));
        int rsAdd = pm.setQuantityStoreByProdId(idProd, (p.getQuantityStore() + quantity));
        model.addAttribute("rsAdd", rsAdd);
        List<Products> listProd = new ArrayList<>();
        List<Prod_detail> listDetail = new ArrayList<>();
        listProd = pm.getAll(3, 0);
        listDetail = pm.getAllDetail();
        int totalPage = 0;
        int recordPerPage = 3;
        int count = pm.sumProd();
        if ((count % recordPerPage) == 0) {
            totalPage = (int) count / recordPerPage;
        } else {
            totalPage = (int) Math.floor(count / recordPerPage) + 1;
        }
        model.addAttribute("sumProd", count);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("listProd", listProd);
        model.addAttribute("listDetail", listDetail);
        return "admin/product";
    }

    @RequestMapping("/admin/advertise")
    public String advertise(Model model) throws ClassNotFoundException, SQLException {
        List<Advertise> list = new ProductModel().getAdvertise();
        for (Advertise advertise : list) {
            advertise.setProd(new ProductModel().getProdById(advertise.getProdId()));
        }
        List<Products> listProd = new ProductModel().getAllActive();
        model.addAttribute("listProd", listProd);
        model.addAttribute("listAd", list);
        return "admin/advertise";
    }

    @RequestMapping("/admin/advertise/del-advertise/{idAd}")
    public String delAdvertise(@PathVariable("idAd") int idAd, Model model) throws ClassNotFoundException, SQLException {
        int rsDel = new ProductModel().delAdById(idAd);
        model.addAttribute("rsDel", rsDel);

        List<Advertise> list = new ProductModel().getAdvertise();
        for (Advertise advertise : list) {
            advertise.setProd(new ProductModel().getProdById(advertise.getProdId()));
        }
        List<Products> listProd = new ProductModel().getAllActive();
        model.addAttribute("listProd", listProd);
        model.addAttribute("listAd", list);
        return "admin/advertise";
    }

    @RequestMapping("/admin/advertise/state-advertise/{idAd}")
    public String setStateAdvertise(@PathVariable("idAd") int idAd, Model model) throws ClassNotFoundException, SQLException {
        Advertise ad = new ProductModel().getAdvertiseById(idAd);
        if (ad.getState() == 1) {
            int rsSet = new ProductModel().setStateAdById(0, idAd);
            model.addAttribute("rsSet", rsSet);
        } else {
            int rsSet = new ProductModel().setStateAdById(1, idAd);
            model.addAttribute("rsSet", rsSet);
        }

        List<Advertise> list = new ProductModel().getAdvertise();
        for (Advertise advertise : list) {
            advertise.setProd(new ProductModel().getProdById(advertise.getProdId()));
        }
        List<Products> listProd = new ProductModel().getAllActive();
        model.addAttribute("listProd", listProd);
        model.addAttribute("listAd", list);
        return "admin/advertise";
    }

    @RequestMapping("/admin/advertise/add-advertise")
    public String addAdvertise(@RequestParam CommonsMultipartFile file, HttpServletRequest req, Model model, HttpSession session) throws ClassNotFoundException, SQLException {
        int idProd = Integer.parseInt(req.getParameter("product"));
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        //ghi file
        try {
            BufferedOutputStream bos
                    = new BufferedOutputStream(
                            new FileOutputStream(path + "WEB-INF/resources/images/ " + filename));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
        }
        Advertise ad = new Advertise();
        ad.setProdId(idProd);
        ad.setState(1);
        ad.setImages(filename);
        int rsAdd = new ProductModel().addAdvertise(ad);
        model.addAttribute("rsAdd", rsAdd);
        List<Advertise> list = new ProductModel().getAdvertise();
        for (Advertise advertise : list) {
            advertise.setProd(new ProductModel().getProdById(advertise.getProdId()));
        }
        List<Products> listProd = new ProductModel().getAllActive();
        model.addAttribute("listProd", listProd);
        model.addAttribute("listAd", list);
        return "admin/advertise";
    }
    
    @RequestMapping(value = "/admin/info", method = RequestMethod.GET)
    public String info( Model model) throws ClassNotFoundException, SQLException {
        Info info = new UserModel().getInfoById("ADMIN");
        Users u = new UserModel().getUserById("ADMIN");

        info.setEmail(u.getUsername());
        model.addAttribute("infoUser", info);
        return "admin/info";
    }

    @RequestMapping(value = "admin/update-info", method = RequestMethod.POST)
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
        return "admin/info";
    }
    


}
