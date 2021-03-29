package smpl.sys.commands;

import java.util.Vector;

import smpl.sys.expressions.IExpression;

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
    public void execute() {

        System.out.println("LOOP (" + _initializeList.toString() + "; " + _condition.evaluate() + "; " + _incrementExpression.evaluate() + ") {\n" + _statements.toString() + "\n}");
    }
    
}
