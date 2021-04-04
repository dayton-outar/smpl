package smpl.sys.commands;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Hashtable;

import smpl.sys.values.DoubleValue;
import smpl.sys.values.IValue;

public class ReadCommand implements ICommand {
    
    String _var;
    public ReadCommand(String var) {
        _var = var;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        System.out.println("READ INTO " + _var); // TODO: Exception handling for execute need to be added to interface
        
        DataInputStream in  = new DataInputStream(System.in);
        try {
            String val = in.readLine();

            dictionary.put(_var, new DoubleValue( Double.valueOf(val)) );

        } catch (IOException ioe) {

        }
    }
}
