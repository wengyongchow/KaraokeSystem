
package ADT;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.Serializable;

import java.io.Serializable;

/**
 *
 * @author Lee Jin Jian
 */
public class JJArrayList<T> implements JJListInterface<T>, Serializable {

    private T[] array;  //list array
    private int numberOfEntries;  //total number of entries
    private static final int SONG_CAPACITY = 500; //maximum song in the array

    public JJArrayList() {
        this(SONG_CAPACITY);
    }

    //create array list
    public JJArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    //Adds  new song to the end of the list.
    //List are unaffected. The list's size is increased by 1.
    //return true if the addition is successful,return false if the list is full
    @Override
    public boolean add(T newEntry) {
        array[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    //Adds a new entry at a specified position within the list.
    //list size increase by 1.
    //return true if the addition is successful, return false if either the list is full
    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean successful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            makeRoom(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            successful = false;
        }

        return successful;
    }

    //add all the array entry to the list.
    public void addAll(T[] newEntry) {
        boolean isSuccessful = true;
        for (T newEntryDetail : newEntry) {

            add(newEntryDetail);
            numberOfEntries++;
        }
    }

    //Removes the entry at a given position from the list.
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

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    //Replaces the entry at a given position in the list
    //return true if replacement success
    //givenPosition between 1 to number of entries
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

    //get entry at the given position in the list
    //check if given position is between 1 and number of entries
    //return the entry, the entry will be null if not found
    //given position minus 1 to get data
    @Override
    public T getEntry(int givenPosition) {
        T entry = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            entry = array[givenPosition - 1];
        }

        return entry;
    }

    //determine the list contain the entry
    //set the found to false 
    //
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    //get and return the total number of entries in the list
    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    //determine if the list is empty, return true if number of entries = 0, else return false
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    //determine if the list is full, return true if the list array is full, else return false
    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    //output the array detail
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

        // move each entry to next higher index, starting at end of
        // array and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {

        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

}

