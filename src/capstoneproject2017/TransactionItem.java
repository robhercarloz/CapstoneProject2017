/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstoneproject2017;

/**
 *
 * @author Travis Lawson
 */


public class TransactionItem {
    //attributes  //may need more or different ones
    //private String lookupID; //maybe not needed?
    private String nameOrTitle;
    private double price;
    private int quantity;
    private int comicID;
    private int inventoryID;
       
    //constructor
    public TransactionItem(String nameOrTitle, double price, int quantity, int comicID, int inventoryID) {  //maybe finished
        setNameOrTitle(nameOrTitle);
        setPrice(price);
        setQuantity(quantity);
        setComicID(comicID);
        setInventoryID(inventoryID);
    }
    
    //gets and sets 
    public String getNameOrTitle() {
        return nameOrTitle;
    }
    public void setNameOrTitle(String nameOrTitle) {
        this.nameOrTitle = nameOrTitle;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getComicID() {
        return comicID;
    }
    public void setComicID(int comicID) {
        this.comicID = comicID;
    }
    
    public int getInventoryID() {
        return inventoryID;
    }
    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }
     
    //override toString
    @Override
    public String toString() {
        String output = "";
        if (comicID != 0) {
            output = "Title: " + nameOrTitle + "     Quantity: " + quantity + "     Price: " + (quantity * price);
        } else if (inventoryID != 0) {
            output = "Product Name: " + nameOrTitle + "     Quantity: " + quantity + "     Price: " + (quantity * price);
        }
        return output;
    }
}
