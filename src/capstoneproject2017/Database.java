/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstoneproject2017;

/**
 *
 * @author Travis Lawson and group members
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Database {

    //establishing Database connection
    static final String DB_LOCATION = "jdbc:sqlserver://50.63.178.68:49172;databaseName=SSaleFish";
    static final String DB_USER = "AlvaradoC0700";
    static final String DB_PASSWORD = "1Password!";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    //insert test table
    public void InsertTestTable(String testName, String testDate, double testDecimal, int testInt) {
        try {
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            java.util.Date dt;
            java.sql.Date dtSql;
            try {
                dt = sdf.parse(testDate);
                dtSql = new java.sql.Date(dt.getTime());
                String sql = "INSERT INTO Test VALUES ('" + testName + "', '" + dtSql + "', '" + testDecimal + "', '" + testInt + "')"; //may need to be chane
                statement.executeUpdate(sql);
            } catch (ParseException ex) {
                System.out.println("Parse failed.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Database connection failed");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    public void QueryTestTable() {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT * FROM Test"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    //insert methods
    public void InsertCustomer(String fName, String lName, String phone, String email) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO Customers(CustFName, CustLName, PhoneNum, EmailAdress) VALUES (?,?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setString(1, fName);
            prep.setString(2, lName);
            prep.setString(3, phone);
            prep.setString(4, email);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    public void InsertEmployee(String fName, String lName, String empType, String phone, String streetAddress, String city, String stateCode, String zip, String statusCode) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO Employees(EmpFName, EmpLName, EmployeeType, PhoneNum, StreetAddress, CityName, StateCode, ZipCode, EmpStatusCode) VALUES (?,?,?,?,?,?,?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setString(1, fName);
            prep.setString(2, lName);
            prep.setString(3, empType);
            prep.setString(4, phone);
            prep.setString(5, streetAddress);
            prep.setString(6, city);
            prep.setString(7, stateCode);
            prep.setString(8, zip);
            prep.setString(9, statusCode);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    public void InsertEmployeeLogin(int employeeID, String username, String password) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO EmployeeLogin(EmpID, UserID, Password) VALUES (?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setInt(1, employeeID);
            prep.setString(2, username);
            prep.setString(3, password);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    public void InsertCustomerLogin(String username, String password, int customerID) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO CustomerLogin(CustID, UserID, Password) VALUES (?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setInt(1, customerID);
            prep.setString(2, username);
            prep.setString(3, password);

            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    public void InsertVendor(String name, String streetAddress, String city, String stateCode, String zip, String phone) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO Vendors(VendorName, VendorStreetAddress, VendorCityName, VendorStateCode, VendorZipCode, VendorPhone) VALUES (?,?,?,?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setString(1, name);
            prep.setString(2, streetAddress);
            prep.setString(3, city);
            prep.setString(4, stateCode);
            prep.setString(5, zip);
            prep.setString(6, phone);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    /**
     * *
     * This is updating the item that was clicked
     *
     * @param LookupID
     * @param title
     * @param authorLName
     * @param authorFName
     * @param price
     * @param quantity
     * @param publishDate
     * @param publisher
     */
    public void InsertComicInventory(String LookupID, String title, String authorLName, String authorFName, double price, int quantity, String publishDate, String publisher) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
            java.util.Date dt;
            java.sql.Date pdSQL;
            try {
                dt = sdf.parse(publishDate);
                pdSQL = new java.sql.Date(dt.getTime());

                String sql = "INSERT INTO ComicsInventory(ComicTitle, ComicPrice, ComicQuantity, PublishDate, ComicAuthorFName, ComicAuthorLName, Publisher, LookupCode) VALUES (?,?,?,?,?,?,?,?)"; //may need to be changed
                prep = (PreparedStatement) connection.prepareStatement(sql);
                prep.setString(1, title);
                prep.setDouble(2, price);
                prep.setInt(3, quantity);
                prep.setDate(4, pdSQL); //might not work
                prep.setString(5, authorFName);
                prep.setString(6, authorLName);
                prep.setString(7, publisher);
                prep.setString(8, LookupID);
                prep.executeUpdate();

            } catch (ParseException ex) {
                System.out.println("Parse failed.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    public void InsertMiscInventory(int LookupCode, String productName, double price, int quantity) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO MiscInventory(LookupCode, ProductName, ProductPrice, ProductQuantity) VALUES (?,?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setInt(1, LookupCode);
            prep.setString(2, productName);
            prep.setDouble(3, price);
            prep.setInt(4, quantity);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    //made into a boolean because I need to know if the transaction was successfully created before I attempt to add transaction line items with the SQL procedure
    public boolean InsertTransaction(double amount, int employeeID) {
        boolean worked = false;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        //java.util.Date date;
        java.sql.Date dateSql;
        //try {
        //date = df.parse(LocalDateTime.now().toString());
        dateSql = new java.sql.Date(System.currentTimeMillis());

        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "INSERT INTO Transactions(TransAmount, TransDate, EmpID) VALUES (?,?,?)"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setDouble(1, amount);
            prep.setDate(2, dateSql);
            prep.setInt(3, employeeID);
            prep.executeUpdate();

            worked = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the transaction was not properly created in the database. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        //} catch (ParseException ex) {
        //JOptionPane.showMessageDialog(null, "Unable to pull current date from the system. ");
        //}
        return worked;
    }

    public void InsertProcedureTransLineItem(int ComicID, int InventoryID, int Quantity) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "{call sp_InsertInto_TransLineItem(?,?,?)}"; //may need to be changed
            prep = connection.prepareStatement(sql);
            prep.setInt(1, ComicID);
            prep.setInt(2, InventoryID);
            prep.setInt(3, Quantity);
            prep.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the items from this transaction were unable to be added to the database. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    //Query methods
    /*
     * Checking to see if the username matches anyones in the Database
     */
    public boolean QueryUsernameExists(String username) {
        boolean exists = false;
        try {

            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT * FROM EmployeeLogin WHERE UserID = '" + username + "'"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return exists;
    }

    public int QueryNewEmployeeID() {
        int empID = 0;
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT TOP 1 EmpID FROM Employees ORDER BY EmpID DESC"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                empID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return empID;
    }

    public String QueryLoggedInEmployeeName(int ID) {
        String name = "";
        try {

            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT EmpFName FROM Employees WHERE EmpID = '" + ID + "'"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                name = rs.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return name;
    }

    public String QueryEmployeePassword(String username) {
        String password = "";
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT Password FROM EmployeeLogin WHERE UserID = '" + username + "'"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                password = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }

        return password;
    }

    public int QueryEmpID(String username) {

        int empID = 0;
        try {

            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT EmpID FROM EmployeeLogin WHERE UserID = '" + username + "'"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                empID = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return empID;

    }

    public boolean isActiveEmployee(String username) {

        boolean isActiveEmployee = false;
        int EmpID = 0;
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT EmpID FROM EmployeeLogin WHERE UserID = '" + username + "'"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                EmpID = rs.getInt(1);
            }

            sql = "SELECT EmpStatusCode FROM Employees WHERE EmpID = '" + EmpID + "'";
            prep = (PreparedStatement) connection.prepareStatement(sql);
            rs = prep.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals("AC")) {
                    isActiveEmployee = true;
                } else {
                    isActiveEmployee = false;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return isActiveEmployee;

    }

    /*
     * 
     */
    public boolean isManager(String username) {
        boolean isManager = false;
        int managerID = 0;
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT EmpID FROM EmployeeLogin WHERE UserID = '" + username + "'"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                managerID = rs.getInt(1);
            }

            sql = "SELECT EmployeeType FROM Employees WHERE EmpID = '" + managerID + "'";
            prep = (PreparedStatement) connection.prepareStatement(sql);
            rs = prep.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals("MG")) {
                    isManager = true;
                } else {
                    isManager = false;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return isManager;
    }

    public List<TransactionItem> QueryCustomOrderLineItems(int customOrderID) {
        List<TransactionItem> holdItems = new ArrayList<>();
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT ItemQuantity, InventoryID, ComicID FROM CustomOrderLineItem WHERE CustomOrderID = " + customOrderID; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            String nameOrTitle = "";
            double price = 0;
            int quantity;
            int comicID = 0;
            int inventoryID = 0;
            Object comID;
            Object invID;

            while (rs.next()) {
                quantity = rs.getInt(1);
                invID = rs.getObject(2);
                comID = rs.getObject(3);

                if (invID != null) {
                    inventoryID = Integer.parseInt(invID.toString());
                }
                if (comID != null) {
                    comicID = Integer.parseInt(comID.toString());
                }

                if (inventoryID == 0) {
                    sql = "SELECT ComicTitle, ComicPrice FROM ComicsInventory WHERE ComicID = " + comicID;
                    prep = (PreparedStatement) connection.prepareStatement(sql);
                    ResultSet rs2 = prep.executeQuery();

                    if (rs2.next()) {
                        nameOrTitle = rs2.getString(1);
                        price = rs2.getDouble(2);
                    }

                    if (price > 0) {
                        holdItems.add(new TransactionItem(nameOrTitle, price, quantity, comicID, inventoryID));
                    }
                } else if (comicID == 0) {
                    sql = "SELECT ProductName, ProductPrice FROM MiscInventory WHERE InventoryID = " + inventoryID;
                    prep = (PreparedStatement) connection.prepareStatement(sql);
                    ResultSet rs2 = prep.executeQuery();

                    if (rs2.next()) {
                        nameOrTitle = rs2.getString(1);
                        price = rs2.getDouble(2);
                    }

                    if (price > 0) {
                        holdItems.add(new TransactionItem(nameOrTitle, price, quantity, comicID, inventoryID));
                    } else {

                    }
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Conversion failed. Held items were not added to the transaction. ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not able to be accessed. Held items were not added to the transaction. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
        return holdItems;
    }

    //Update methods
    public void UpdateEmployee(String fName, String lName, String empType, String phone, String streetAddress, String city, String stateCode, String zip, String statusCode, String ID) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "UPDATE Employees SET EmpFName = ?, EmpLName = ?, EmployeeType = ?, PhoneNum = ?, StreetAddress = ?, CityName = ?, StateCode = ?, ZipCode = ?, EmpStatusCode = ? WHERE EmpID = ?"; //may need to be changed
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setString(1, fName);
            prep.setString(2, lName);
            prep.setString(3, empType);
            prep.setString(4, phone);
            prep.setString(5, streetAddress);
            prep.setString(6, city);
            prep.setString(7, stateCode);
            prep.setString(8, zip);
            prep.setString(9, statusCode);
            prep.setString(10, ID);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

    /**
     * Updating comic in inv
     *
     * clicking the save button
     *
     */
    public void UpdateComicInventory(int LookupID, String title, String authorLName, String authorFName, double price, int quantity, String publishDate, String publisher, int ComicID) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        java.util.Date dt;
        java.sql.Date dtSql;

        try {

            dt = sdf.parse(publishDate);
            dtSql = new java.sql.Date(dt.getTime());

            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "UPDATE ComicsInventory SET LookupCode=?, ComicTitle=?, ComicPrice=?, ComicQuantity=?, PublishDate=?, ComicAuthorFName=?, ComicAuthorLName=?, Publisher=? WHERE ComicID = ?";
            prep = (PreparedStatement) connection.prepareStatement(sql);
            prep.setInt(1, LookupID);
            prep.setString(2, title);
            prep.setDouble(3, price);
            prep.setInt(4, quantity);
            prep.setDate(5, dtSql);
            prep.setString(6, authorFName);
            prep.setString(7, authorLName);
            prep.setString(8, publisher);
            prep.setInt(9, ComicID);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. " + ex);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Fail" + e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. " + ex);
            }
        }
    }

    /**
     * updating the selected misc inventory clicking save
     *
     */
    public void UpdateMiscInventory(int InventoryID, int LookupID, String ProductName, double ProductPrice, int ProductQuantity) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String updateSQL = "UPDATE MiscInventory SET LookupCode = ?, ProductName = ?, ProductPrice = ?, ProductQuantity = ? WHERE InventoryID = ?";
            prep = (PreparedStatement) connection.prepareStatement(updateSQL);

            prep.setInt(1, LookupID);
            prep.setString(2, ProductName);
            prep.setDouble(3, ProductPrice);
            prep.setInt(4, ProductQuantity);
            prep.setInt(5, InventoryID);
            prep.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the table was not properly updated. " + ex);
        } finally {
            //close all connections
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not closed. " + ex);
            }
        }

    }

    //delete method
    public void DeleteHoldsProcedure(int holdID) {
        try {
            PreparedStatement prep = null;
            connection = DriverManager.getConnection(DB_LOCATION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            String sql = "{call sp_DeleteHolds(?)}"; //may need to be changed
            prep = connection.prepareStatement(sql);
            prep.setInt(1, holdID);
            prep.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection failed or the hold that was processed in this transaction was not removed from the database. ");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database not properly closed. ");
            }
        }
    }

}
