package widget;

import formatting.Cursor;
import glyph.Glyph;
import window.Window;

public class RedLabel extends AbstractLabel {
    public RedLabel(Window window) {
        super(window);
    }

    @Override
    public void draw(Window window) {
        window.drawLabel(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "red");
        //TODO: Could maybe move this to super, something to look into
        for (Glyph g:this.children) {
            g.draw(window);
        }
    }
}
