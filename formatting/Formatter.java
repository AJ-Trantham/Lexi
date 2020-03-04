package formatting;

import glyph.Composition;

/** Represents the classes that will encapsulate a specific formatting algorithm
 *  Strategy class in the Strategy Pattern (315)
 */
public interface Formatter {
    /** What to format */
    void setComposition(Composition composition);
    /**  does the formatting when you need to */
    void format();
}
