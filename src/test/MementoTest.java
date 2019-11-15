package test;

import foobar.people.Farmer;
import foobar.people.Farmhand;
import foobar.people.mementoes.SalaryStorage;
import foobar.people.types.JobCategory;
import foobar.tool.toolkit.ToolKit;
import foobar.tool.toolkit.command.ToolKitCommand;
import logger.logger;


/**
 * @description test code for memento design pattern
 * @author hyl
 */

public class MementoTest {

    public static void main(String[] args) {
		//test for ToolLit Memento (Success)
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

		//test for Salary Memento (Success)
		Farmer farmer = Farmer.getFarmer("Farmer");  // 单例模式
		Farmhand Alice = farmer.employFarmhand("Alice", 1000, JobCategory.AGRICULTURE);

		SalaryStorage salaryStorage = new SalaryStorage(Alice.createSalaryMemento());
		System.out.println(Alice.getName() + "'s original salary is $" + Alice.getSalary() + '.');
		// 修改薪水值
		Alice.setSalary(5000);
		System.out.println(Alice.getName() + "'s salary is $" + Alice.getSalary() + " after revision.");
		// 恢复薪水值
		Alice.restoreFromSalaryMemento((salaryStorage.getSalaryMemento()));
		System.out.println(Alice.getName() + "'s salary is $" + Alice.getSalary() + " after restoration.");
		System.out.println("========== Successfully test memento! ===========");
    }
}
