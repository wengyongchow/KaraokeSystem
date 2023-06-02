/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CLIENT;


import java.util.Scanner;
import CLIENT.memberMo;
import CLASS.DataConfig;
import java.io.IOException;

/**
 *
 * @author Group
 */
public class KaraokeSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int choice;
        Scanner scan = new Scanner(System.in);
        DataConfig updateData = new DataConfig();
        updateData.addSong();
        updateData.addAllMember();
        do {
            choice = 0;
//select operation(Menu)
            System.out.println("Welcome To Super Idol Karaoke System\n");
            System.out.println("Select Operation:");
            System.out.println("1.Song Maintenance");
            System.out.println("2.Member Maintenance");
            System.out.println("3.Booking");
            System.out.println("4.Session");
            System.out.println("5.Exit");
            System.out.print("Please Select A Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    songMo.songModule();
                    break;
                case 2:
                    memberMo.memberModule();
                    break;
                case 3:
                    bookingMo.bookingModule();
                    break;
                case 4:
                    sessionMo.sessionModule();
                    break;
                default:

            }

        } while (choice != 5);
//End the System
        System.out.print("\n\nThank you for using Super Idol Karaoke System!\n");

    }

}
