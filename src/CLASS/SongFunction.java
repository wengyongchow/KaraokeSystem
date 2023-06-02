/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;

import ADT.JJListInterface;
import ENTITY.NewSong;
import ENTITY.Song;
import ENTITY.OldSong;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Lee Jin Jian
 */
public class SongFunction implements SongFunctionInterface {

    public static void displayMenu() {
        //select operation(Menu)
        System.out.println("\nSuper Idol Karaoke Song Maintenance\n");
        System.out.println("Select Operation:");
        System.out.println("1.Add Song");
        System.out.println("2.Remove Song");
        System.out.println("3.Edit Song");
        System.out.println("4.Retrieve Song Details");
        System.out.println("5.Generate Reports (Daily's top song)");
        System.out.println("6.Session Song Select Demo");
        System.out.println("7.Exit");
        System.out.print("Please Select A Choice: ");
    }

    public static void addSong(JJListInterface<Song> songList) throws IOException {
        //variable
        char addOther = 0;
        char otherMultiple = 0;
        char confirmAll = 0;
        int songNumber = 1;
        Scanner scan = new Scanner(System.in);
        //add multiple array
        NewSong[] sArray = new NewSong[100];

        System.out.println("1.Single Add");
        System.out.println("2.Multiple Add");
        System.out.print("Please Select Add Method:");
        int selectAdd = scan.nextInt();

        switch (selectAdd) {
            case 1:
                do {
                    //user input song details
                    Scanner scan2 = new Scanner(System.in);
                    //Input all the song details (name,album,artist,ID auto incement)
                    System.out.print("Enter Song Name: ");
                    String inputName = scan2.nextLine();

                    System.out.print("Enter Song Album: ");
                    String inputAlbum = scan2.nextLine();

                    System.out.print("Enter Song Artist: ");
                    String inputArtist = scan2.nextLine();

                    //assign song ID
                    int entry = songList.getNumberOfEntries();
                    int getID = songList.getEntry(entry).getSongId();
                    getID++;

                    //confirm to add song?
                    String confirm = String.format("Confirm To Add Song: %s ? (Y=Yes N=No):", inputName);
                    System.out.print(confirm);
                    char confirmAdd = scan2.next().charAt(0);

                    //if yes, add song
                    if (confirmAdd == 'Y' || confirmAdd == 'y') {
                        String inputNameConfirm = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
                        String inputAlbumConfirm = inputAlbum.substring(0, 1).toUpperCase() + inputAlbum.substring(1);
                        String inputArtistConfirm = inputArtist.substring(0, 1).toUpperCase() + inputArtist.substring(1);
                        int uploadDate = Calendar.YEAR;
                        songList.add(new NewSong(getID, inputNameConfirm, inputAlbumConfirm, inputArtistConfirm, uploadDate));
                        String addedSong = String.format("New Song has been added:-\n ID:%-7d Name: %-10s Album: %-10s Artist: %-10s \n\n", getID, inputNameConfirm, inputAlbumConfirm, inputArtistConfirm);
                        System.out.print(addedSong);
                        System.out.println("Enter Any Key");
                        System.in.read();

                    } else if (confirmAdd == 'N' || confirmAdd == 'n') {
                        String cancelledAdd = String.format("Add Song Cancelled!\n");
                        System.out.print(cancelledAdd);
                        System.out.println("Enter Any Key");
                        System.in.read();
                    }
                    System.out.print("Add Another Song? (Y=Yes N=No): ");
                    addOther = scan.next().charAt(0);
                } while (addOther == 'Y' || addOther == 'y');

                break;
            case 2:

                //assign song ID
                int entry = songList.getNumberOfEntries();
                int getID = songList.getEntry(entry).getSongId();
                getID++;
                do {
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Song " + songNumber);

                    System.out.print("Enter Song Name: ");
                    String inputName = scan2.nextLine();

                    System.out.print("Enter Song Album: ");
                    String inputAlbum = scan2.nextLine();

                    System.out.print("Enter Song Artist: ");
                    String inputArtist = scan2.nextLine();

                    String inputNameConfirm = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
                    String inputAlbumConfirm = inputAlbum.substring(0, 1).toUpperCase() + inputAlbum.substring(1);
                    String inputArtistConfirm = inputArtist.substring(0, 1).toUpperCase() + inputArtist.substring(1);
                    int uploadDate = Calendar.YEAR;
                    int stopper = 0;
                    for (int i = 0; i < sArray.length; i++) {
                        if (sArray[i] == null && stopper == 0) {
                            sArray[i] = new NewSong(getID, inputNameConfirm, inputAlbumConfirm, inputArtistConfirm, uploadDate);
                            stopper += 1;

                        }
                    }

                    //add other multiple song?
                    String confirm = String.format("Add more song? Current Number of song: %d (Y=Yes N=No):", songNumber);
                    System.out.print(confirm);
                    otherMultiple = scan2.next().charAt(0);

                    if (otherMultiple == 'Y' || otherMultiple == 'y') {
                        songNumber++;
                        getID++;
                    }

                } while (otherMultiple == 'Y' || otherMultiple == 'y');
                int t = 1; //number display

                //print all the pending song to add in array
                for (int i = 0; i < sArray.length; i++) {
                    if (sArray[i] != null) {
                        System.out.println(t + ". " + sArray[i]);
                        t++;
                    }
                }
                Scanner scan2 = new Scanner(System.in);
                System.out.print("Confirm To Add All (" + songNumber + ") song?(Y=Yes N=No): ");
                confirmAll = scan2.next().charAt(0);

                if (confirmAll == 'Y' || confirmAll == 'y') {
                    //songList.addAll(sArray);
                    for (int i = 0; i < sArray.length; i++) {
                        if (sArray[i] != null) {
                            songList.add(sArray[i]);
                        }
                    }
                    System.out.println("All Multiple Song Added!");
                    System.out.println("Enter Any Key");
                } else {
                    System.out.println("Multiple Add Cancelled!");
                    System.out.println("Enter Any Key");
                }
                System.in.read();
                break;
            default:
        }

    }

