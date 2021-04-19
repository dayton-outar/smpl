package smpl.sys.commands;


import java.util.Hashtable;

import smpl.sys.values.IValue;

public class IncrementCommand implements ICommand {
    
    String _var;

    public IncrementCommand(String var) {
        _var = var;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        dictionary.put(_var, dictionary.get(_var).inc() );

        dictionary.put("__return", dictionary.get(_var));
    }
}
