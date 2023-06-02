package CLASS;

import ENTITY.Booking;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import ADT.YYLinkedListBooking;
import ADT.YYBookingInt;
import ADT.YYArrayInt;
import ADT.YYArraySet;
/**
 *
 * @author Chow Weng Yong
 */
public class BookingFunction {
    private static final YYBookingInt<Booking> bookingList = new YYLinkedListBooking<Booking>();
    private static final YYBookingInt<String> timeSlot = new YYLinkedListBooking();//To Store the time slot for booking
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    static Scanner scanString = new Scanner(System.in);     //Scanner for String
    static Scanner scanInt = new Scanner(System.in);        //Scanner for Integer
    //diver to beautify the look
    public static String getDivider(char symbol, int length)
    {
        StringBuilder s = new StringBuilder();
        for(int i=0 ; i<length ; i++)
        {
            s.append(symbol);
        }
        s.append("\n");
        return s.toString();
    }
    
    //paste 5 empty line
    public static void clearScreen() {
        for (int i = 0; i < 5; i++) {
            System.out.print("\n");
        }
    }
    
    public void menu() throws IOException{
        //Code below to store the time slot in the array
        timeSlot.add("12:00-03:00pm");
        timeSlot.add("03:00-06:00pm");
        timeSlot.add("06:00-09:00pm");
        timeSlot.add("09:00-12:00am");
        
        //Assign dummy data into the list
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Booking assignDummy = new Booking("Tan ah gao", 1, formatter.format(cal.getTime()), timeSlot.get(1));
        Booking assignDummy1 = new Booking("Han Xiao Ai", 4, formatter.format(cal.getTime()), timeSlot.get(2));
        Booking assignDummy2 = new Booking("Charles Tee", 4, formatter.format(cal.getTime()), timeSlot.get(3));
        Booking assignDummy3 = new Booking("NG kok Xiang", 5, formatter.format(cal.getTime()), timeSlot.get(4));
        cal.add(Calendar.DATE, 1);
        Booking assignDummy4 = new Booking("Lucal Xia Ling", 2, formatter.format(cal.getTime()), timeSlot.get(1));
        Booking assignDummy5 = new Booking("Gan ling yang", 6, formatter.format(cal.getTime()), timeSlot.get(2));
        Booking assignDummy6 = new Booking("Goh Liu ying", 7, formatter.format(cal.getTime()), timeSlot.get(3));
        Booking assignDummy7 = new Booking("Tom Holland", 2, formatter.format(cal.getTime()), timeSlot.get(4));
        bookingList.add(assignDummy);
        bookingList.add(assignDummy1);
        bookingList.add(assignDummy2);
        bookingList.add(assignDummy3);
        bookingList.add(assignDummy4);
        bookingList.add(assignDummy5);
        bookingList.add(assignDummy6);
        bookingList.add(assignDummy7);
        
        String programName =  getDivider('-', 45) + "\tWelcome to Super Idol Karaoke\n" + getDivider('-', 45) ;
        int choice;        
        do {
            clearScreen();
            System.out.println(programName);
            System.out.println("1. Add Booking");
            System.out.println("2. Retrive Booking");
            System.out.println("3. Delete the latest added record");
            System.out.println("4. Generate Report");
            System.out.print("Enter 0 to exit program : ");
            choice = scanInt.nextInt();
            
            
            // code below is to display the menu available and direct user to the specified method
            //value 1 - 5 is the methods available for users, 0 is to end the loops, others value will prompt user a error message
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        addBooking();
                        break;
                        
                    case 2:
                        readBooking();
                        break;
                        
                    case 3:
                        deleteTheLastestRecord();
                        break;
                        
                    case 4:
                        report();
                        break;
                }
            }
            else if(choice == 0){
                System.out.println("Exiting Program....");
            }
            else{
                System.out.println("The choice is not available..");
            }
        }while(choice>0);
    }
    
    //Add booking method
    public static void addBooking(){

        clearScreen();
        Calendar cal = Calendar.getInstance();
        
        String title = "\t\tAdd booking\n";
        title += getDivider('-', 41);
        System.out.print(title);
        
        
        System.out.print("Please enter your name\t: ");
        System.out.flush();
        String name = scanString.nextLine();
        
        System.out.print("How many person\t\t: ");
        int quantity = scanInt.nextInt();
        
        System.out.print("\tSelect a date\n" + getDivider('-', 30));
        cal.add(Calendar.DATE, 1);      //tomorrow date
        String tomorrow = formatter.format(cal.getTime());
        cal.add(Calendar.DATE, 1);      //the date after tommorow
        String theDayAfterTomorrow = formatter.format(cal.getTime());
        System.out.printf("1. %s\n2. %s\nSelect a date \t\t: ", tomorrow, theDayAfterTomorrow);
        int choiceForDate = scanInt.nextInt();
        
        System.out.print("\tSelect a time\n" + getDivider('-', 30));
        System.out.print(timeSlot);
        System.out.print("Select a time\t\t: ");
        int choiceForTime = scanInt.nextInt();
        String date;
        String time = timeSlot.get(choiceForTime);
        
        if(choiceForDate == 1){
            date = tomorrow;
            
        }else{
            date = theDayAfterTomorrow;
            
        }
        
        Booking newBooking = new Booking(name, quantity, date, time);
        if (bookingList.add(newBooking)) {
            System.out.println("Successfully added....");
            
        } else {
            System.out.println("Fail to add....");
            
        }
        
    }
    
    public static void readBooking(){
        clearScreen();
        
        String title = "\t\tRetrieve booking\n";
        title += getDivider('-', 41);
        System.out.print(title);
        String retrieveList = bookingList.toString();
        
        if (retrieveList != "") {
            System.out.println(retrieveList);
            System.out.print("\n\nSelect a booking : ");
            int choiceForABooking = scanInt.nextInt();
            displayABooking(choiceForABooking);
        } else {
            System.out.println("No data Available..");
        }
    }
    
    public static void displayABooking(int position){
        Booking getBooking = new Booking();
        getBooking = bookingList.get(position);
        if(getBooking!=null){
            System.out.println("Booking ID\t: " + getBooking.getBookingID());
            System.out.println("User\t\t: " + getBooking.getUser());
            System.out.println("Number of Users\t: "+ getBooking.getQuantity());
            System.out.println("Date Chosen\t: "+ getBooking.getDate());
            System.out.println("Time Chosen\t: "+ getBooking.getTime());
            
            System.out.println("\nWhat action you want to perform ? ");
            System.out.println("1. Cancel Booking. ");
            System.out.println("2. Edit Booking. ");
            System.out.print("Your selection : ");
            int choiceForAction = scanInt.nextInt();
            if(choiceForAction==1){
                cancelBooking(position, getBooking);
                
            }else if(choiceForAction==2){
                editBooking(position, getBooking);
                
            }
            else{
                System.out.println("No option available...");
            }
        }
        else{
            System.out.println("No data Available..");
        }
    }
    
    public static void cancelBooking(int position, Booking booking){
        System.out.printf("\nAre you sure want to cancel %s's booking ? \n", booking.getUser());
        System.out.print("(Enter Y/y = yes ; N/n = no) : ");
        String choiceForCancel = scanString.nextLine().toUpperCase();
        char checkSelection = choiceForCancel.charAt(0);
        if(checkSelection == 'Y'){
            
            if(bookingList.remove(position)){
                System.out.println("Booking Cancelled ...");
            }else{
                System.out.println("Cancel booking failed...");
            }
            
        }else if(checkSelection == 'N'){
            System.out.println("Cancel booking failed...");
            
        }else{
            System.out.println("No selection. Exiting function...");
            
        }
    }
    
    public static void editBooking(int position, Booking booking){
        Calendar cal = Calendar.getInstance();        
        System.out.print("\t\tEdit Booking\n"+ getDivider('-', 41));
        
        System.out.println("Your name\t\t: " + booking.getUser());

        System.out.print("How many person\t\t: ");
        int quantity = scanInt.nextInt();
        booking.setQuantity(quantity);

        System.out.print("\t\nSelect a date\n" + getDivider('-', 30));
        cal.add(Calendar.DATE, 1);      //tomorrow date
        String tomorrow = formatter.format(cal.getTime());
        cal.add(Calendar.DATE, 1);      //the date after tommorow
        String theDayAfterTomorrow = formatter.format(cal.getTime());
        System.out.printf("1. %s\n2. %s\nSelect a date \t\t: ", tomorrow, theDayAfterTomorrow);
        int choiceForDate = scanInt.nextInt();

        System.out.print("\t\nSelect a time\n" + getDivider('-', 30));
        System.out.print(timeSlot);
        System.out.print("Select a time\t\t: ");
        int choiceForTime = scanInt.nextInt();

        String date;
        booking.setTime(timeSlot.get(choiceForTime));
        if (choiceForDate == 1) {
            booking.setDate(tomorrow);
        } else {
            booking.setDate(theDayAfterTomorrow);
        }
        
        if(bookingList.replace(position, booking)){
            System.out.println("Data mofified successfuly.");
        }else{
            System.out.println("Data mofified failed.");
        }
    }
    
    public static void deleteTheLastestRecord(){
        System.out.println("Are you sure remove the lasteset record ? ");
        System.out.print("(Enter Y/y = yes ; N/n = no) : ");
        String choiceForCancel = scanString.nextLine().toUpperCase();
        char checkSelection = choiceForCancel.charAt(0);
        if (checkSelection == 'Y') {
            Booking deletedBooking = bookingList.removeLast();
            if (deletedBooking == null) {
                System.out.println("No data available");
            }else{
                System.out.print("\t\tDeleted Booking\n" + getDivider('-', 41));
                System.out.println("Booking ID\t: " + deletedBooking.getBookingID());
                System.out.println("User\t\t: " + deletedBooking.getUser());
                System.out.println("Number of Users\t: " + deletedBooking.getQuantity());
                System.out.println("Date Chosen\t: " + deletedBooking.getDate());
                System.out.println("Time Chosen\t: " + deletedBooking.getTime());

            }
        }else{
            System.out.println("Fail to delete the newest data");
        }
    }
    
    public static void report(){
        String s = "";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        String tmr = formatter.format(cal.getTime());
        cal.add(Calendar.DATE, 1);
        String dateAfterTmr = formatter.format(cal.getTime());
        String keepTmrData = bookingList.report(tmr) + getDivider('-', 81);
        String keepDateAfterTmrDate = bookingList.report(dateAfterTmr) + getDivider('-', 81);
        if (bookingList.isEmpty()) {
            System.out.println("No data available..");
        } else {
            s += getDivider('-', 81);
            s += String.format("|%15s|%15s|%15s|%15s|%15s|\n", "Booking ID", "User Name", "Quantity", "Date", "Time");
            s += getDivider('-', 81);
            s += keepTmrData + keepDateAfterTmrDate;
            System.out.println(s);
        }
    }
}
