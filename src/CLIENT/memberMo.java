/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLIENT;

import CLASS.maintenance_Function;
import java.io.IOException;

/**
 *
 * @author Group
 */
public class memberMo {

    static void memberModule() throws IOException {
        
          //start the program
        maintenance_Function run = new maintenance_Function();
        boolean loggedIn = run.login();

        if (loggedIn = true) {
            run.displayInterface();
        }
        
    }
    
}
