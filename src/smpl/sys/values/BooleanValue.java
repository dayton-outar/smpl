package smpl.sys.values;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;

public class BooleanValue implements IValue {
    
    Boolean _val;
    public BooleanValue(Boolean val) {
        _val = val;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public boolean isLong() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isDictionary() {
        return false;
    }

    @Override
    public long longValue() {
        return _val.booleanValue() ? 1l : 0l;
    }

    @Override
    public double doubleValue() {
        return _val.booleanValue() ? 1.0 : 0.0;
    }

    @Override
    public boolean booleanValue() {
        return _val.booleanValue();
    }

    @Override
    public Vector<IValue> arrayValues() {
        return null;
    }

    @Override
    public Hashtable<String, IExpression> getDictionary() {
        return null;
    }

    @Override
    public IValue add(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue div(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue biv() {
        return null;
    }

    @Override
    public IValue inc() {
        return null;
    }

    @Override
    public IValue dec() {
        return null;
    }

    @Override
    public IValue inv() {
        return null;
    }

    @Override
    public IValue sqr() {
        return null;
    }

    @Override
    public IValue eq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue and(IValue val) throws Exception {
        return new BooleanValue(this.booleanValue() && val.booleanValue());
    }

    public IValue or(IValue val) throws Exception {
        return new BooleanValue(this.booleanValue() || val.booleanValue());
    }

    @Override
    public IValue not() {
        return new BooleanValue( Boolean.valueOf( !this.booleanValue() ) );
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
