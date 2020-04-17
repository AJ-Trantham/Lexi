package command;

import window.Window;

/** Command(233) Pattern: ConcreteCommand
 * Prototype (117): ConcretePrototype
 */
public class ChangeFontCommand extends Command {

    private int fontSize;
    private int lastFontSize;

    public ChangeFontCommand() {
        super(true);
    }

    public ChangeFontCommand(int newSize) {
        super(true);
        this.fontSize = newSize;
    }

    @Override
    public void execute(Window window) {
        lastFontSize = window.getFontSize();
        window.setFrontSize(fontSize);
        window.reformat();
        window.repaint();
    }

    @Override
    public void unexecute(Window window) {
        fontSize = lastFontSize;
        lastFontSize = window.getFontSize();
        window.setFrontSize(fontSize);
        window.reformat();
        window.repaint();
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    private void setLastFontSize(int fontSize) {
        this.lastFontSize = fontSize;
    }

    @Override
    public ChangeFontCommand copy() {
        ChangeFontCommand cfc = new ChangeFontCommand(fontSize);
        cfc.setLastFontSize(lastFontSize);
        return cfc;
    }
}
