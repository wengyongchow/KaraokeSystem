/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author CHEH ZHEN YU
 */
public class Member {

    LocalDateTime myDateObj = LocalDateTime.now(); // get the local time
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // set the local time format

    private int userID; //identity the ID
    private String name; //identity the name
    private String password; //identity the password
    private String gender; //identity the gender
    private String phoneNo; //identity the phone number
    private int bonusPoint; //identity the bonuspoint
    private String registerDateAndTime; //identity the register time/date
    private String description;//identity the status of the data

    //constuector
    public Member() {

    }

    public Member(int userID, String name, String description, String registerDateAndTime) {
        this.userID = userID;
        this.name = name;
        this.description = description;
        this.registerDateAndTime = registerDateAndTime;
    }

    public Member(int userID, String name, String password, String gender, String phoneNo, int bonusPoint, String registerDateAndTime, String description) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.bonusPoint = bonusPoint;
        this.registerDateAndTime = registerDateAndTime;
        this.description = description;
    }

    //getter and setter
    public LocalDateTime getMyDateObj() {
        return myDateObj;
    }

    public void setMyDateObj(LocalDateTime myDateObj) {
        this.myDateObj = myDateObj;
    }

    public DateTimeFormatter getMyFormatObj() {
        return myFormatObj;
    }

    public void setMyFormatObj(DateTimeFormatter myFormatObj) {
        this.myFormatObj = myFormatObj;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getRegisterDateAndTime() {
        return registerDateAndTime;
    }

    public void setRegisterDateAndTime(String registerDateAndTime) {
        this.registerDateAndTime = registerDateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        String display = String.format("%-10d %-16s %-15s %-14s %-17s %-2d ", userID, name, password, gender, phoneNo, bonusPoint);
        return display;
    }

    public String toString2() {

        String display = String.format("%-10d %-25s %-15s %-15s", userID, name, description, registerDateAndTime);
        return display;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.myDateObj);
        hash = 47 * hash + Objects.hashCode(this.myFormatObj);
        hash = 47 * hash + this.userID;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.gender);
        hash = 47 * hash + Objects.hashCode(this.phoneNo);
        hash = 47 * hash + this.bonusPoint;
        hash = 47 * hash + Objects.hashCode(this.registerDateAndTime);
        hash = 47 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (this.bonusPoint != other.bonusPoint) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.phoneNo, other.phoneNo)) {
            return false;
        }
        if (!Objects.equals(this.registerDateAndTime, other.registerDateAndTime)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.myDateObj, other.myDateObj)) {
            return false;
        }
        if (!Objects.equals(this.myFormatObj, other.myFormatObj)) {
            return false;
        }
        return true;
    }
}
