package smpl.sys.expressions;

import smpl.sys.values.IValue;

public class ArrayInitializationExpression implements IExpression {

    IExpression _num;
    String _var;
    IExpression _exp;
    
    public ArrayInitializationExpression(IExpression num, String var, IExpression exp) {
        _num = num;
        _var = var;
        _exp = exp;
    }

    @Override
    public IValue evaluate() {
        // TODO Auto-generated method stub
        
        // Use ArrayList<>
        System.out.println("EXPAND " + _num.evaluate() + " " + _var + " -> " + _exp.evaluate());

        return null;
    }
}