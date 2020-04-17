package command;

import window.Window;

public class DecrementFontCommand extends Command {
    private ChangeFontCommand cfc;

    public DecrementFontCommand() {
        super(true);
        cfc = new ChangeFontCommand();
    }

    @Override
    public void execute(Window window) {
        cfc.setFontSize(window.getFontSize()-1);
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
    public DecrementFontCommand copy() {
        DecrementFontCommand dfc = new DecrementFontCommand();
        dfc.setcfc(this.cfc.copy());
        return dfc;
    }
}
