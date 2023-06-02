/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;

import ADT.ZYList;
import ADT.ZYListInterface;
import ENTITY.Member;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author CHEH ZHEN YU
 */
public class maintenance_Function {

    ZYListInterface<Member> memberList = new ZYList<>(); //create the new object list
    ZYListInterface<Member> memberReport = new ZYList<>();

    Scanner scan = new Scanner(System.in); //get the user's input
    Scanner scan2 = new Scanner(System.in);
    Scanner scan3 = new Scanner(System.in);
    LocalDateTime myDateObj = LocalDateTime.now(); //get the local time
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //set the local time

    public boolean login() {

        int count = 0;
        int maxAttempt = 2;
        boolean isSuccess = false;

        do {

            System.out.println("Insert your Admin ID : ");
            String id = scan.nextLine();
            System.out.println("Insert your Password : ");
            String password = scan2.nextLine();

            if (id.equals("CHEH") && (password.equals("1234"))) {
                System.out.println("Login Successfully. ");
                isSuccess = true;
                count = 100;
            } else {
                System.out.println("The UserID or Password is not correct! Please try again. ");
            }
            count++;
        } while (count <= maxAttempt);

        if (count == 3) {
            System.out.println("You have entered 3 times wrong password! Please try after few hours");
            System.exit(0);
        }
        return isSuccess;
    }

    public void addMember() throws IOException {

        System.out.println("Enter the name : ");
        String name = scan2.nextLine();

        System.out.println("Enter your password : ");
        String password = scan2.nextLine();

        System.out.println("Select your  gender [ M=Male , F=Female ] : ");
        String gender = scan2.nextLine();

        // validate the gender, if not insert M or F ,the system back to the home page.
        if (gender.equals("m") || gender.equals("M")) {
            gender = "Male";
        } else if (gender.equals("f") || gender.equals("F")) {
            gender = "Female";
        } else {
            System.out.println("Please enter the correct gender");
            System.in.read();
            System.out.println("Now we are going back to Main Page");
            System.in.read();
            displayInterface();
        }

        System.out.println("Enter your Phone No :  ");
        String phoneNO = scan2.nextLine();

        int defaultId = 1000; //default userID
        int entry = memberList.getNumberOfEntries();
        int getID;

        if (entry == 0) {
            getID = defaultId;
        } else {
            getID = memberList.getEntry(entry).getUserID() + 1;
        }

        LocalDateTime myDateObj = LocalDateTime.now(); //get the local time
        String dateAndTime = myDateObj.format(myFormatObj); // apply the format to the time
        memberList.add(new Member(getID, name, password, gender, phoneNO, 0, dateAndTime, ""));
        memberReport.add(new Member(getID, name, " [ Added ] ", dateAndTime));

        String title = String.format("%-10s %-16s %-15s %-14s %-14s %-2s", "ID", "Name", "Password", "Gender", "PhoneNo", "Bonus Point");
        System.out.println("+============+=================+===============+===============+======================+");
        System.out.println(title);
        System.out.println("+============+=================+===============+===============+======================+");
        System.out.println(memberList);

        System.out.println("Add the user successfully.");
        System.out.println("");

        System.out.println("Do you want to add another new member? [ Y=Yes , N=No ] : ");
        String addNew = scan2.nextLine();

        if (addNew.equals("Y") || addNew.equals("y")) {
            addMember();
        } else {
            System.out.println("Thank you for using Super Idol Karaoke System");
            System.in.read();
            displayInterface();
        }
    }

    public void removeMember() throws IOException {

        String title = String.format("%s %-10s %-16s %-15s %-14s %-14s %-2s", "No", "ID", "Name", "Password", "Gender", "PhoneNo", "Bonus Point");
        System.out.println("+============+=================+===============+===============+======================+");
        System.out.println(title);
        System.out.println("+============+=================+===============+===============+======================+");

        //display all the elements from the list
        int no = 1;
        for (int i = 1; i <= memberList.size(); i++) {

            System.out.print(no + ". ");
            System.out.println(memberList.getEntry(i));
            no++;
        }

        //if empty, back to main page
        if (memberList.getNumberOfEntries() == 0) {
            System.out.println("No data found !");
            System.out.println("");
            System.out.println("Now we are going back to Main Page");
            System.in.read();
            displayInterface();

        } else {
            System.out.println("");
            System.out.println("Enter the No for remove that account : ");
            int select = scan.nextInt();

            if (select > memberList.size()) {
                System.out.println("Please enter the available number. ");
                System.out.println("");
                System.out.println("Now we are going back to Main Page");
                System.in.read();
                displayInterface();
            }

            int getId = memberList.getEntry(select).getUserID();
            String getName = memberList.getEntry(select).getName();

            System.out.println("Are you sure to remove your account? (Y/N)");
            String comfirmation = scan2.nextLine();
            LocalDateTime myDateObj = LocalDateTime.now(); //
            String dateAndTime = myDateObj.format(myFormatObj); // apply the format to the time

            if (comfirmation.equals("Y") || comfirmation.equals("y")) {
                memberList.remove(select);
                memberReport.add(new Member(getId, getName, " [ Removed ] ", dateAndTime));
                System.out.println("The account has been removed");

            } else if (comfirmation.equals("N") || comfirmation.equals("n")) {

                System.out.println("Removed Cancelled ");
                System.in.read();
                displayInterface();

            } else {
                System.out.println("Please enter the valid number. ");
                System.in.read();
                System.out.println("Now we are going back to Main Page");
                System.in.read();
                displayInterface();
            }

            System.out.println("Do you want to remove another member? [ Y=Yes , N=No ] : ");
            String removeOther = scan2.nextLine();

            if (removeOther.equals("Y") || removeOther.equals("y")) {
                removeMember();
            } else {
                System.out.println("Thank you for using Super Idol Karaoke System");
                System.in.read();
                displayInterface();
            }
        }
    }

