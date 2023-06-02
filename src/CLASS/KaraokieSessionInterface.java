/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CLASS;

import ADT.QueueInterface;
import ENTITY.GuestList;
import ENTITY.Song;

/**
 *
 * @author Hong
 */
public interface KaraokieSessionInterface {
    
    /**
     *
     * Task: Ask for member / guest login .
     * 
     * @return in a guest array object
     */
    public GuestList[] getPaticipent();
    
    /**
     *Task: Ask for member / guest select songs.
     * 
     * 
     * @return the queue list ;
     */
    public QueueInterface<Song> selectSong();
    
    
    /**
     *Task: start the session with a GuestList object.
     * 
     * 
     * @param paticipent : a GuestList object.
     * @param playList : song queue list.
     */
    
    public void karaokieStart(GuestList[] paticipent, QueueInterface<Song> playList);
    
    
   /**
     *Task: show all queued song in the queue.
     * 
     * 
     * @param playList : song queue list.
     */
    public void showQueueSong(QueueInterface<Song> playList);
    
    public void addPoint(GuestList[] paticipent);
}
