/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;


import ADT.ZYListInterface;
import java.io.Serializable;

/**
 *
 * @author CHEH ZHEN YU
 */
public class ZYList<T> implements ZYListInterface<T>, Serializable {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public ZYList() {
        this(DEFAULT_CAPACITY);
    }

    public ZYList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    //add the object to the list
    @Override
    public boolean add(T newEntry) {

        for (int i = 0; i < numberOfEntries; i++) {
            if (array[i].equals(newEntry)) {
                return false;
            }
        }

        if (isFull()) {
            doubleArray();
        }

        array[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;

    }

    //add the object to the list
    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            makeRoom(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    //remove the object from the list
    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }

            numberOfEntries--;
        }

        return result;
    }

    //replace the element from the list
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            array[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    //get the elements from the specific position
    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }

        return result;
    }

    //get how many entries from the list
    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    //check list is full or not
    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {
        // move each entry to next lower position starting at entry after the
        // one removed and continuing until end of array

        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public int size() {

        return numberOfEntries;

    }

    private void doubleArray() {
        T[] oldArray = array;

        array = (T[]) new Object[2 * oldArray.length];

        for (int i = 0; i < numberOfEntries; i++) {
            array[i] = oldArray[i];
        }
    }

}
