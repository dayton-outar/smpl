package smpl.sys.expressions;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.Program;
import smpl.sys.values.FunctionValue;
import smpl.sys.values.IValue;

public class FunctionExpression implements IExpression {

    String _function;
    Vector<IExpression> _parameters;
    
    public FunctionExpression(String function, Vector<IExpression> parameters) {
        _function = function;
        _parameters = parameters;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        FunctionValue fv = (FunctionValue)dictionary.get(_function);
        if (fv == null)
            throw new Exception( String.format("The function, %s, was not declared", _function) );

        Program prog = new Program( fv.getStatements() );

        Hashtable<String, IValue> programDictionary = new Hashtable<String, IValue>();
        // Use variables in global scope (or calling scope)
        programDictionary.putAll(dictionary);
        Vector<String> variables = fv.getParameters();
        int vsize = variables.size();

        if ( _parameters.size() < vsize )
            throw new Exception( String.format("The function, %1$s, requires at least %2$s parameters", _function, vsize) );

        for (int x = 0; x < vsize; x++) {
            programDictionary.put( variables.elementAt(x), _parameters.elementAt(x).evaluate(dictionary) );
        }
        
        
        prog.execute( programDictionary );
        
        return programDictionary.get("__return"); // Re-set as return value;
    }
}
