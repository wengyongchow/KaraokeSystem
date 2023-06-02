/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

/**
 *
 * @author yangz
 */
public interface YYBookingInt <T> {
    
    public boolean add(T newBooking);
    
    public boolean remove(int position);
    
    public T removeLast();
    
    public T get(int position);
    
    public boolean replace(int position,T editedBooking);
    
    public boolean isEmpty();
    
    public String report(String date);
    
}
