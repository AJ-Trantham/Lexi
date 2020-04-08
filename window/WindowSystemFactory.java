package window;
/** Abstract factory in Abstract Factory Pattern(87) */
public class WindowSystemFactory {
    private static WindowImp imp;

    protected static WindowImp createWindowImp(Window window, String title) {
        if (imp == null) {
            //get a swing window implementation
            if (System.getenv("WINDOW").equals("Swing")) {
                imp = new SwingWindow(title, window);
            } else if (System.getenv("WINDOW").equals("Awt")) {
                imp = new AwtWindow(title, window);
            }
        }
        return imp;
    }
}
