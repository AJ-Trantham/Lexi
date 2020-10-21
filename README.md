# Lexi

Author: AJ Trantham

## To Run
javac Lexi.java
        export LEXILOOK=<Green or Red>
	    export WINDOW=<Swing or Awt>
        java Lexi
    
 ## Description
 Lexi is a graphical document editor, based on the case study presented
             in The Gang of Four's Design Patterns book.
   
### Design Patterns Used   
##### Structure 
Lexi uses two design patterns. Composite (163) organizes the structure of Lexi's components - called Glyphs. These Glyphs
are stored in a recursive composition herarchical structure. Both primitaive graphical elements (leaf glyphs) and 
structural Glyphs called Composites (Glyphs with children) can be treated uniformally throughout the Lexi Project. 

##### Formatting
Lexi also uses the Strategy pattern (315) for formatting. Although Lexi currently only has one formatter (strategy)
implemented at this time, this pattern allows the addition of more formatting algorithms without altering any of Lexi's
base code. 

##### Look and Feel
AbstractFactory(87), Factory Method (107) and Singelton(127) patterns are employed to create widgets (Button and Labels). Widgets are a subclass of embellishment and have a particular look and feel (Red or Green) which is detirmined from the environment variable LEXILOOK.   

Like the Look and Feel, Lexi's Windowing System is detirmined at runtime by an envirnment variable between Swing or Awt (Although more could be added)
To get this functionality the Bridge Pattern is used to link the Window objects to a WindowImp. 

##### Commands
Lexi now can execute Commands. Commands are represented in Objects using the Command Pattern(233). Glyphs store a command
and a command history class keeps track of them. Commands also implement the prototype pattern (117) to enable them to
easily make copies of themselves. Finally, the Chain of Responsibility Pattern is used to traverse the Glyph tree to find 
the specific Glyph that was clicked. 



 
