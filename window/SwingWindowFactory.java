package window;

public class SwingWindowFactory extends WindowSystemFactory {
    private static WindowSystemFactory instance;

    protected SwingWindowFactory() {super();}

    public static WindowSystemFactory getInstance() {
        if (instance == null) {
            instance = new SwingWindowFactory();
        }
        return instance;
    }
    @Override
    public WindowImp createWindowImp(Window window, String title){
        return new SwingWindow(title, window);
    }
}
