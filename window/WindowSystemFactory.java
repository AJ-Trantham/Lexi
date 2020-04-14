package window;
/** Abstract factory in Abstract Factory Pattern(87)
 *  Singleton in Singleton(127)
 */
public abstract class WindowSystemFactory {
    private static WindowSystemFactory windowSystemFactory;


    public static WindowSystemFactory getWindowSystemFactory() throws Exception {
        // check to enforce Singleton on factory
        if (windowSystemFactory == null) {
            //get the correct implementation
            if (System.getenv("WINDOW").equals("Swing")) {
                windowSystemFactory = SwingWindowFactory.getInstance();
            } else if (System.getenv("WINDOW").equals("Awt")) {
                windowSystemFactory = AwtWindowFactory.getInstance();
            } else {
                throw new Exception("The provided windowing system is not a valid option. Options: Swing or Awt");
            }
        }
        return windowSystemFactory;
    }

    // factory method returns a windowing system - Client can create as many windows as needed
    abstract public  WindowImp createWindowImp(Window window, String title);
}
