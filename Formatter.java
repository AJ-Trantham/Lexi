/** Represents the classes that will encapsulate a specific formatting algorithm*/
interface Formatter {
    /** What to format */
    void setComposition(Composition composition);
    /**  does the formatting when you need to */
    void compose();
}
