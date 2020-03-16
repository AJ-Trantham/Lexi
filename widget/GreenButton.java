package widget;

import glyph.Glyph;
import window.Window;

public class GreenButton extends AbstractButton {

    public GreenButton(Window window) {
        super(window);

    }

    public void draw(Window window) {
        window.drawButton(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "green");
        //TODO: Could maybe move this to super, something to look into
        for (Glyph g:this.children) {
            g.draw(window);
        }
        // draw children via embellishment
        //super.draw(window);
    }
}
