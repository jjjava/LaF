package lookandfell;

import com.apple.eawt.AppEventListener;
import com.apple.eawt.Application;

/**
 *
 * @author hudson
 */
public class TesteDock {

    public TesteDock() {

        // create the menu items
        java.awt.MenuItem foo = new java.awt.MenuItem("Foo");
        java.awt.MenuItem bar = new java.awt.MenuItem("Bar");

// create the menu, and add the menu items
        java.awt.PopupMenu menu = new java.awt.PopupMenu();
        menu.add(foo);
        menu.add(bar);

        Application.getApplication().addAppEventListener(new teste());
        Application.getApplication().setDockIconBadge("work");
        Application.getApplication().setDockMenu(menu);

        new Thread() {

            @Override
            public void run() {
                this.setPriority(Thread.MIN_PRIORITY);
                try {
                    for (int k = 0; k <1000000; k++) {

                        Application.getApplication().setDockIconBadge("" + k);
                        Thread.sleep(10);//good quantum
                    }
                } catch (Exception w) {

                }

            }
        }.start();

    }

    public static void main(String args[]) {
        TesteDock t = new TesteDock();
    }
}

class teste implements AppEventListener {

}
