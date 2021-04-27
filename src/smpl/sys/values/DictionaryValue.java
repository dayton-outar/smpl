package smpl.sys.values;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

import smpl.sys.expressions.AdditionExpression;
import smpl.sys.expressions.IExpression;
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
        return null;
    }

    @Override
    public IValue div(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        return null;
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
        return null;
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue and(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue or(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue not() throws Exception {
        return null;
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
