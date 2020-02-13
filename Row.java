import java.util.ArrayList;

public class Row extends Composition {

    public Row() {
        children = new ArrayList<Glyph>();
    }
   public void compose() {
       System.out.println("Compose in Row format");
    }
}
