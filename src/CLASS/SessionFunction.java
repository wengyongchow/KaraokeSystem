/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;

import ADT.Queue;
import ADT.QueueInterface;
import ENTITY.GuestList;
import ENTITY.NewSong;
import ENTITY.Song;
import java.util.Scanner;

/**
 *
 * @author Hong
 */
public class SessionFunction implements KaraokieSessionInterface {
    
    Scanner scanInt = new Scanner(System.in);
    Scanner scanf = new Scanner(System.in);

    //constant variable
    private static final int MAX_PATICIPENT = 8;
    
    private int paticipentCount = 0;
    private int guestCount = 1;
    
    private GuestList memberLogin() {

        //declear a guestlist var
        GuestList paticipent = null;
        
        boolean con = false;
        boolean found = false;
        //ask for user ID or login as guest
        while (!con) {
            
            System.out.print("Enter User ID (9999 = Login as guest) : ");
            int memberId = scanInt.nextInt();
            
            System.out.print("\n");

            //if input is 9999 then login as guest
            if (memberId == 9999) {
                Integer x = guestCount;

                //show ID and name
                System.out.println("ID   : Guest " + x.toString());
                System.out.println("Name : Guest " + x.toString());
                System.out.println("Point : 0 ");
                
                System.out.print("\n");
                //add member to guestList();
                paticipent = new GuestList(9999, "Guest " + x.toString(), 0);

                //guest add 1
                guestCount++;
                found = true;
                con = true;
            } else {
                for (int i = 1; i <= DataConfig.MEMBERLIST.size(); i++) {
                    
                    if (DataConfig.MEMBERLIST.getEntry(i).getUserID() == memberId) {
                        System.out.println("ID   : " + DataConfig.MEMBERLIST.getEntry(i).getUserID());
                        
                        System.out.println("Name : " + DataConfig.MEMBERLIST.getEntry(i).getName());
                        System.out.println("Point : " + DataConfig.MEMBERLIST.getEntry(i).getBonusPoint());
                        
                        paticipent = new GuestList(DataConfig.MEMBERLIST.getEntry(i).getUserID(), DataConfig.MEMBERLIST.getEntry(i).getName(), DataConfig.MEMBERLIST.getEntry(i).getBonusPoint());
                        found = true;
                        con = true;
                    }
                }
                if (!found) {
                    System.out.println("Member ID not found ... ");
                    con = false;
                    paticipent = null;
                }
            }
            
        }
        
        return paticipent;
    }
    
    @Override
    public GuestList[] getPaticipent() {

        //declear a array guestlist var
        GuestList[] paticipent = new GuestList[MAX_PATICIPENT];

        //declear a condition for while loop
        boolean con = false;

        //if condition is false then stop loop
        while (!con) {
            //insert data to array guestlist;
            paticipent[paticipentCount] = memberLogin();
            paticipentCount++;
            if (paticipentCount <= 1) {
                System.out.println("Enter 2nd Member");
                
            } else if (paticipentCount > 8) {
                System.out.println("Paticipent cannot over 8");
                System.out.println("The session will start now");
                con = true;
                
            } else {
                System.out.print("Add next paticipent ? (Enter Y/y = yes ; N/n = no): ");
                String input = scanf.nextLine();
                input = input.toUpperCase();
                System.out.println("\n");
                con = input.equals("N");
            }
            //get condition from user

            System.out.print("\n");
        }
        return paticipent;
    }
    
    private void showAllSong() {
        //show song collum
        String title = String.format("+ %-10s + %-15s + %-13s + %-13s + %-15s +", "SongID", "Title", "Artist", "Album", "DateCreate");
        System.out.println("+============+=================+===============+===============+=================+");
        System.out.println(title);
        System.out.println("+============+=================+===============+===============+=================+");

        //show song info
        for (int i = 1; i <= DataConfig.SONGLIST.getNumberOfEntries(); i++) {
            if (DataConfig.SONGLIST.getEntry(i) instanceof NewSong) {
                System.out.println(DataConfig.SONGLIST.getEntry(i));
            }
            
        }
        
        System.out.println("+============+=================+===============+===============+=================+");
        System.out.println("\n");
    }
    
