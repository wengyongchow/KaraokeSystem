/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

/**
 * @author CHEH ZHEN YU
 */
public interface ZYListInterface<T> {

    public boolean add(T newEntry); //add the object

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition); //remove the elements

    public boolean replace(int givenPosition, T newEntry); //edit the elements

    public T getEntry(int givenPosition); //get the elements from the list

    public int getNumberOfEntries();  //get how many entries from the list

    public boolean isFull();//check list is full or not

    public int size(); // check the list's size

}