    public static void getSong(JJListInterface<Song> songList) throws IOException {
        //var
        int getChoice;
        Scanner scan = new Scanner(System.in);
        int t = 1;
        //select type of song to get
        System.out.println("1. Current Online Song");
        System.out.println("2. Removed Old Song");
        System.out.print("Select Type Of Song:");
        getChoice = scan.nextInt();

        switch (getChoice) {
            case 1:
                //show songs title
                displaySongBorder();

                //if list not empty, print all songs
                if (!songList.isEmpty()) {
                    for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                        if (songList.getEntry(i) instanceof NewSong) {
                            System.out.println(t + ". " + songList.getEntry(i));
                            t++;
                        }

                    }
                    //end of loop and closing
                    displaySongEndBorder();
                    System.out.println("END OF THE LIST\n\n");

                    System.out.println("Enter Any Key Back To Menu");
                    System.in.read();

                }
                break;
            case 2:
                //show songs title
                displaySongBorder();

                //if list not empty, print all songs
                if (!songList.isEmpty()) {
                    for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                        if (songList.getEntry(i) instanceof OldSong) {
                            System.out.println(t + ". " + songList.getEntry(i));
                            t++;
                        }

                    }
                    //end of loop and closing
                    displaySongEndBorder();
                    System.out.println("END OF THE LIST\n\n");

                    System.out.println("Enter Any Key Back To Menu");
                    System.in.read();
                }
                break;
            default:
        }

    }

    public static void removeSong(JJListInterface<Song> songList) throws IOException {

        //var
        char removeOther;
        int songRemove;
        int t = 1;
        int selectID = 0;
        char confirmRemove;
        Scanner scan = new Scanner(System.in);

        do {
            int foundSong = 0;
            //show songs title
            displaySongBorder();
            if (!songList.isEmpty()) {
                for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                    if (songList.getEntry(i) instanceof NewSong) {
                        System.out.println(t + ". " + songList.getEntry(i));
                        t++;
                    }

                }
            }
//end of loop and closing
            displaySongEndBorder();
            System.out.print("Please Select A song to remove(ID-1001)(enter 99999 to clear all song): ");
            selectID = scan.nextInt();

            if (selectID == 99999) {

                System.out.print("Are you sure to clear all song?:(Y=Yes N=No): ");
                char confirmRemoveAll = scan.next().charAt(0);

                if (confirmRemoveAll == 'Y' || confirmRemoveAll == 'y') {
                    songList.clear();
                    System.out.println("All song has been cleared.");
                } else {
                    System.out.println("Clear all cancelled.");
                }

            } else {
                //find selected song
                for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                    if (songList.getEntry(i).getSongId() == selectID && songList.contains(songList.getEntry(i)) && songList.getEntry(i) instanceof NewSong) {
                        foundSong -= 1;

                        String songToRemove = songList.getEntry(i).toString();
                        System.out.println(songToRemove);
                        String songNameRemoved = songList.getEntry(i).getSongName();

                        //ask for confirmation
                        System.out.print("Do you wanted to remove this song?:(Y=Yes N=No): ");
                        confirmRemove = scan.next().charAt(0);

                        //if confirm and remove
                        if (confirmRemove == 'Y' || confirmRemove == 'y') {
                            songList.remove(i);
                            System.out.println("Song: " + songNameRemoved + " has been removed.");

                            //if no confirm
                        } else if (confirmRemove == 'N' || confirmRemove == 'n') {
                            System.out.println("Remove Song Cancelled!");

                        } else {
                            System.out.println("Remove Song Cancelled!");

                        }
                        //if song not found
                    } else {
                        foundSong += 1;
                        if (foundSong == songList.getNumberOfEntries()) {
                            System.out.println("Song Selected Not Found!");
                            System.out.println("Enter Any Key");
                            System.in.read();
                        }
                    }
                }

            }
            System.out.print("Remove Another Song? (Y=Yes N=No): ");
            removeOther = scan.next().charAt(0);
        } while (removeOther == 'Y' || removeOther == 'y');

    }

    public static void editSong(JJListInterface<Song> songList) throws IOException {

        //var
        int selectDetail;
        int selectID;
        char confirm1;
        char editOther;
        Scanner scan = new Scanner(System.in);

        do {
            int foundSong = 0;
            displaySongBorder();
            if (!songList.isEmpty()) {
                for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                    if (songList.getEntry(i) instanceof NewSong) {
                        System.out.println(songList.getEntry(i));
                    }

                }
            }
//end of loop and closing
            displaySongEndBorder();
            System.out.print("Please Select a song to edit(ID-1001): ");
            selectID = scan.nextInt();
            //search for song to edit
            for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                if (songList.getEntry(i).getSongId() == selectID && songList.contains(songList.getEntry(i)) && songList.getEntry(i) instanceof NewSong) {
                    foundSong -= 1;
                    //if song found,choose to edit
                    String songToEdit = songList.getEntry(i).toString();
                    System.out.println(songToEdit + "\n");
                    String songNameBefore = songList.getEntry(i).getSongName();
                    String songAlbumBefore = songList.getEntry(i).getAlbum();
                    String songArtistBefore = songList.getEntry(i).getArtist();

                    //select edit detail
                    System.out.println("1. Song Name");
                    System.out.println("2. Song Album");
                    System.out.println("3. Song Artist");
                    System.out.println("4. Edit All Detail");
                    System.out.print("Please Select detail to edit:");
                    selectDetail = scan.nextInt();

                    char confirmEdit;

                    switch (selectDetail) {
                        case 1:
                            System.out.println("Song Name: " + songNameBefore);
                            System.out.print("Enter New Name: ");
                            String songNameAfter1 = scan.nextLine();
                            String songNameAfter2 = scan.nextLine();

                            System.out.print("Edit Song Name? (Y=Yes N=No):");
                            confirmEdit = scan.next().charAt(0);

                            if (confirmEdit == 'Y' || confirmEdit == 'y') {
                                songList.getEntry(i).setSongName(songNameAfter2);
                                System.out.println(songList.getEntry(i).toString());
                            } else {
                                System.out.println("Edit Cancelled!");
                            }

                            break;

                        case 2:
                            System.out.println("Song Album: " + songAlbumBefore);
                            System.out.print("Enter New Album Name: ");
                            String songAlbumAfter = scan.nextLine();
                            String songAlbumAfter2 = scan.nextLine();

                            System.out.print("Edit Song Album? (Y=Yes N=No):");
                            confirmEdit = scan.next().charAt(0);

                            if (confirmEdit == 'Y' || confirmEdit == 'y') {
                                songList.getEntry(i).setAlbum(songAlbumAfter2);
                                System.out.println(songList.getEntry(i).toString());
                            } else {
                                System.out.println("Edit Cancelled!");
                            }

                            break;
                        case 3:
                            System.out.println("Song Artist: " + songArtistBefore);
                            System.out.print("Enter New Artist Name: ");
                            String songArtistAfter = scan.nextLine();
                            String songArtistAfter2 = scan.nextLine();

                            System.out.print("Edit Song Artist? (Y=Yes N=No):");
                            confirmEdit = scan.next().charAt(0);

                            if (confirmEdit == 'Y' || confirmEdit == 'y') {
                                songList.getEntry(i).setArtist(songArtistAfter2);
                                System.out.println(songList.getEntry(i).toString());
                            } else {
                                System.out.println("Edit Cancelled!");
                            }
                            break;
                        case 4:
                            System.out.println("Song Name: " + songNameBefore);
                            System.out.println("Song Album: " + songAlbumBefore);
                            System.out.println("Song Artist: " + songArtistBefore);

                            System.out.print("Enter New Name: ");
                            String songNameAfter3 = scan.nextLine();
                            String songNameAfter4 = scan.nextLine();
                            System.out.print("Enter New Album Name: ");
                            String songAlbumAfter3 = scan.nextLine();
                            System.out.print("Enter New Artist Name: ");
                            String songArtistAfter3 = scan.nextLine();

                            System.out.print("Edit All song details? (Y=Yes N=No):");
                            confirmEdit = scan.next().charAt(0);

                            if (confirmEdit == 'Y' || confirmEdit == 'y') {
                                songList.getEntry(i).setSongName(songNameAfter4);
                                songList.getEntry(i).setAlbum(songAlbumAfter3);
                                songList.getEntry(i).setArtist(songArtistAfter3);
                                System.out.println(songList.getEntry(i).toString());
                            } else {
                                System.out.println("Edit Cancelled!");
                            }
                            break;
                        default:
                    }

                } else {
                    foundSong += 1;
                    if (foundSong == songList.getNumberOfEntries()) {
                        System.out.println("Song Selected Not Found!");
                        System.out.println("Enter Any Key");
                        System.in.read();
                    }
                }
            }

            //edit another song?
            System.out.print("Edit Another Song? (Y=Yes N=No): ");
            editOther = scan.next().charAt(0);
        } while (editOther == 'Y' || editOther == 'y');

    }

    public static void generateReport(JJListInterface<Song> songList, JJListInterface<Song> songList2) throws IOException {

        //var
        char reportOther;
        int selectCount = 0;
        String topSong = null;
        Scanner scan = new Scanner(System.in);

        do {
            if (!songList2.isEmpty()) {
                selectCount = 0;

                displaySongBorder();
                if (!songList.isEmpty()) {
                    for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                        if (songList.getEntry(i) instanceof NewSong) {
                            System.out.println(songList.getEntry(i));
                        }

                    }
                }
//end of loop and closing
                displaySongEndBorder();
                System.out.print("Please Select a song to to get report(ID-1001): ");
                int getId = scan.nextInt();

                for (int i = 1; i <= songList2.getNumberOfEntries(); i++) {
                    if (songList2.getEntry(i).getSongId() == getId && songList2.contains(songList2.getEntry(i)) && songList.getEntry(i) instanceof NewSong) {
                        selectCount++;
                    }

                }
                System.out.println("Total Play Rate =  " + selectCount);

            } else {
                System.out.println("No Song In The Session List");

            }

//                break;
//            default:
//        }
            System.out.println("Enter Any Key");
            System.in.read();
//edit another song?
            System.out.print("Get Another Song Report? (Y=Yes N=No): ");
            reportOther = scan.next().charAt(0);
        } while (reportOther == 'Y' || reportOther == 'y');
    }

    public static void SessionDemo(JJListInterface<Song> songList, JJListInterface<Song> songList2) throws IOException {
        //var

        char SelectOther;
        Scanner scan = new Scanner(System.in);
        do {
            int foundSong = 0;
            displaySongBorder();
            if (!songList.isEmpty()) {
                for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                    if (songList.getEntry(i) instanceof NewSong) {
                        System.out.println(songList.getEntry(i));
                    }

                }
            }
//end of loop and closing
            displaySongEndBorder();
            System.out.print("Please Select a song to choose(ID-1001): ");
            int selectID = scan.nextInt();

            for (int i = 1; i <= songList.getNumberOfEntries(); i++) {
                if (songList.getEntry(i).getSongId() == selectID && songList.contains(songList.getEntry(i)) && songList.getEntry(i) instanceof NewSong) {
                    foundSong -= 1;

                    songList2.add(songList.getEntry(i));

                } else {
                    foundSong += 1;
                    if (foundSong == songList.getNumberOfEntries()) {
                        System.out.println("Song Selected Not Found!");
                        System.out.println("Enter Any Key");
                        System.in.read();
                    }
                }
            }
            System.out.print("Select Another Song? (Y=Yes N=No): ");
            SelectOther = scan.next().charAt(0);
        } while (SelectOther == 'Y' || SelectOther == 'y');

        System.out.println("Song added:");
        for (int i = 1; i <= songList2.getNumberOfEntries(); i++) {
            if (!songList2.isEmpty()) {
                System.out.println(songList2.getEntry(i));

            }
        }
        System.out.println("Enter Any Key");
        System.in.read();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displaySongBorder() {
        //show songs title
        String title2 = String.format("+ %-10s + %-18s + %-17s + %-22s + %-30s +", "SongID", "Title", "Album", "Artist", "DateCreate");
        System.out.println("+============+====================+===================+========================+================================+");
        System.out.println(title2);
        System.out.println("+============+====================+===================+========================+================================+");
    }

    public static void displaySongEndBorder() {
        //end of loop and closing
        System.out.println("+============+=====================+=====================+====================+================================+");
    }

    public static void displayTitle() {
        System.out.println("   _____                         _____    _       _   _  __                     _        ");
        System.out.println("  / ____|                       |_   _|  | |     | | | |/ /                    | |       ");
        System.out.println(" | (___  _   _ _ __   ___ _ __    | |  __| | ___ | | | ' / __ _ _ __ __ _  ___ | | _____ ");
        System.out.println("  \\___ \\| | | | '_ \\ / _ \\ '__|   | | / _` |/ _ \\| | |  < / _` | '__/ _` |/ _ \\| |/ / _ \\");
        System.out.println(" ____) | |_| | |_) |  __/ |     _| || (_| | (_) | | | . \\ (_| | | | (_| | (_) |   <  __/");
        System.out.println(" |_____/ \\__,_| .__/ \\___|_|    |_____\\__,_|\\___/|_| |_|\\_\\__,_|_|  \\__,_|\\___/|_|\\_\\___|");
        System.out.println("              | |                                                                        ");
        System.out.println("              |_|                                                                        ");
        System.out.println("");

    }

    //admin login to song maintenance
    public static boolean login() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int count = 0;
        int attempt = 2;
        
        boolean success = false;

        do {

            System.out.print("Please Insert Admin ID: ");
            String id = scan.nextLine();
            System.out.print("Please Insert Admin Password: ");
            String password = scan2.nextLine();

            if (id.equals("admin") && (password.equals("password"))) {
                System.out.println("Login Successfully. ");
                success = true;
                count = 10;
            } else {
                System.out.println("The UserID or Password is not correct! Please try again. ");
                count++;
            }
            
        } while (count <= attempt);

        if (count == 3) {
            System.out.println("You have ran out of attempt.Please try again after a moment.");

        }
        return success;
    }
}
