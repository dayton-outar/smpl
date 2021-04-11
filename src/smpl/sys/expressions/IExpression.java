package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public interface IExpression {
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception;
}
