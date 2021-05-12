package smpl.sys.values;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;

public class LongValue implements IValue {
    
    Long _val;
    int _radix;

    public LongValue(Long val) {
        _radix = 10;
        _val = val;
    }

    public LongValue(Long val, int radix) {
        _radix = radix;
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
        return true;
    }

    @Override
    public boolean isDouble() {
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
        if ( val.isArray() ) {
            return this.add( (ArrayValue) val);
        } else {
            return val.isLong() ? this.add( (LongValue) val) : this.add( (DoubleValue) val);
        }
    }

    public IValue add(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() + val.doubleValue() ) );
    }

    public IValue add(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() + val.longValue() ), this._radix );
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
        if ( val.isArray() ) {
            return this.sub( (ArrayValue) val);
        } else {
            return val.isLong() ? this.sub( (LongValue) val) : this.sub( (DoubleValue) val);
        }
    }

    public IValue sub(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() - val.doubleValue() ) );
    }

    public IValue sub(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() - val.longValue() ), this._radix );
    }

    public IValue sub(ArrayValue val) throws Exception{
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 1 - [1, 3, 2] => [0, 2, 1]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.sub( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.mul( (ArrayValue) val);
        } else {
            return val.isLong() ? this.mul( (LongValue) val) : this.mul( (DoubleValue) val);
        }
    }

    public IValue mul(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() * val.doubleValue() ) );
    }

    public IValue mul(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() * val.longValue() ), this._radix );
    }

    public IValue mul(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 1 - [1, 3, 2] => [0, 2, 1]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.mul( ival ) );
        }
        
        return new ArrayValue( lvs );
    }
    
    @Override
    public IValue div(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.div( (ArrayValue) val);
        } else {
            return val.isLong() ? this.div( (LongValue) val) : this.div( (DoubleValue) val);
        }
    }

    public IValue div(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() / val.doubleValue() ) );
    }

    public IValue div(LongValue val) {
        Double dividend = this.doubleValue() / val.doubleValue();
        double remainder = dividend % 1.0; // TODO: Refactor. Duplicated code
        return ( remainder == 0.0 ) ? new LongValue( dividend.longValue(), this._radix ) : new DoubleValue( dividend ) ;
    }

    public IValue div(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 6 / [1, 3, 2] => [6, 2, 3]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.div(ival) );
        }
        
        return new ArrayValue( lvs );
    }
    
    @Override
    public IValue mod(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.mod( (ArrayValue) val);
        } else {
            return val.isLong() ? this.mod( (LongValue) val) : this.mod( (DoubleValue) val);
        }
    }

    public IValue mod(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.longValue() % val.doubleValue() ) );
    }

    public IValue mod(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() % val.longValue() ), this._radix );
    }

    public IValue mod(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 1 - [1, 3, 2] => [0, 2, 1]
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
            Double exponent = Math.pow( this.doubleValue(), val.doubleValue() );
            double remainder = exponent % 1.0; // TODO: Refactor. Duplicated code
            return ( remainder == 0.0 ) ? new LongValue( exponent.longValue(), this._radix ) : new DoubleValue( exponent ) ;
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
        if ( val.isArray() ) {
            return this.ban( (ArrayValue) val);
        } else {
            return this.ban( (LongValue) val);
        }
    }
    
    public IValue ban(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() & val.longValue() ), this._radix );
    }
    
    public IValue ban(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 5 & [1, 4, 2] => [1, 4, 0]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.ban( ival ) );
        }
        
        return new ArrayValue( lvs );
    }
    
    @Override
    public IValue bor(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.bor( (ArrayValue) val);
        } else {
            return this.bor( (LongValue) val);
        }
    }
    
    public IValue bor(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() | val.longValue() ), this._radix );
    }
    
    public IValue bor(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 5 | [1, 4, 2] => [5, 5, 7]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.bor( ival ) );
        }
        
        return new ArrayValue( lvs );
    }
    
    @Override
    public IValue bxr(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.bxr( (ArrayValue) val);
        } else {
            return this.bxr( (LongValue) val);
        }
    }
    
    public IValue bxr(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() ^ val.longValue() ), this._radix );
    }
    
    public IValue bxr(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 5 | [1, 4, 2] => [5, 5, 7]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.bxr( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue biv() {
        return new LongValue( Long.valueOf( ~this.longValue() ), this._radix );
    }

    @Override
    public IValue inc() {
        long val = this.longValue();
        val++;

        return new LongValue( Long.valueOf( val ), this._radix );
    }

    @Override
    public IValue dec() {
        long val = this.longValue();
        val--;

        return new LongValue( Long.valueOf( val ), this._radix );
    }

    @Override
    public IValue inv() {
        return new LongValue( Long.valueOf( -this.longValue() ), this._radix );
    }

    @Override
    public IValue sqr() {
        return new DoubleValue( Math.sqrt( this.doubleValue() ) );
    }
    
    @Override
    public IValue eq(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.eq( (ArrayValue) val );
        } else {
            return val.isLong() ? this.eq( (LongValue) val ) : this.eq( (DoubleValue) val );
        }
    }

    public IValue eq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    public IValue eq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() == val.longValue() ) );
    }

    public IValue eq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.gt( (ArrayValue) val );
        } else {
            return val.isLong() ? this.gt( (LongValue) val ) : this.gt( (DoubleValue) val );
        }
    }

    public IValue gt(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    public IValue gt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() > val.longValue() ) );
    }

    public IValue gt(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    //...
    @Override
    public IValue lt(IValue val) throws Exception {
        return val.isLong() ? this.lt( (LongValue) val ) : this.lt( (DoubleValue) val );
    }

    public IValue lt(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    public IValue lt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() < val.longValue() ) );
    }

    public IValue lt(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        return val.isLong() ? this.noteq( (LongValue) val ) : this.noteq( (DoubleValue) val );
    }

    public IValue noteq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    public IValue noteq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() != val.longValue() ) );
    }

    public IValue noteq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        return val.isLong() ? this.gtoreq( (LongValue) val ) : this.gtoreq( (DoubleValue) val );
    }

    public IValue gtoreq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    public IValue gtoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() >= val.longValue() ) );
    }

    public IValue gtoreq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        return val.isLong() ? this.ltoreq( (LongValue) val ) : this.ltoreq( (DoubleValue) val );
    }

    public IValue ltoreq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    public IValue ltoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() <= val.longValue() ) );
    }

    public IValue ltoreq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue and(IValue val) throws Exception {
        return new BooleanValue(this.booleanValue() && val.booleanValue());
    }

    public IValue or(IValue val) throws Exception {
        return new BooleanValue(this.booleanValue() || val.booleanValue());
    }

    @Override
    public IValue not() throws Exception {
        return new BooleanValue( !this.booleanValue() );
    }

    @Override
    public String toString() {
        return Long.toString(_val, _radix);
    }
}
