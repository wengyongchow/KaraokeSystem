/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CLASS;

/**
 *
 * @author Hong
 */
import ADT.JJArrayList;
import ADT.JJListInterface;
import ADT.ZYList;
import ADT.ZYListInterface;

import ENTITY.Member;
import ENTITY.Song;




public interface DataConfigInterface {
    

    public ZYListInterface<Member> MEMBERLIST = new ZYList<>();
    public JJListInterface<Song> SONGLIST = new JJArrayList<>();
   
    public void addAllMember();
    public void addSong();
}
