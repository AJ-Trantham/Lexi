import java.util.ArrayList;

public class Column extends Composition {

    public Column() {
        children = new ArrayList<Glyph>();
    }

    public void compose() {
        System.out.println("Compaose in Colunm format");
    }

}
