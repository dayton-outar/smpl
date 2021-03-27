package smpl.sys.expressions;

public class DictionaryIndexExpression implements IExpression {
    
    String _var;
    String _ix;

    public DictionaryIndexExpression(String var, String ix) {
        _var = var;
        _ix = ix;
    }

    @Override
    public Object evaluate() {
        // TODO: Auto-generated method stub
        
        return 7;
    }
}
