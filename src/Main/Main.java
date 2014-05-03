package Main;

import Registers.RegisterFileParser;
import Registers.RegisterManager;


public class Main
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("HELLO ");
        for (int i = 0; i < args.length; i++)
            System.out.print(args[i] + " ");
        System.out.println();

       RegisterFileParser.instance.parseRegister(args[2]);
       
       
       RegisterManager.instance.setRegisterBusy("R0");
       RegisterManager.instance.dumpAllRegisters();

    }
}