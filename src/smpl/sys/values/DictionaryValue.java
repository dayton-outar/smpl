package smpl.sys.values;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import smpl.sys.expressions.IExpression;

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
        return null;
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        return null;
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

        // Adapted from https://www.javacodeexamples.com/iterate-through-java-hashtable-example/3149
        //get the entry set using the entrySet method
        Set<Map.Entry<String, IExpression>> entries = _dictionary.entrySet();
 
        //get an iterator
        Iterator<Map.Entry<String, IExpression>> itr = entries.iterator();
 
        //iterate using the iterator
        Map.Entry<String, IExpression> entry = null;
        while( itr.hasNext() ){
            entry = itr.next();
            stringValue.add( String.format( "\"%1$s\" => %2$s", entry.getKey(), entry.getValue().evaluate(_heap).toString() ) );
        }

        return stringValue;
    }
}
