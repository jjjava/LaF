package lookandfell;

/**
 *
 * @author hudson schumaker
 */
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import com.apple.eawt.Application;
import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

/**
 * A Java program that demonstrates how to handle the Mac OS X event when a file
 * is dropped onto a Java application's icon in the Dock. This same technique
 * also happens to work for other drag and drop file events on Mac OS X.
 *
 * @author alvin alexander, devdaily.com.
 *
 * @see
 * http://devworld.apple.com/documentation/Java/Reference/1.5.0/appledoc/api
 */
public class JavaMacDockTest {

    JFrame frame;

    public static void main(String[] args) {
        new JavaMacDockTest();
    }

    public JavaMacDockTest() {
        // create an instance of the mac osx Application class
        Application theApplication = new Application();

        // create an instance of our DockBarAdapter class (see source code below)
        DockBarAdapter dockBarAdapter = new DockBarAdapter(this);

        // add our adapter as a listener on the application object
        theApplication.addApplicationListener(dockBarAdapter);

        // create and display a simple jframe
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Mac Dock Icon Drag and Drop Test");
                // let the user close the application by pressing the frame's close icon
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(300, 200));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    // our "callback" method. this method is called by the DockBarAdapter
    // when a "handleOpenFile" event is received.
    public void handleOpenFileEvent(ApplicationEvent e) {
        JOptionPane.showMessageDialog(frame, "Got the file: " + e.getFilename());
    }
}

/**
 * Extend the Mac OS X ApplicationAdapter class, and just implement the
 * handleOpenFile() method so we can handle drag and drop events.
 */
class DockBarAdapter extends ApplicationAdapter {

    private JavaMacDockTest handler;

    // the main class passes a reference to itself to us when we are constructed
    public DockBarAdapter(JavaMacDockTest handler) {
        this.handler = handler;
    }

    // this is the method that is called when a drag and drop event is received
    // by the Application, and passed to us. In turn, we call back to the main
    // class to let it know this event was received so it can deal with the
    // event.
    @Override
    public void handleOpenFile(ApplicationEvent e) {
        handler.handleOpenFileEvent(e);
    }
}
