package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public interface ICommand {
    
    public void execute(Hashtable<String, IValue> dictionary);
}
