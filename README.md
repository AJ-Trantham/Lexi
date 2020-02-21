# Lexi

Author: AJ Trantham
Class: CS 472

To Run: javac Lexi.java
        java Lexi
        
Description: Lexi is a graphical document editor, based on the case study presented
             in Gamma's Design Patterns book.
             
Structure: Lexi uses two design patterns. Composite (163) organizes the structure of Lexi's components - called Glyphs. These Glyphs
are stored in a recursive composition herarchical structure. Both primitaive graphical elements (leaf glyphs) and 
structural Glyphs called Composites (Glyphs with children) can be treated uniformally throughout the Lexi Project. 
Lexi also uses the Strategy pattern (315) for formatting. Although Lexi currently only has one formatter (strategy)
implemented at this time, this pattern allows the addition of more formatting algorithms without altering any of Lexi's
base code. 
