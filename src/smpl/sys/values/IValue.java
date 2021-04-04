package smpl.sys.values;

import java.util.Vector;

public interface IValue {
    boolean isNumber();
    boolean isDouble();
    boolean isLong();
    boolean isArray();
    long longValue();
    double doubleValue();
    boolean booleanValue();
    Vector<IValue> arrayValues();
    
    IValue add(IValue val) throws Exception;
    IValue add(DoubleValue val);
    IValue add(LongValue val);
    IValue add(ArrayValue val);
    
    IValue sub(IValue val) throws Exception;
    IValue sub(DoubleValue val);
    IValue sub(LongValue val);
    IValue sub(ArrayValue val);

    IValue mul(IValue val) throws Exception;
    IValue mul(DoubleValue val);
    IValue mul(LongValue val);
    IValue mul(ArrayValue val);
    
    IValue div(IValue val) throws Exception;
    IValue div(DoubleValue val);
    IValue div(LongValue val);
    IValue div(ArrayValue val) throws Exception;
    
    IValue mod(IValue val) throws Exception;
    IValue mod(DoubleValue val);
    IValue mod(LongValue val);
    IValue mod(ArrayValue val) throws Exception;
    
    IValue pow(IValue val) throws Exception;
    IValue pow(DoubleValue val);
    IValue pow(LongValue val);
    IValue pow(ArrayValue val) throws Exception;
    
    IValue ban(IValue val) throws Exception;
    IValue ban(LongValue val);
    IValue ban(ArrayValue val) throws Exception;
    
    IValue bor(IValue val) throws Exception;
    IValue bor(LongValue val);
    IValue bor(ArrayValue val) throws Exception;
    
    IValue bxr(IValue val) throws Exception;
    IValue bxr(LongValue val);
    IValue bxr(ArrayValue val) throws Exception;
    
    IValue biv();
    
    IValue inc();
    
    IValue dec();
    
    IValue inv();
    
    IValue sqr();

    // Logical Expressions
    IValue eq(IValue val) throws Exception;
    IValue eq(DoubleValue val);
    IValue eq(LongValue val);
    IValue eq(ArrayValue val) throws Exception;

    IValue gt(IValue val) throws Exception;
    IValue gt(DoubleValue val);
    IValue gt(LongValue val);
    IValue gt(ArrayValue val) throws Exception;
    
    IValue lt(IValue val) throws Exception;
    IValue lt(DoubleValue val);
    IValue lt(LongValue val);
    IValue lt(ArrayValue val) throws Exception;

    IValue noteq(IValue val) throws Exception;
    IValue noteq(DoubleValue val);
    IValue noteq(LongValue val);
    IValue noteq(ArrayValue val) throws Exception;

    IValue gtoreq(IValue val) throws Exception;
    IValue gtoreq(DoubleValue val);
    IValue gtoreq(LongValue val);
    IValue gtoreq(ArrayValue val) throws Exception;

    IValue ltoreq(IValue val) throws Exception;
    IValue ltoreq(DoubleValue val);
    IValue ltoreq(LongValue val);
    IValue ltoreq(ArrayValue val) throws Exception;

    // Relational Expressions
    IValue and(IValue val) throws Exception;
    IValue and(BooleanValue val) throws Exception;

    IValue or(IValue val) throws Exception;
    IValue or(BooleanValue val) throws Exception;
    IValue not() throws Exception;
}
