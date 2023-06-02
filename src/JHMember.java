/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cable
 */
public class JHMember {
    
    private int userID = 3897;
    private int password;
    private String name;
    private String gender;
    private int vipRank;
    private int remainingBalance; //point
    
    //constuctor
    public JHMember(String name,int password,String gender){
        this.name=name;
        this.password=password;
        this.gender=gender;
    }
   
    
    public JHMember(String name, int password){
        this.name=name;
        this.password=password;
    }
    
    
    //Getter & setter 

    public int getVipRank(){
        return 1 ;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public int getPassword(){
        return password;
    }
    
    
    public int setPassword(int password){
        this.password= password;
        return password;
    }
    
    
    //Getter & setter end 
    
    
    //to string
   @Override
   
    public String toString() {    
    return String.format("No. %-10d %-20s\n", userID, name);
  }
}
