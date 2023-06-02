/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLIENT;

/**
 *
 * @author Group
 */
//scanner
import java.util.Scanner;
//ADT 
import ADT.JJArrayList;
import ADT.JJListInterface;

//client function
import CLASS.SongFunction;
import CLASS.SongFunctionInterface;
//song entity
import ENTITY.Song;
import ENTITY.OldSong;
import ENTITY.NewSong;
import java.io.IOException;

public class songMo {

    static void songModule() throws IOException {
        //arraylist (DEFAULT SONG LIST)
        JJListInterface<Song> songList = new JJArrayList<>();
        //arrayList (SESSION SELECT LIST)
        JJListInterface<Song> songList2 = new JJArrayList<>();

        //song arrayList = (ID,Name,Album, Artist)
        songList.add(new NewSong(1001, "Perfect", "Divide", "Ed Sheeran", 15032022));
        songList.add(new NewSong(1002, "Let It Go", "Disney", "Idina Menzel", 15032022));
        songList.add(new NewSong(1003, "Venom", "-", "Eminem", 15032022));
        songList.add(new NewSong(1004, "Stay", "Kid Laroi", "Justin Bieber", 15032022));
        songList.add(new NewSong(1005, "Savage Love", "Prod Jawsh", "Jason Derulo", 15032022));
        songList.add(new NewSong(1006, "Drive you home", "Internet Money", "Jackson Wang", 15032022));
        songList.add(new NewSong(1007, "100 ways", "-", "Jackson Wang", 15032022));
        songList.add(new OldSong(1008, "200 ways", "-", "JJ Lee", 20032022, 321));
        songList.add(new OldSong(1009, "300 ways", "-", "JJ Lee", 20032022, 351));

        //song arrayStack (FULL 20 song) = (ID,Name,Album,Artist)
        //variable
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = SongFunction.login();
        if (loggedIn == true) {
            do {

                //display Menu & choice
                SongFunction.displayMenu();
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        SongFunction.addSong(songList);
                        break;
                    case 2:
                        SongFunction.removeSong(songList);
                        break;
                    case 3:
                        SongFunction.editSong(songList);
                        break;
                    case 4:
                        SongFunction.getSong(songList);
                        break;
                    case 5:
                        SongFunction.generateReport(songList, songList2);
                        break;
                    case 6:
                        SongFunction.SessionDemo(songList, songList2);
                    default:

                }

            } while (choice != 7);
        }
//End the System
        System.out.print("\n\nThank you for using Song maintenance!\n");
        System.out.print("Press Any Key To Continue...");
        System.in.read();
        System.out.println("");

    }

}
