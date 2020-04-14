package window;

public class AwtWindowFactory extends WindowSystemFactory {
    private static WindowSystemFactory instance;


    public static WindowSystemFactory getInstance() {
        if (instance == null) {
            instance = new AwtWindowFactory();
        }
        return instance;
    }
    @Override
    public  WindowImp createWindowImp(Window window, String title) {
        return new AwtWindow(title, window);
    }
}
