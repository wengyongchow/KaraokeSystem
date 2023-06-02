/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author yangz
 */
public class YYArraySet<T> implements YYArrayInt <T>{   
    
    private T[] Setarray;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public YYArraySet() {
        this(DEFAULT_CAPACITY);
    }

    public YYArraySet(int initialCapacity) {
        numberOfEntries = 0;
        Setarray = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newElement) {

        Setarray[numberOfEntries] = newElement;
        numberOfEntries++;
        return true;
    }


    @Override
    public boolean remove(T anElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getElement(int position){
        
        String time = null;
        if (position > 0 && position <= numberOfEntries) {
            time = (String) Setarray[position - 1];
        }
        return time;
    }
    
    public String toString() {
        String outputStr = "";
        for (int i = 0; i < numberOfEntries; ++i) {
            outputStr += i+1 + ". " + Setarray[i] + "\n";
        }

        return outputStr;
    }

    
}
