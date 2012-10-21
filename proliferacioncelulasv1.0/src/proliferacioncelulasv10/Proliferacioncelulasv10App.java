/*
 * lo modifico reyes
 * Proliferacioncelulasv10App.java
 */

package proliferacioncelulasv10;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import java.sql.*;

/**
 * The main class of the application.
 */
public class Proliferacioncelulasv10App extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new Proliferacioncelulasv10View(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of Proliferacioncelulasv10App
     */
    public static Proliferacioncelulasv10App getApplication() {
        return Application.getInstance(Proliferacioncelulasv10App.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(Proliferacioncelulasv10App.class, args);
        System.out.print("hola");
        //otra vaina
    }
}
