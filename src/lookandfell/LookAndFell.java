/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lookandfell;

import javax.swing.UIManager;

/**
 *
 * @author hudson
 */
public class LookAndFell {

    /**
     * @param args the commandˆ line arguments
     */
    public static void main(String[] args) {

        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
            System.out.println(look.getName());
        }
    }

}
