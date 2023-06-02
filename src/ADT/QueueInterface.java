/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

/**
 *
 * @author Hong
 */
import java.util.Iterator;

public interface QueueInterface<T> {

    public Iterator<T> getIterator();

    public boolean enqueue(T newSongEntry);
    
    public T dequeue();

    public T getFront();

    public boolean isEmpty();
    
    public T[] getQueue();
    
    public void clear();
    
    
    
    

    // public void selectSong(T songID);
    //public void startProgram();
    // public void participantsVote(T songID);
    // public void GenerateReport();
}
