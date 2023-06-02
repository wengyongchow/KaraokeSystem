/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Chow weng yong
 */
public class Booking {
    private static int nextBookingID = 1001;
    private int bookingID;
    private String user;
    private String date;
    private String time;
    private int quantity;
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Booking(){
        
    }
    
    public Booking(String user, int quantity){
        this.user = user;
        this.quantity = quantity;
        this.bookingID = nextBookingID++;
    }
    
    public Booking(String user, int quantity, String date, String time){
        this.user = user;
        this.quantity = quantity;
        this.date = date;
        this.time = time;
        this.bookingID = nextBookingID++;
    }
    
    public int getBookingID() {
        return this.bookingID;
    }
    
    public void display(){
        System.out.print("Your Booking ID : " + this.bookingID);
    }

//    public void setBookingID(int bookingID) {
//        this.bookingID = bookingID;
//    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
   
}
