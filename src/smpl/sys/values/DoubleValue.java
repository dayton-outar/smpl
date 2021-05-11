package smpl.sys.values;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;

/**
 * @author Dayton Outar
 * 
 */
public class DoubleValue implements IValue {
    
    Double _val;
    public DoubleValue(Double val) {
        _val = val;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isLong() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isDictionary() {
        return false;
    }

    /**
     * Returns the value of this object as long data type
     */
    @Override
    public long longValue() {
        return _val.longValue();
    }

    @Override
    public double doubleValue() {
        return _val.doubleValue();
    }

    @Override
    public boolean booleanValue() {
        return _val == 0;
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
        if (val.isArray()) {
            return this.add( (ArrayValue) val );
        } else {
            return this.add( new DoubleValue(val.doubleValue()) );
        }
    }

    public IValue add(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() + val.doubleValue() ) );
    }

    public IValue add(LongValue val) {
        return this.add( new DoubleValue(val.doubleValue()) );
    }

    public IValue add(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2 + [1, 3, 2] => [3, 5, 4]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.add( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        if (val.isArray()) {
            return this.sub( (ArrayValue) val );
        } else {
            return this.sub( new DoubleValue(val.doubleValue()) );
        }
    }

    public IValue sub(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() - val.doubleValue() ) );
    }

    public IValue sub(LongValue val) {
        return this.sub( new DoubleValue(val.doubleValue()) );
    }

    public IValue sub(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2 - [1, 3, 2] => [1, -1, 0]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.sub( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mul( (ArrayValue) val );
        } else {
            return this.mul( new DoubleValue(val.doubleValue()) );
        }
    }

    public IValue mul(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() * val.doubleValue() ) );
    }

    public IValue mul(LongValue val) {
        return this.mul( new DoubleValue(val.doubleValue()) );
    }

    public IValue mul(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 3 * [1, 3, 2] => [3, 9, 6]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.mul( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue div(IValue val) throws Exception {
        if (val.isArray()) {
            return this.div( (ArrayValue) val );
        } else {
            return this.div( new DoubleValue(val.doubleValue()) );
        }
    }

    public IValue div(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() / val.doubleValue() ) );
    }

    public IValue div(LongValue val) {
        return this.div( new DoubleValue(val.doubleValue()) );
    }

    public IValue div(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 4 / [1, 3, 2] => [4, 0.75, 2]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.div( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        if (val.isArray()) {
            return this.mod( (ArrayValue) val );
        } else {
            return this.mod( new DoubleValue(val.doubleValue()) );
        }
    }

    public IValue mod(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() % val.doubleValue() ) );
    }

    public IValue mod(LongValue val) {
        return this.mod( new DoubleValue(val.doubleValue()) );
    }

    public IValue mod(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 4 % [1, 3, 2] => [1, 3, 0]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.mod( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.pow( (ArrayValue) val);
        } else {
            return new DoubleValue( Math.pow( this.doubleValue(), val.doubleValue() ) );
        }
    }

    public IValue pow(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2**[1, 3, 2] => [2, 8, 4]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.pow(ival) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        if (val.isArray()) {
            return this.ban( (ArrayValue) val );
        } else {
            return this.ban( (LongValue) val );
        }
    }

    public IValue ban(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() & val.longValue() ) );
    }

    public IValue ban(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2**[1, 3, 2] => [2, 8, 4]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.ban(ival) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        if (val.isArray()) {
            return this.bor( (ArrayValue) val );
        } else {
            return this.bor( (LongValue) val );
        }
    }

    public IValue bor(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() | val.longValue() ) );
    }

    public IValue bor(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2**[1, 3, 2] => [2, 8, 4]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.bor(ival) );
        }
        
        return new ArrayValue( lvs );
    }
    
    @Override
    public IValue bxr(IValue val) throws Exception {
        if (val.isArray()) {
            return this.bxr( (ArrayValue) val );
        } else {
            return this.bxr( (LongValue) val );
        }
    }

    public IValue bxr(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() ^ val.longValue() ) );
    }

    public IValue bxr(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2**[1, 3, 2] => [2, 8, 4]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.bxr(ival) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue biv() {
        return new LongValue( Long.valueOf( ~this.longValue() ) );
    }

    @Override
    public IValue inc() {
        double val = this.doubleValue();
        val++;

        return new DoubleValue( Double.valueOf( val ) );
    }

    @Override
    public IValue dec() {
        double val = this.doubleValue();
        val--;

        return new DoubleValue( Double.valueOf( val ) );
    }

    @Override
    public IValue inv() {
        return new DoubleValue( Double.valueOf( -this.doubleValue() ) );
    }

    @Override
    public IValue sqr() {
        return new DoubleValue( Math.sqrt( this.doubleValue() ) );
    }

    @Override
    public IValue eq(IValue val) throws Exception {
        if (val.isArray()) {
            return this.eq( (ArrayValue) val );
        } else {
            return this.eq( (DoubleValue) val );
        }
    }

    public IValue eq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    public IValue eq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    public IValue eq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        if (val.isArray()) {
            return this.gt( (ArrayValue) val );
        } else {
            return this.gt( (DoubleValue) val );
        }
    }

    public IValue gt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    public IValue gt(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    public IValue gt(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        if (val.isArray()) {
            return this.lt( (ArrayValue) val );
        } else {
            return this.lt( (DoubleValue) val );
        }
    }

    public IValue lt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    public IValue lt(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    public IValue lt(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        if (val.isArray()) {
            return this.noteq( (ArrayValue) val );
        } else {
            return this.noteq( (DoubleValue) val );
        }
    }

    public IValue noteq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    public IValue noteq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    public IValue noteq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        if (val.isArray()) {
            return this.gtoreq( (ArrayValue) val );
        } else {
            return this.gtoreq( (DoubleValue) val );
        }
    }

    public IValue gtoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    public IValue gtoreq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    public IValue gtoreq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        if (val.isArray()) {
            return this.ltoreq( (ArrayValue) val );
        } else {
            return this.ltoreq( (DoubleValue) val );
        }
    }

    public IValue ltoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    public IValue ltoreq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    public IValue ltoreq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue and(IValue val) throws Exception {
        return new BooleanValue(this.booleanValue() && val.booleanValue());
    }

    @Override
    public IValue or(IValue val) throws Exception {
        return new BooleanValue(this.booleanValue() || val.booleanValue());
    }

    @Override
    public IValue not() throws Exception {
        return new BooleanValue( !this.booleanValue() );
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
