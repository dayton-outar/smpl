package smpl.sys.values;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

import smpl.sys.expressions.AdditionExpression;
import smpl.sys.expressions.BitwiseAndExpression;
import smpl.sys.expressions.BitwiseInvertExpression;
import smpl.sys.expressions.BitwiseOrExpression;
import smpl.sys.expressions.BitwiseXorExpression;
import smpl.sys.expressions.DivisionExpression;
import smpl.sys.expressions.EqualsExpression;
import smpl.sys.expressions.ExponentExpression;
import smpl.sys.expressions.GreaterThanExpression;
import smpl.sys.expressions.GreaterThanOrEqualsExpression;
import smpl.sys.expressions.IExpression;
import smpl.sys.expressions.InvertExpression;
import smpl.sys.expressions.LesserThanExpression;
import smpl.sys.expressions.LesserThanOrEqualsExpression;
import smpl.sys.expressions.LogicalAndExpression;
import smpl.sys.expressions.LogicalNotExpression;
import smpl.sys.expressions.LogicalOrExpression;
import smpl.sys.expressions.ModulusExpression;
import smpl.sys.expressions.MultiplicationExpression;
import smpl.sys.expressions.NotEqualsExpression;
import smpl.sys.expressions.SquareRootExpression;
import smpl.sys.expressions.SubtractionExpression;

public class DictionaryValue implements IValue {

    Hashtable<String, IExpression> _dictionary;
    Hashtable<String, IValue> _heap;

    public DictionaryValue(Hashtable<String, IExpression> dictionary, Hashtable<String, IValue> heap) {
        _dictionary = dictionary;
        _heap = heap;
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
        return null;
    }

    @Override
    public Hashtable<String, IExpression> getDictionary() {
        return _dictionary;
    }

    @Override
    public IValue add(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.add( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.add( (DictionaryValue) this) : val.add( (DictionaryValue) this );
        }
    }

    public IValue add(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new AdditionExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.sub( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.sub( (DictionaryValue) this) : val.sub( (DictionaryValue) this );
        }
    }

    public IValue sub(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new SubtractionExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.mul( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.mul( (DictionaryValue) this) : val.mul( (DictionaryValue) this );
        }
    }

    public IValue mul(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new MultiplicationExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue div(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.div( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.div( (DictionaryValue) this) : val.div( (DictionaryValue) this );
        }
    }

    public IValue div(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new DivisionExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.mod( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.mod( (DictionaryValue) this) : val.mod( (DictionaryValue) this );
        }
    }

    public IValue mod(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new ModulusExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.pow( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.pow( (DictionaryValue) this) : val.pow( (DictionaryValue) this );
        }
    }

    public IValue pow(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new ExponentExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.ban( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.ban( (DictionaryValue) this) : val.ban( (DictionaryValue) this );
        }
    }

    public IValue ban(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new BitwiseAndExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.bor( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.bor( (DictionaryValue) this) : val.bor( (DictionaryValue) this );
        }
    }

    public IValue bor(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new BitwiseOrExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.bxr( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.bxr( (DictionaryValue) this) : val.bxr( (DictionaryValue) this );
        }
    }

    public IValue bxr(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new BitwiseXorExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue biv() {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.put( k, new BitwiseInvertExpression( v ) ) );
        
        return new DictionaryValue( dvs, _heap );
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
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.put( k, new InvertExpression( v ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue sqr() {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.put( k, new SquareRootExpression( v ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue eq(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.eq( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.eq( (DictionaryValue) this) : val.eq( (DictionaryValue) this );
        }
    }

    public IValue eq(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new EqualsExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.gt( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.gt( (DictionaryValue) this) : val.gt( (DictionaryValue) this );
        }
    }

    public IValue gt(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new GreaterThanExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.lt( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.lt( (DictionaryValue) this) : val.lt( (DictionaryValue) this );
        }
    }

    public IValue lt(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new LesserThanExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.noteq( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.noteq( (DictionaryValue) this) : val.noteq( (DictionaryValue) this );
        }
    }

    public IValue noteq(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new NotEqualsExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.gtoreq( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.gtoreq( (DictionaryValue) this) : val.gtoreq( (DictionaryValue) this );
        }
    }

    public IValue gtoreq(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new GreaterThanOrEqualsExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        if (val.isDictionary()) {
            return this.ltoreq( (DictionaryValue) val );
        } else {
            return val.isLong() ? val.ltoreq( (DictionaryValue) this) : val.ltoreq( (DictionaryValue) this );
        }
    }

    public IValue ltoreq(DictionaryValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new LesserThanOrEqualsExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue and(IValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new LogicalAndExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue or(IValue val) throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();
        dvs.putAll( val.getDictionary() );

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.merge( k, v, (v1, v2) -> new LogicalOrExpression( v2, v1 ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }

    @Override
    public IValue not() throws Exception {
        Hashtable<String, IExpression> dvs = new Hashtable<String, IExpression>();

        // Adapted from https://www.programiz.com/java-programming/library/hashmap/merge
        _dictionary.forEach( (k, v) -> dvs.put( k, new LogicalNotExpression( v ) ) );
        
        return new DictionaryValue( dvs, _heap );
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Vector<String> stringValues = new Vector<String>();

        try {
            stringValues = valueStrings();
        } catch (Exception e) {}

        sb.append("[ ");
        sb.append( String.join(", ", stringValues.toArray(new String[stringValues.size()]) ) );
        sb.append(" ]");
        return sb.toString();
    }

    private Vector<String> valueStrings() throws Exception {
        Vector<String> stringValue = new Vector<String>();

        TreeMap<String, IExpression> sorted = new TreeMap<String, IExpression>( _dictionary );

        // Adapted from https://www.javacodeexamples.com/iterate-through-java-hashtable-example/3149
        // Get the entry set using the entrySet method
        Set<Entry<String, IExpression>> entries = sorted.entrySet();
 
        // Get an iterator
        Iterator<Entry<String, IExpression>> itr = entries.iterator();
 
        while( itr.hasNext() ){
            Entry<String, IExpression> entry = itr.next();
            stringValue.add( String.format( "\"%1$s\" => %2$s", entry.getKey(), entry.getValue().evaluate(_heap).toString() ) );
        }

        return stringValue;
    }
}
