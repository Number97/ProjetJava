/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.java;

import javax.swing.SwingUtilities;
import view.MainWindow;
import view.LoginWindow;

/**
 *
 * @author sLaDer_pH
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginWindow login = new LoginWindow();
            }
        });
    }
    
}