    @Override
    public QueueInterface<Song> selectSong() {
        
        QueueInterface<Song> playList = new Queue<>();
        //declear a condition for while loop
        boolean con = false;
        //if condition is false then stop loop
        while (!con) {
            //run private method
            showAllSong();
            //get song from user
            System.out.print("Enter Song No : ");
            int songNumber = scanInt.nextInt();

            //add song to queue with song id
            for (int i = 1; i <= DataConfig.SONGLIST.getNumberOfEntries(); i++) {
                if (DataConfig.SONGLIST.getEntry(i).getSongId() == songNumber) {
                    playList.enqueue(DataConfig.SONGLIST.getEntry(i));
                    
                }
                
            }

            //get condition from user
            System.out.print("Add next Song ? (Enter Y/y = yes ; N/n = no): ");
            
            String input = scanf.nextLine();
            input = input.toUpperCase();
            System.out.println("\n");
            con = input.equals("N");
            
        }
        
        return playList;
    }

    //session start
    @Override
    public void karaokieStart(GuestList[] paticipent, QueueInterface<Song> playList) {

        //stop loop if the queue/playlist is null
        while (!playList.isEmpty()) {
            System.out.println("=== Supper Karaokie System ===\n");
            //run private method : line:
            showAllPaticipent(paticipentCount, paticipent);
            
            System.out.print("\n");
            
            System.out.print("Enter paticipent No ");
            int input = scanInt.nextInt();
            int selectedPaticipent = input - 1;
            System.out.print("\n");

            //run private method : line
            playSong(playList);
            showSessionPaticipent(paticipent, selectedPaticipent);
            System.out.print("\n");

            //run private method : line
            Integer x = audienceVote(paticipent, selectedPaticipent);
            System.out.print("\n");
            System.out.println("Point for this Perform : " + x.toString());
            System.out.print("\n");
        }
        
    }
    
    private void showAllPaticipent(int paticipentCount, GuestList[] paticipent) {
        
        for (int j = 0; j < paticipentCount; j++) {
            System.out.println((j + 1) + ". " + paticipent[j].getMemberName());
            ;
        }
        
    }

    //dequeue / play song in list
    private void playSong(QueueInterface<Song> playList) {
        Song currentSong = playList.dequeue();
        System.out.print(currentSong.getSongName() + "   -- " + currentSong.getArtist() + "\n\n");
        System.out.println("===[]==========================================\n");
        
    }

    // show audience only in the array
    private void showAudience(int selectedPaticipent, int paticipentCount, GuestList[] paticipent) {
        int i = 1;
        for (int j = 0; j < paticipentCount; j++) {
            if (j != selectedPaticipent) {
                System.out.println(i + ". " + paticipent[j].getMemberName());
                i++;
            }
        }
        
    }

    //show all Paticipent / seperate perfomer and Audience
    private void showSessionPaticipent(GuestList[] paticipent, int selectedPaticipent) {
        System.out.println("Persent By :");

        //show perfomer only
        System.out.println(paticipent[selectedPaticipent].getMemberName());
        
        System.out.print("\n");
        
        System.out.println("Audience :");
        //show audience only in the array
        showAudience(selectedPaticipent, paticipentCount, paticipent);
        System.out.print("\n");
    }

    //audience rate the Performance
    private Integer audienceVote(GuestList[] paticipent, int selectedPaticipent) {
        int i = 0;
        int totalPoint = 0;
        int pointGiven;
        for (int j = 0; j < paticipentCount; j++) {
            if (j != selectedPaticipent) {
                System.out.print((j + 1) + ". " + paticipent[j].getMemberName());

                //ask non paticipent to vote
                System.out.print(" -- Rate The Performance (0~10) ");
                pointGiven = scanf.nextInt();

                //add to total
                totalPoint += pointGiven;
                i++;
            }
            
        }
        //calculate point
        int average = (totalPoint / i);
        System.out.println("\n");
        return average;
    }
    
    @Override
    public void showQueueSong(QueueInterface<Song> playList) {
        playList.toString();
    }
    
    @Override
    public void addPoint(GuestList[] paticipent) {
        for (int j = 0; j < paticipentCount; j++) {
            for (int i = 1; i <= DataConfig.MEMBERLIST.size(); i++) {
                if (DataConfig.MEMBERLIST.getEntry(i).getUserID() == paticipent[j].getMemberID()) {
                    int point = DataConfig.MEMBERLIST.getEntry(i).getBonusPoint();
                    DataConfig.MEMBERLIST.getEntry(i).setBonusPoint(point + 10);
                }
            }
            
        }
        System.out.print("ALL member added 10 bonus point !!!");
    }
    
}
