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
    public boolean booleanValue() {
        return false;
    }

    @Override
    public Vector<IValue> arrayValues() {
        return _val;
    }

    @Override
    public IValue add(IValue val) throws Exception {
        if (val.isArray()) {
            return this.add( (ArrayValue) val );
        } else {
            return val.isLong() ? val.add( (ArrayValue) this) : val.add( (ArrayValue) this );
        }
    }

    public IValue add(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).add( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    lvs.add( vals.get(x) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        if (val.isArray()) {
            return this.sub( (ArrayValue) val );
        } else {
            return val.isLong() ? val.sub( (ArrayValue) this) : val.sub( (ArrayValue) this );
        }
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mul( (ArrayValue) this) : val.mul( (ArrayValue) this );
        }
    }

    @Override
    public IValue div(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mul( (ArrayValue) this) : val.mul( (ArrayValue) this );
        }
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mul( (ArrayValue) this) : val.mul( (ArrayValue) this );
        }
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mul( (ArrayValue) this) : val.mul( (ArrayValue) this );
        }
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mul( (ArrayValue) this) : val.mul( (ArrayValue) this );
        }
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
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
    public IValue eq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue and(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue or(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue not() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Vector<String> stringValues = valueStrings();

        sb.append("[");
        sb.append( String.join(", ", stringValues.toArray(new String[stringValues.size()]) ) );
        sb.append("]");
        return sb.toString();
    }

    private Vector<String> valueStrings(){
        Vector<String> stringValue = new Vector<String>();
        for (IValue iValue : _val) {
            stringValue.add( iValue.toString() );
        }

        return stringValue;
    }
}