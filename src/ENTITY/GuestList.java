/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Hong
 */
public class GuestList {

    private int memberID;
    private String memberName;
    private int point;

    public GuestList(int memberID, String memberName, int point) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.point = point;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getPoint() {
        return point;
    }

}
