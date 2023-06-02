/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLIENT;
import CLASS.BookingFunction;
import java.io.IOException;
/**
 *
 * @author Chow weng yong
 */
public class bookingMo {
    static void bookingModule() throws IOException {
        BookingFunction start = new BookingFunction();
        start.menu();
    }
}
