package test;

import foobar.tool.toolkit.ToolKit;
import foobar.tool.toolkit.command.ToolKitCommand;
import logger.logger;


/**
 * @description test code for memento design pattern
 * @author hyl
 */

public class MementoTest {

    public static void main(String[] args) {
		//test for Flyweight (Success)
		System.out.println("============= start test memento! =============");
		ToolKit tk = new ToolKit();
		ToolKitCommand tkc = new ToolKitCommand(tk);
		logger.println(tk.getLevel());
		tkc.execute();//1
		logger.println(tk.getLevel());
		tkc.redo();//2
		logger.println(tk.getLevel());
		tkc.undo();//3
		logger.println(tk.getLevel());
		System.out.println("========== Successfully test memento! ===========");
    }
}
