/** Represents the classes that will encapsulate a specific formatting algorithm
 *  Compositor class in the Strategy Pattern (315)
 */
interface Formatter {
    /** What to format */
    void setComposition(Composition composition);
    /**  does the formatting when you need to */
    void format();
}
