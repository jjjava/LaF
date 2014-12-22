package lookandfell;

import javax.swing.UIManager;

/**
 *
 * @author hudson schumaker
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