package widget;

import formatting.Cursor;
import glyph.Glyph;
import window.Window;

public class RedButton extends AbstractButton {

    public RedButton(Window window) {
        super(window);
    }

    @ Override
    public void draw(Window window) {
        window.drawButton(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "red");
        //TODO: Could maybe move this to super, something to look into
        for (Glyph g:this.children) {
            g.draw(window);
        }
    }
}