    public void editMember() throws IOException {

        String title = String.format("%s %-10s %-16s %-15s %-14s %-14s %-2s", "No", "ID", "Name", "Password", "Gender", "PhoneNo", "Bonus Point");
        System.out.println("+============+=================+===============+===============+======================+");
        System.out.println(title);
        System.out.println("+============+=================+===============+===============+======================+");

        int no = 1;
        for (int i = 1; i <= memberList.size(); i++) {

            System.out.print(no + ". ");
            System.out.println(memberList.getEntry(i));
            no++;
        }

        if (memberList.getNumberOfEntries() == 0) {
            System.out.println("No data found !");
            System.out.println("");
            System.out.println("Now we are going back to Main Page");
            System.in.read();
            displayInterface();

        } else {
            System.out.println("");
            System.out.println("Enter the No for modify that account : ");
            int select = scan.nextInt();

            System.out.println("Enter the New Name : ");
            String newName = scan2.nextLine();

            System.out.println("Enter the Old Password : ");
            String oldPassword = scan2.nextLine();

            System.out.println("Enter the New Password : ");
            String newPassword = scan2.nextLine();

            System.out.println("Enter the New Phone : ");
            String newPhone = scan2.nextLine();

            int getId = memberList.getEntry(select).getUserID();
            String getName = memberList.getEntry(select).getName();
            String getOldPass = memberList.getEntry(select).getPassword();
            String getGender = memberList.getEntry(select).getGender();
            LocalDateTime myDateObj = LocalDateTime.now(); //
            String dateAndTime = myDateObj.format(myFormatObj); // apply the format to the time
            String change = getName + " --> " + newName;

            if (getOldPass.equals(oldPassword) && newPassword != getOldPass) {
                memberList.replace(select, new Member(getId, newName, newPassword, getGender, newPhone, 0, dateAndTime, ""));
                memberReport.add(new Member(getId, change, " [ Edited ] ", dateAndTime));

                System.out.println("Edit successfully");

            } else {
                System.out.println("The old Password is not match");
                System.in.read();
                System.out.println("Edit unsuccessfully");
                System.in.read();
                displayInterface();
            }

            System.out.println("Do you want to edit another member? [ Y=Yes , N=No ] : ");
            String editOther = scan2.nextLine();

            if (editOther.equals("Y") || editOther.equals("y")) {
                editMember();
            } else {
                System.out.println("Thank you for using Super Idol Karaoke System");
                System.in.read();
                displayInterface();
            }
        }
    }

    public void viewMember() throws IOException {

        String title = String.format("%s %-10s %-16s %-15s %-14s %-14s %-2s", "No", "ID", "Name", "Password", "Gender", "PhoneNo", "Bonus Point");
        System.out.println("+============+=================+===============+===============+======================+");
        System.out.println(title);
        System.out.println("+============+=================+===============+===============+======================+");

        int no = 1;
        for (int i = 1; i <= memberList.size(); i++) {

            System.out.print(no + ". ");
            System.out.println(memberList.getEntry(i));
            no++;
        }
        System.out.println("+============+=================+===============+===============+======================+");

        if (memberList.getNumberOfEntries() == 0) {
            System.out.println("No data found !");
            System.out.println("");
            System.out.println("Now we are going back to Main Page");
            System.in.read();
            displayInterface();
        }

        System.in.read();
        System.out.println("Press any key for continue. ");
        System.in.read();
        displayInterface();
    }

    public void generateReport() throws IOException {

        String title = String.format("%-3s %-13s %-25s %-15s %-8s", "No", "User ID", "Name", "Status", "Date / Time");
        System.out.println("+============+=================+===============+===============+===============+");
        System.out.println(title);
        System.out.println("+============+=================+===============+===============+===============+");

        int no = 1;

        for (int i = 1; i <= memberReport.size(); i++) {

            System.out.print(no + ".   ");
            System.out.println(memberReport.getEntry(i).toString2());
            no++;
        }
        if (memberReport.getNumberOfEntries() == 0) {
            System.out.println("No data found !");
            System.out.println("");
            System.out.println("Now we are going back to Main Page");
            System.in.read();
            displayInterface();
        } else {

            System.in.read();
            System.out.println("");
            System.out.println("Enter any key for continue. ");
            System.in.read();
            displayInterface();
        }
    }

    public void displayInterface() throws IOException {

        int selection;

        do {
            System.out.println("-----------------------------------");
            System.out.println("*  Welcome to Super Idol Karaoke  *");
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("1.Add the new Karaoke member ");
            System.out.println("2.Remove the exist member ");
            System.out.println("3.Edit exist member details ");
            System.out.println("4.View member details ");
            System.out.println("5.Generate report");
            System.out.println("0.Exit");
            System.out.println("");

            System.out.println("Enter your choice : ");
            selection = scan.nextInt();

            switch (selection) {

                case 1://Add member
                    addMember();
                    break;

                case 2://Remove member
                    removeMember();
                    break;

                case 3://Edit member
                    editMember();
                    break;

                case 4://View Member
                    viewMember();
                    break;

                case 5://Generate report
                    generateReport();
                    break;
                case 0:
                    break;

            }
        } while (selection != 0 && selection > 4);
        System.out.println("Thank for Using Member Maintenance");
        System.out.println("Press Any Key To Exit...");
        System.in.read();
    }
}
