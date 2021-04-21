package smpl.sys.util;

import java.util.Vector;

import smpl.sys.commands.ICommand;

public class Cases {
    
    Vector<String> _values;
    ICommand _statement;

    public Cases(Vector<String> values, ICommand statement) {
        _values = values;
        _statement = statement;
    }

    /**
     * Get case value
     * 
     * @return Vector<String>
     */
    public Vector<String> getCaseValues() {
        return _values;
    }

    /**
     * Get expression
     * 
     * @return ICommand
     */
    public ICommand getStatement() {
        return _statement;
    }
}
