/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.config;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import project.dto.Info;
import project.dto.OrderItems;
import project.dto.Orders;

/**
 *
 * @author thonglt
 */
public class MyConstants {

    public static final String HOST_NAME = "smtp.gmail.com";

    public static final int SSL_PORT = 465; // Port for SSL

    public static final int TSL_PORT = 587; // Port for TLS/STARTTLS

    public static final String APP_EMAIL = "nstls9x@gmail.com"; // your email

    public static final String APP_PASSWORD = "082320178"; // your password

    public static final String RECEIVE_EMAIL = "lds2hc@gmail.com";

    public static String orderConfirm(String email, Info info,Orders o, List<OrderItems> list) {
        String content = "<p> <b>Cảm ơn quý khách "+info.getName()+" đã đặt hàng tại Apple Store</b></p>\n"
                + "        <h2>THÔNG TIN ĐƠN HÀNG "+o.getId()+" ( "+o.getOrderedAt()+" )</h2>\n"
                + "        <hr>\n"
                + "        <table>\n"
                + "            <tr>\n"
                + "                <td>\n"
                + "                    <p><b>Thông tin thanh toán</b><br/>\n"
                + "                        Họ tên: " + info.getName() + " <br/>\n"
                + "                        Email: " + email + " <br/>\n"
                + "                        SDT: " + info.getPhone() + " <br/>\n"
                + "                    </p>\n"
                + "                    \n"
                + "                </td>\n"
                + "                <td>\n"
                + "                    <p>\n"
                + "                        <b>Địa chỉ giao hàng</b> <br/>\n"
                + "                        Họ tên: " + info.getName() + " <br/>\n"
                + "                        Email: " + email + " <br/>\n"
                + "                        Địa chỉ: " + info.getAddress() + " <br/>\n"
                + "                        SDT: " + info.getPhone() + " <br/>\n"
                + "                    </p>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            \n"
                + "        </table>\n"
                + "        <h2>CHI TIẾT ĐƠN HÀNG</h2>\n"
                + "        <table>\n"
                + "            <tr>\n"
                + "                <th>Sản phẩm</th>\n"
                + "                <th>Đơn giá</th>\n"
                + "                <th>Số lượng</th>\n"
                + "                <th>Giảm giá</th>\n"
                + "                <th>Tổng tạm</th>\n"
                + "            </tr>\n";

        NumberFormat formatter;
    // Get number formatter for default locale
    formatter = NumberFormat.getInstance();
        
        String content2 = "";
        int tempTotal = 0;
        int tempDiscount = 0;
        for (OrderItems items : list) {
            int total = items.getQuantity() * items.getProd().getPrice();
            tempTotal += total;
            int discount = items.getQuantity() * items.getProd().getDiscount();
            tempDiscount += discount;
            content2 += "<tr>\n"
                    + "                <td>" + items.getProd().getDescription() + "</td>\n"
                    + "                <td>" + formatter.format(items.getProd().getPrice()) + " đ</td>\n"
                    + "                <td>" + items.getQuantity() + "</td>\n"
                    + "                <td>" + formatter.format(items.getProd().getDiscount()) + " đ</td>\n"
                    + "                <td>" + formatter.format((total - discount)) + " đ</td>\n"
                    + "            </tr>";
        }

        String content3 = "<tr>\n" +
"                <td colspan=\"4\" style=\"text-align: right\">\n" +
"                    Tổng tạm tính: \n" +
"                </td>  \n" +
"                <td>\n" +
"                    "+formatter.format(tempTotal)+" đ\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td colspan=\"4\" style=\"text-align: right\">\n" +
"                    Giảm giá: \n" +
"                </td>  \n" +
"                <td>\n" +
"                    - "+formatter.format(tempDiscount)+" đ\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <td colspan=\"4\" style=\"text-align: right\">\n" +
"                    <b>Tổng giá trị đơn hàng</b>: \n" +
"                </td>  \n" +
"                <td>\n" +
"                    <b>"+formatter.format((tempTotal - tempDiscount))+" đ</b>\n" +
"                </td>\n" +
"            </tr> "
                + " </table>\n"
                + "     <p><b>Một lần nữa Apple Store cảm ơn quý khách</b></p>";

        content += content2 + content3;

        return content;
    }

}
