package smpl.sys.values;

import java.util.Vector;

public class ArrayValue implements IListValue {

    Vector<IValue> _val;
    public ArrayValue(Vector<IValue> val) {
        _val = val;
    }

    @Override
    public IValue add(INumValue val) {
        // TODO: Compute array items by reference
        //for (IValue iv : _val) {
        //    val.add((INumValue)iv);
        //}
        return null;
    }

    @Override
    public IValue add(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ban(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ban(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bor(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bor(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(INumValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue biv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue inc() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public IValue dec() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue inv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sqr() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue eq(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(IListValue val) {
        // TODO Auto-generated method stub
        return null;
    }
}