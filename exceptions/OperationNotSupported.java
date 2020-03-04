package exceptions;

/**
 * This Exception is thrown when an operation is not supported. This is typically thrown as a default behavior for Glyphs.
 * Penguins are Birds but they don't fly.
 */
public class OperationNotSupported extends Exception {

    public OperationNotSupported() {
        super("Operation not supported for this particular object. ");
    }
}
