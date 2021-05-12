package smpl.sys.values;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;

public class ArrayValue implements IValue {

    Vector<IValue> _val;
    public ArrayValue(Vector<IValue> val) {
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
        return true;
    }

    @Override
    public boolean isDictionary() {
        return false;
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
        return ( _val != null && _val.size() > 0 );
    }

    @Override
    public Vector<IValue> arrayValues() {
        return _val;
    }

    @Override
    public Hashtable<String, IExpression> getDictionary() {
        return null;
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

    public IValue sub(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).sub( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).sub( v ) : (new DoubleValue(0.0)).sub( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mul( (ArrayValue) this) : val.mul( (ArrayValue) this );
        }
    }

    public IValue mul(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).mul( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).mul( v ) : (new DoubleValue(0.0)).mul( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue div(IValue val) throws Exception {
        if (val.isArray()) {
            return this.div( (ArrayValue) val );
        } else {
            return val.isLong() ? val.div( (ArrayValue) this) : val.div( (ArrayValue) this );
        }
    }

    public IValue div(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).div( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).div( v ) : (new DoubleValue(0.0)).div( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mod( (ArrayValue) val );
        } else {
            return val.isLong() ? val.mod( (ArrayValue) this) : val.mod( (ArrayValue) this );
        }
    }

    public IValue mod(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).mod( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).mod( v ) : (new DoubleValue(0.0)).mod( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        if (val.isArray()) {
            return this.pow( (ArrayValue) val );
        } else {
            return val.isLong() ? this.pow( (LongValue) val) : this.pow( (DoubleValue) val );
        }
    }

    public IValue pow(LongValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform [1, 3, 2]**2 => [1, 9, 4]
        for (IValue ival : _val) {
            lvs.add( ival.pow( val ) );
        }
        
        return new ArrayValue( lvs );
    }

    public IValue pow(DoubleValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform [1, 3, 2]**2 => [1, 9, 4]
        for (IValue ival : _val) {
            lvs.add( ival.pow( val ) );
        }
        
        return new ArrayValue( lvs );
    }

    public IValue pow(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).pow( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).pow( v ) : (new DoubleValue(0.0)).pow( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        if (val.isArray()) {
            return this.ban( (ArrayValue) val );
        } else {
            return val.isLong() ? val.ban( (ArrayValue) this) : val.ban( (ArrayValue) this );
        }
    }

    public IValue ban(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).ban( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).ban( v ) : (new DoubleValue(0.0)).ban( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        if (val.isArray()) {
            return this.bor( (ArrayValue) val );
        } else {
            return val.isLong() ? val.bor( (ArrayValue) this) : val.bor( (ArrayValue) this );
        }
    }

    public IValue bor(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).bor( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).bor( v ) : (new DoubleValue(0.0)).bor( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        if (val.isArray()) {
            return this.bxr( (ArrayValue) val );
        } else {
            return val.isLong() ? val.bxr( (ArrayValue) this) : val.bxr( (ArrayValue) this );
        }
    }

