package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public class ReadCommand implements ICommand {
    
    String _var;
    public ReadCommand(String var) {
        _var = var;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        System.out.println("READ INTO " + _var); // TODO: Use input stream to get value from key entry
    }
}
