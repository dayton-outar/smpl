package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.ProgramState;
import smpl.sys.values.IValue;

public class LoopCommand implements ICommand {

    Vector<ICommand> _initializeList;
    IExpression _condition;
    IExpression _incrementExpression;
    Vector<ICommand> _statements;

    public LoopCommand(Vector<ICommand> initializeList, IExpression condition, IExpression incrementExpression, Vector<ICommand> statements) {
        _initializeList = initializeList;
        _condition = condition;
        _incrementExpression = incrementExpression;
        _statements = statements;
    }

    @Override
    public void execute(ProgramState state) {

        Hashtable<String, IValue> dictionary = state.getDictionary();

        System.out.println("LOOP (" + _initializeList.toString() + "; " + _condition.evaluate(dictionary) + "; " + _incrementExpression.evaluate(dictionary) + ") {\n" + _statements.toString() + "\n}");
    }
    
}
