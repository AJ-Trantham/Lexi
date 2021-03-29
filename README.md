# Lexi

Author: AJ Trantham

## To Run
javac Lexi.java
        export LEXILOOK=<Green or Red>
	    export WINDOW=<Swing or Awt>
        java Lexi
    
 ## Description
 Lexi is a graphical document editor, based on the case study presented
 in The Gang of Four's Design Patterns book. All design patterns referenced are from 
 the Design Patterns book and referenced by the page number.
   
### Design Patterns Used   
##### Structure 
Composite (163) organizes the structure of Lexi's components - called Glyphs. These Glyphs
are stored in a recursive composition herarchical structure. Both primitaive graphical elements (leaf glyphs) and 
structural Glyphs called Composites (Glyphs with children) can be treated uniformally throughout the Lexi Project. 

##### Formatting
Lexi also uses the Strategy pattern (315) for formatting. Although Lexi currently only has one formatter (Strategy pattern)
implemented at this time, this pattern allows the addition of more formatting algorithms without altering any of Lexi's
base code. 

##### Look and Feel
AbstractFactory(87), Factory Method (107) and Singelton(127) patterns are employed to create widgets (Button and Labels). Widgets are a subclass of Embellishment and have a particular look and feel (Red or Green) which is detirmined from the environment variable LEXILOOK.   

Like the Look and Feel, Lexi's Windowing System is detirmined at runtime by an envirnment variable between Swing or Awt (Although more windowing options could be added)
To get this functionality the Bridge Pattern is used to link the Window objects to a WindowImp. 

##### Commands
Commands are represented using the Command Pattern(233). Glyphs store a command.
An independant Command History is held by the client Lexi. Commands also implement the prototype pattern (117) to enable them to
easily make copies of themselves which is useful for the command history. Finally, the Chain of Responsibility Pattern is used to traverse the Glyph tree to find 
the specific Glyph that was clicked. Once the glyph is found its command is executed.



 
