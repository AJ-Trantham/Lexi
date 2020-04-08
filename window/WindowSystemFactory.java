package window;
/** Abstract factory in Abstract Factory Pattern(87)
 *  Singleton in Singleton(127)
 */
public class WindowSystemFactory {
    private static WindowSystemFactory windowSystemFactory;

    protected static WindowSystemFactory getWindowSystemFactory() {
        // check to enforce Singleton
        if (windowSystemFactory == null) {
            windowSystemFactory = new WindowSystemFactory();
        }
        return windowSystemFactory;
    }

    // factory method returns a windowing system - Client can create as many windows as needed
    protected WindowImp createWindowImp(Window window, String title) throws Exception {
        //get the correct implementation
        if (System.getenv("WINDOW").equals("Swing")) {
            return new SwingWindow(title, window);
        } else if (System.getenv("WINDOW").equals("Awt")) {
            return new AwtWindow(title, window);
        } else {
            throw new Exception("The provided windowing system is not a valid option. Options: Swing or Awt");
        }
    }
}
