package smpl.sys.values;

import java.util.Vector;

public class ArrayValue implements IValue {

    Vector<IValue> _val;
    public ArrayValue(Vector<IValue> val) {
        _val = val;
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
        return true;
    }
    @Override
    public long longValue() {
        return 0;
    }
    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append( String.join(", ", _val.toArray(new String[_val.size()]) ) );
        sb.append("]");
        return sb.toString();
    }
}