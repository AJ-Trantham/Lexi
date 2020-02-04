/**
 * This Exception is thrown when an operation is not supported. Penguins are Birds but they don't fly.
 */
public class PenguineException extends Exception {

    public PenguineException() {
        super("Operation not supported for this particular object. ");
    }
}
