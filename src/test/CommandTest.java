package test;

import foobar.tool.toolkit.command.*;
import foobar.tool.toolkit.*;

/**
 * @description test code for "builder" design pattern
 * @author cys
 */

public class CommandTest {
	
	public static void main(String[] args) {
		//create a receiver (Success)
		ToolKit tk = new ToolKit();
		
		//output the level of toolkit
		//should output "1"
		System.out.println(tk.getLevel());
		
		//create a command
		Command tkCommand = new ToolKitCommand(tk);
		
		//execute
		tkCommand.execute();
		
		//output the level of toolkit after leveling up
		//should output "2"
		System.out.println(tk.getLevel());
	}
	
}
