package test;

import foobar.interpretor.Context;
import foobar.interpretor.ElementExpression;
import foobar.interpretor.ReadXmlExpression;

public class InterpretorTest {
    public static void main(String[] args) throws Exception {
        Context mesg=new Context ("D:\\java_demo\\11\\foobar\\interpretor\\Interperter.xml");
        String result="";
        ReadXmlExpression node=new ElementExpression(result);
        String[] command=node.interpret(mesg);
        System.out.println(command);
    }

}
