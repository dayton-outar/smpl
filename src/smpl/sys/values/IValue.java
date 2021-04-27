package smpl.sys.values;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;

public interface IValue {
    boolean isNumber();
    boolean isDouble();
    boolean isLong();
    boolean isArray();
    boolean isDictionary();
    long longValue();
    double doubleValue();
    boolean booleanValue();
    Vector<IValue> arrayValues();
    Hashtable<String, IExpression> getDictionary();
    
    IValue add(IValue val) throws Exception;    
    IValue sub(IValue val) throws Exception;
    IValue mul(IValue val) throws Exception;    
    IValue div(IValue val) throws Exception;    
    IValue mod(IValue val) throws Exception;    
    IValue pow(IValue val) throws Exception;    
    IValue ban(IValue val) throws Exception;    
    IValue bor(IValue val) throws Exception;    
    IValue bxr(IValue val) throws Exception;
    
    IValue biv();    
    IValue inc();    
    IValue dec();    
    IValue inv();    
    IValue sqr();

    // Logical Expressions
    IValue eq(IValue val) throws Exception;
    IValue gt(IValue val) throws Exception;    
    IValue lt(IValue val) throws Exception;
    IValue noteq(IValue val) throws Exception;
    IValue gtoreq(IValue val) throws Exception;
    IValue ltoreq(IValue val) throws Exception;

    // Relational Expressions
    IValue and(IValue val) throws Exception;
    IValue or(IValue val) throws Exception;
    IValue not() throws Exception;
}
