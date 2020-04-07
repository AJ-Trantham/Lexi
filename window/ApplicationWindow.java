package window;

import glyph.Glyph;

public class ApplicationWindow extends Window {
    private String title;
    public ApplicationWindow (String title) {
        //make a new factory and get a window imp then call the window imp methods for
        super();
        this.title=title;
}

    @Override
    protected String getTitle() {
        return title;
    }
}
