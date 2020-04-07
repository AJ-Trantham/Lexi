package window;

// Abstract factory in Abstract Factory Pattern(87)
//public class WindowSystemFactory {
//    public WindowImp getInstance( Window window) {
//        if (windowImp == null) {
//            //get a swing window implementation
//            if (System.getenv("WINDOW").equals("Swing")) {
//                windowImp = new SwingWindow(window.getTitle(), window);
//            } else if (System.getenv("WINDOW").equals("Awt")) {
//                windowImp = new AwtWindow(window.getTitle(), window);
//            }
//        }
//        return windowImp;
//    }
//}