    public IValue bxr(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();
        Vector<IValue> vals = val.arrayValues();

        // The intention is to perform [2, 3] + [1, 3, 2] => [3, 6, 2]
        int max = _val.size() >= vals.size() ? _val.size() : vals.size();        
        for (int x = 0; x < max; x++) {
            if (x < _val.size() & x < vals.size()) {
                lvs.add( _val.get(x).bxr( vals.get(x) ) );
            } else {
                if ( x >= _val.size() ) {
                    IValue v = vals.get(x);
                    lvs.add( v.isLong() ? (new LongValue(0l)).bxr( v ) : (new DoubleValue(0.0)).bxr( v ) );
                } else {
                    lvs.add( _val.get(x) );
                }
            }
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue biv() {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform ~[7, 5, 90] => [-8, -6, -91]
        for (IValue ival : _val) {
            lvs.add( ival.biv() );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue inc() {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform [7, 5, 90]++ => [8, 6, 91]
        for (IValue ival : _val) {
            lvs.add( ival.inc() );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue dec() {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform [7, 5, 90]-- => [6, 4, 89]
        for (IValue ival : _val) {
            lvs.add( ival.dec() );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue inv() {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform [7, 5, 90]-- => [6, 4, 89]
        for (IValue ival : _val) {
            lvs.add( ival.inv() );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue sqr() {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform [7, 5, 90]-- => [6, 4, 89]
        for (IValue ival : _val) {
            lvs.add( ival.sqr() );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue eq(IValue val) throws Exception {
        BooleanValue bv = new BooleanValue(this.booleanValue());

        if ( val instanceof ArrayValue ) {
            Vector<IValue> vals = val.arrayValues();

            // The intention is to perform [2, 3, 3] = [2, 3, 3] => true
            if ( _val.size() == vals.size() ) {
                for (int x = 0; x < _val.size(); x++) {
                    if ( !(_val.get(x).eq( vals.get(x) ).booleanValue()) )
                        break;
                }
                bv = new BooleanValue(true);
            }
        }
        
        return bv;
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        BooleanValue bv = new BooleanValue(false);

        if ( val instanceof ArrayValue ) {
            Vector<IValue> vals = val.arrayValues();

            // The intention is to perform [3, 3, 3] > [2, 3, 3] => false
            if ( _val.size() == vals.size() ) {
                for (int x = 0; x < _val.size(); x++) {
                    if ( !(_val.get(x).gt( vals.get(x) ).booleanValue()) )
                        break;
                }
                bv = new BooleanValue(true);
            }
        }
        
        return bv;
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        BooleanValue bv = new BooleanValue(false);

        if ( val instanceof ArrayValue ) {
            Vector<IValue> vals = val.arrayValues();

            // The intention is to perform [3, 3, 3] > [2, 3, 3] => false
            if ( _val.size() == vals.size() ) {
                for (int x = 0; x < _val.size(); x++) {
                    if ( !(_val.get(x).lt( vals.get(x) ).booleanValue()) )
                        break;
                }
                bv = new BooleanValue(true);
            }
        }
        
        return bv;
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        BooleanValue bv = new BooleanValue(false);

        if ( val instanceof ArrayValue ) {
            Vector<IValue> vals = val.arrayValues();

            // The intention is to perform [3, 3, 3] > [2, 3, 3] => false
            if ( _val.size() == vals.size() ) {
                for (int x = 0; x < _val.size(); x++) {
                    if ( !(_val.get(x).noteq( vals.get(x) ).booleanValue()) )
                        break;
                }
                bv = new BooleanValue(true);
            }
        }
        
        return bv;
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        BooleanValue bv = new BooleanValue(false);

        if ( val instanceof ArrayValue ) {
            Vector<IValue> vals = val.arrayValues();

            // The intention is to perform [3, 3, 3] > [2, 3, 3] => false
            if ( _val.size() == vals.size() ) {
                for (int x = 0; x < _val.size(); x++) {
                    if ( !(_val.get(x).gtoreq( vals.get(x) ).booleanValue()) )
                        break;
                }
                bv = new BooleanValue(true);
            }
        }
        
        return bv;
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        BooleanValue bv = new BooleanValue(false);

        if ( val instanceof ArrayValue ) {
            Vector<IValue> vals = val.arrayValues();

            // The intention is to perform [3, 3, 3] > [2, 3, 3] => false
            if ( _val.size() == vals.size() ) {
                for (int x = 0; x < _val.size(); x++) {
                    if ( !(_val.get(x).ltoreq( vals.get(x) ).booleanValue()) )
                        break;
                }
                bv = new BooleanValue(true);
            }
        }
        
        return bv;
    }

    @Override
    public IValue and(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue or(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue not() throws Exception {
        throw new Exception("Implementation does not exist for this type");
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