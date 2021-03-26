package smpl.sys.expressions;

public class InvertExpression implements IExpression {
    
    IExpression _exp;
    
    public InvertExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public Object evaluate() {
        Object obj = _exp.evaluate();
        
        Object r;
        if (obj instanceof Long) {
            long lv = Long.valueOf(obj.toString());
            r = Long.valueOf(-lv);
        } else {
            double dv = Double.valueOf(obj.toString());
            r = Double.valueOf(-dv);
        }

        return r;
    }    
}
