package com.resources.code.convention;


//In classes, interfaces and abstract classes the first letter of each word in the name will be uppercase
//Matching braces always line up vertically in the same column
public class PerfectClass 
{
	/** All indents are four spaces. */
	
	// fields
    
    // constructors

    // methods
	
	// All method declaration a call should be immediately followed by a left parenthesis
	public void doSomething(int k, boolean b) 
	{
		
		//All array dereferences should be immediately followed by a left square bracket.
		int arg[] = new int[6];
		arg[0] = 1;
		
		//Binary operators should have a space on either side.
		int a = 1 + 2;
		
		//Unary operators should be immediately preceded or followed by their operand.
		a++;
		
		//Commas and semicolons are always followed by whitespace.
		for (int i = 0; i < 10; i++) 
		{ 
			System.out.println("");
		}		
		// doSomething(1, true);
		
		//All casts should be written with no spaces.
		String s = (String)new Object(); 
		
		//The keywords if, while, for, switch, and catch must be followed by a space.
		/* if (true) while (false) catch (TooManyPancakesException e) */ 
		
		//Declare variables as close as possible to where they are used.
		
		//In large operations try to put the operation donw the line.
		int result = (5 + 3)
					 + (7 + 1);
		
		// Ways to build a array initialization
		
		// Ways to make a iteration
	}
	
// For methods all if, while and for statements must use braces even if they control just one statement.	
}
