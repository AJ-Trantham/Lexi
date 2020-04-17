package command;

import window.Window;
/**
 * Command (233): ConcreteCommand
 * Prototype (117): ConcretePrototype
 */
public class IncrementFontCommand extends Command {
    private ChangeFontCommand cfc;

    public IncrementFontCommand() {
        super(true);
        cfc  = new ChangeFontCommand();
    }

    @Override
    public void execute(Window window) {
        cfc.setFontSize(window.getFontSize()+1);
        cfc.execute(window);
    }

    @Override
    public void unexecute(Window window) {
        cfc.unexecute(window);
    }

    private void setcfc(ChangeFontCommand cfc) {
        this.cfc = cfc;
    }

    @Override
    public IncrementFontCommand copy() {
        IncrementFontCommand ifc = new IncrementFontCommand();
        ifc.setcfc(this.cfc.copy());
        return ifc;
    }
}
