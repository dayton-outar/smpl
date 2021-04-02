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
    public IValue evaluate(Hashtable<String, IValue> dictionary) {
        FunctionValue fv = (FunctionValue)dictionary.get(_function);
        Program prog = new Program( fv.getStatements() );

        Hashtable<String, IValue> programDictionary = new Hashtable<String, IValue>();
        Vector<String> variables = fv.getParameters();
        for (int x = 0; x < variables.size(); x++) {
            programDictionary.put( variables.elementAt(x), _parameters.elementAt(x).evaluate(dictionary) );
        }
        
        programDictionary.putAll(dictionary); // Use this to use variables in global scope (or calling scope)
        prog.execute( programDictionary );
        
        return programDictionary.get("__return"); // Re-set as return value;
    }
}
