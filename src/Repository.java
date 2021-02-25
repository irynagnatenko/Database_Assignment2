import java.sql.*;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 11:55 AM
 * Project Database
 */
public class Repository {
    private Connection con;
    private Properties p = new Properties();


    Repository() {
        try {
            p.load(new FileInputStream("src/settings.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get all brands
/*    public List<Brand> getAllBrands() {
        List<Brand> allBrands = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement(); // why couldn't I use getStatement? Is there any difference between get and create?
            ResultSet rs = stmt.executeQuery("select * from Brand");

            while (rs.next()) {

                int id = rs.getInt("Id");
                String brandName = rs.getString("brandName");

                allBrands.add(new Brand(id, brandName));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allBrands;
    }
*/

    // get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");

            while (rs.next()) {

                int id = rs.getInt("Id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                int cityId = rs.getInt("cityId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");


                allCustomers.add(new Customer(id, name, lastName, cityId, userName, password));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCustomers;
    }

    // get all orders
    public List<Orders> getAllOrders() {
        List<Orders> allOrders = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from orders");

            while (rs.next()) {

                int id = rs.getInt("id");
                int customerId = rs.getInt("customerId");
                Date orderDate = rs.getDate("orderDate");

                allOrders.add(new Orders(id, customerId, orderDate));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allOrders;
    }

    // get all shoes in stock
    public List<ShoesInStock> getAllShoes() {

        List<ShoesInStock> allShoesInStock = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct brand.id as brandId, brand.brandName, size.sizeName, size.id as sizeId, color.id as colorId, " +
                    "color.colorName, shoes.id as shoeId, shoes.shoeStock from Shoes\n" +
                    "join brand\n" +
                    "on brand.id = shoes.brandId\n" +
                    "join size\n" +
                    "on size.id = shoes.sizeId\n" +
                    "join color \n" +
                    "on color.id = shoes.colorId\n" +
                    "join shoeCategory\n" +
                    "on shoeCategory.shoeId = Shoes.id\n" +
                    "join category \n" +
                    "on category.id = shoeCategory.categoryId\n" +
                    "where shoes.shoestock > 0;");

            while (rs.next()) {
                int brandId = rs.getInt("brandId");
                String brandName = rs.getString("brandName");
                int sizeId = rs.getInt("sizeId");
                String size = rs.getString("sizeName");
                int colorId = rs.getInt("colorId");
                String color = rs.getString("colorName");
                int shoeId = rs.getInt("shoeId");
                int amountLeft = rs.getInt("shoeStock");

                allShoesInStock.add(new ShoesInStock(brandId, brandName, sizeId, size, colorId, color, shoeId, amountLeft));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allShoesInStock;
    }

  /*  public List<Shoes> getAllShoesByOrderId(int orderId) {

        List<Shoes> allShoesById = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct * from Shoes\n" +
                    "join brand\n" +
                    "on brand.id = shoes.brandId\n" +
                    "join size\n" +
                    "on size.id = shoes.sizeId\n" +
                    "join color \n" +
                    "on color.id = shoes.colorId\n" +
                    "join orderInfo \n" +
                    "on orderInfo.shoeId = shoes.id\n" +
                    "where orderInfo.orderId = " + orderId +";");

            while (rs.next()) {

                int brandId = rs.getInt("brandId");
                int sizeId = rs.getInt("sizeId");
                int colorId = rs.getInt("colorId");
                int shoeId = rs.getInt("shoeId");
                int shoeStock = rs.getInt("shoeStock");
                double price = rs.getDouble("price");
                allShoesById.add(new Shoes( shoeId, brandId, sizeId, colorId, price, shoeStock));

            }
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return allShoesById;

    }
*/
    //get all shoes by order id
    public List<ShoesInStock> getAllShoesByOrderId(int orderId) {

        List<ShoesInStock> allShoesById = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select brand.id as brandId, brand.brandName, size.sizeName, size.id as sizeId, color.id as colorId, " +
                    "color.colorName, shoes.id as shoeId, shoes.shoeStock from Shoes\n" +
                    "join brand\n" +
                    "on brand.id = shoes.brandId\n" +
                    "join size\n" +
                    "on size.id = shoes.sizeId\n" +
                    "join color \n" +
                    "on color.id = shoes.colorId\n" +
                    "join orderInfo \n" +
                    "on orderInfo.shoeId = shoes.id\n" +
                    "where orderInfo.orderId = " + orderId +";");

            while (rs.next()) {
                int brandId = rs.getInt("brandId");
                String brandName = rs.getString("brandName");
                int sizeId = rs.getInt("sizeId");
                String size = rs.getString("sizeName");
                int colorId = rs.getInt("colorId");
                String color = rs.getString("colorName");
                int shoeId = rs.getInt("shoeId");
                int amountLeft = rs.getInt("shoeStock");

                allShoesById.add(new ShoesInStock(brandId, brandName, sizeId, size, colorId, color, shoeId, amountLeft));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allShoesById;
    }

    // AddToCart Function, returns integer
    public Integer addToCart_Func(int customerId, Integer orderId, int shoeId) {

        int result = 0;
        String query = "{? = call AddToCart_Func(?, ?, ?)}";

        try (Connection con = DriverManager.getConnection(p.getProperty("address"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)) {
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setInt(2, customerId);
            stmt.setNull(3, orderId);
            stmt.setInt(4, shoeId);

            stmt.execute();

        } catch(Exception throwables){
                throwables.printStackTrace();
            }

        return result;
        }


    // AddToCArt Procedure,
    public Integer addToCart_Proc(int customerId, Integer orderId, int shoeId) {

        ResultSet rs = null;
        String query = "call AddToCart_Proc(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(p.getProperty("address"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)) {

            stmt.setInt(1, customerId);
            stmt.setInt(2, orderId);
            stmt.setInt(3, shoeId);
            rs = stmt.executeQuery();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return orderId;
    }



    public void getCustomerByName (String inputUserName) {
        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer where customer.userName = " + inputUserName);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean isShoeInStock(String brandName, String size, String color, int amount) {
        boolean result = false;
        try {
            Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct brand.brandName, size.sizeName, color.colorName, shoes.shoeStock from Shoes\n" +
                    "join brand\n" +
                    "on brand.id = shoes.brandId\n" +
                    "join size\n" +
                    "on size.id = shoes.sizeId\n" +
                    "join color \n" +
                    "on color.id = shoes.colorId\n" +
                    "join shoeCategory\n" +
                    "on shoeCategory.shoeId = Shoes.id\n" +
                    "join category \n" +
                    "on category.id = shoeCategory.categoryId\n" +
                    "where brand.brandName = " + brandName +
                    "and size.sizeName = " + size +
                    "and color.colorName = " + color +
                    "and shoes.shoeStock >= " + amount + ";");

            int totalRows;
            rs.last();
            totalRows = rs.getRow();
            if (totalRows > 0) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public boolean UserExists(String userName, String password) {
        boolean result = false;

        String query = "{? = call isExistingUser(?, ?)}";
        try (Connection con = DriverManager.getConnection(p.getProperty("address"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            CallableStatement stmt = con.prepareCall(query)) {

                stmt.registerOutParameter(1, Types.BOOLEAN);
                stmt.setString(2, userName);
                stmt.setString(3, password);

                stmt.execute();

               result = stmt.getBoolean(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return result;
    }
}




