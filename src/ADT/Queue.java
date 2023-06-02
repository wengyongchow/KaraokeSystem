/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

import java.util.Iterator;

/**
 *
 * @author Hong
 */
public class Queue<T> implements QueueInterface<T> {

    private SongPlayList firstSong; // references node at front of queue
    private SongPlayList lastSong;  // references node at back of queue
    private int numberOfEntries;

    public Queue() {
        firstSong = null;
        lastSong = null;
        numberOfEntries = 0;
    }

    @Override
    public Iterator<T> getIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enqueue(T newSongEntry) {
        boolean isSuccessful = false;
        SongPlayList newSong = new SongPlayList(newSongEntry, null);

        if (newSongEntry != null) {
            if (isEmpty()) {
                firstSong = newSong;
            } else {
                lastSong.next = newSong;
            }
            lastSong = newSong;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = firstSong.ID;
            firstSong = firstSong.next;

            if (firstSong == null) {
                lastSong = null;
            }
        }
        return front;
    }

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstSong.ID;
        }

        return front;
    }

    @Override
    public boolean isEmpty() {
        return (firstSong == null) && (lastSong == null);
    }

    @Override
    public void clear() {
        firstSong = null;
        lastSong = null;
    }

    @Override
    public String toString() {
        String outputStr = "";
        SongPlayList currentSong = firstSong;
        int count = 1;

        while (currentSong != null) {
            Integer x = count;
            outputStr += x.toString() + currentSong.ID + "\n";
            currentSong = currentSong.next;
            count++;
        }
        return outputStr;
    }

    @Override
    public T[] getQueue() {
        T[] output = null;
        SongPlayList currentSong = firstSong;
         int count = 0;
         while (currentSong != null) {
             output[count] = currentSong.ID;
             currentSong = currentSong.next;   
             count++;
         }
        
        return output;
    }
    

  

   

    private class SongPlayList {

        private T ID;
        private SongPlayList next;

        private SongPlayList(T ID) {
            this.ID = ID;
            this.next = null;
        }

        private SongPlayList(T ID, SongPlayList next) {
            this.ID = ID;
            this.next = next;
        }
    }

}
