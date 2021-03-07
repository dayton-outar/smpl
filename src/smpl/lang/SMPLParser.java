
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package smpl.lang;

import java_cup.runtime.*;
import java.io.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class SMPLParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public SMPLParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public SMPLParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SMPLParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\005\000\002\002\004\000\002\002" +
    "\004\000\002\002\005\000\002\005\005\000\002\005\005" +
    "\000\002\005\005\000\002\005\005\000\002\005\005\000" +
    "\002\005\004\000\002\005\005\000\002\005\003\000\002" +
    "\003\005\000\002\003\005\000\002\003\005\000\002\003" +
    "\004\000\002\004\005\000\002\004\005\000\002\004\005" +
    "\000\002\004\005\000\002\004\005\000\002\004\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\012\005\011\010\005\012\007\031\006\001" +
    "\002\000\010\005\016\010\005\012\007\001\002\000\044" +
    "\004\ufff6\005\ufff6\006\ufff6\010\ufff6\011\ufff6\012\ufff6\013" +
    "\ufff6\014\ufff6\015\ufff6\021\ufff6\022\ufff6\023\ufff6\024\ufff6" +
    "\025\ufff6\026\ufff6\027\ufff6\030\ufff6\001\002\000\010\005" +
    "\016\010\005\012\007\001\002\000\010\005\016\010\005" +
    "\012\007\001\002\000\012\002\057\005\016\010\005\012" +
    "\007\001\002\000\010\005\016\010\005\012\007\001\002" +
    "\000\032\004\052\011\027\012\021\013\031\014\022\015" +
    "\024\021\026\022\030\023\033\024\032\025\023\026\025" +
    "\001\002\000\006\027\014\030\015\001\002\000\010\005" +
    "\016\010\005\012\007\001\002\000\010\005\016\010\005" +
    "\012\007\001\002\000\010\005\016\010\005\012\007\001" +
    "\002\000\030\011\027\012\021\013\031\014\022\015\024" +
    "\021\026\022\030\023\033\024\032\025\023\026\025\001" +
    "\002\000\010\005\ufff4\010\ufff4\012\ufff4\001\002\000\010" +
    "\005\016\010\005\012\007\001\002\000\010\005\016\010" +
    "\005\012\007\001\002\000\010\005\016\010\005\012\007" +
    "\001\002\000\010\005\016\010\005\012\007\001\002\000" +
    "\010\005\016\010\005\012\007\001\002\000\010\005\016" +
    "\010\005\012\007\001\002\000\010\005\016\010\005\012" +
    "\007\001\002\000\010\005\016\010\005\012\007\001\002" +
    "\000\010\005\016\010\005\012\007\001\002\000\010\005" +
    "\016\010\005\012\007\001\002\000\010\005\016\010\005" +
    "\012\007\001\002\000\030\004\ufff0\005\ufff0\006\ufff0\010" +
    "\ufff0\011\027\012\021\013\031\014\022\015\024\027\ufff0" +
    "\030\ufff0\001\002\000\030\004\uffee\005\uffee\006\uffee\010" +
    "\uffee\011\027\012\021\013\031\014\022\015\024\027\uffee" +
    "\030\uffee\001\002\000\044\004\ufffb\005\ufffb\006\ufffb\010" +
    "\ufffb\011\ufffb\012\ufffb\013\ufffb\014\ufffb\015\ufffb\021\ufffb" +
    "\022\ufffb\023\ufffb\024\ufffb\025\ufffb\026\ufffb\027\ufffb\030" +
    "\ufffb\001\002\000\030\004\ufff1\005\ufff1\006\ufff1\010\ufff1" +
    "\011\027\012\021\013\031\014\022\015\024\027\ufff1\030" +
    "\ufff1\001\002\000\044\004\ufffd\005\ufffd\006\ufffd\010\ufffd" +
    "\011\ufffd\012\ufffd\013\031\014\022\015\024\021\ufffd\022" +
    "\ufffd\023\ufffd\024\ufffd\025\ufffd\026\ufffd\027\ufffd\030\ufffd" +
    "\001\002\000\030\004\uffef\005\uffef\006\uffef\010\uffef\011" +
    "\027\012\021\013\031\014\022\015\024\027\uffef\030\uffef" +
    "\001\002\000\030\004\uffec\005\uffec\006\uffec\010\uffec\011" +
    "\027\012\021\013\031\014\022\015\024\027\uffec\030\uffec" +
    "\001\002\000\044\004\ufff9\005\ufff9\006\ufff9\010\ufff9\011" +
    "\ufff9\012\ufff9\013\ufff9\014\ufff9\015\ufff9\021\ufff9\022\ufff9" +
    "\023\ufff9\024\ufff9\025\ufff9\026\ufff9\027\ufff9\030\ufff9\001" +
    "\002\000\030\004\uffed\005\uffed\006\uffed\010\uffed\011\027" +
    "\012\021\013\031\014\022\015\024\027\uffed\030\uffed\001" +
    "\002\000\044\004\ufffa\005\ufffa\006\ufffa\010\ufffa\011\ufffa" +
    "\012\ufffa\013\ufffa\014\ufffa\015\ufffa\021\ufffa\022\ufffa\023" +
    "\ufffa\024\ufffa\025\ufffa\026\ufffa\027\ufffa\030\ufffa\001\002" +
    "\000\044\004\ufffc\005\ufffc\006\ufffc\010\ufffc\011\ufffc\012" +
    "\ufffc\013\031\014\022\015\024\021\ufffc\022\ufffc\023\ufffc" +
    "\024\ufffc\025\ufffc\026\ufffc\027\ufffc\030\ufffc\001\002\000" +
    "\016\006\050\011\027\012\021\013\031\014\022\015\024" +
    "\001\002\000\044\004\ufff7\005\ufff7\006\ufff7\010\ufff7\011" +
    "\ufff7\012\ufff7\013\ufff7\014\ufff7\015\ufff7\021\ufff7\022\ufff7" +
    "\023\ufff7\024\ufff7\025\ufff7\026\ufff7\027\ufff7\030\ufff7\001" +
    "\002\000\010\005\ufff5\010\ufff5\012\ufff5\001\002\000\012" +
    "\002\uffff\005\uffff\010\uffff\012\uffff\001\002\000\032\006" +
    "\050\011\027\012\021\013\031\014\022\015\024\021\026" +
    "\022\030\023\033\024\032\025\023\026\025\001\002\000" +
    "\004\006\055\001\002\000\010\005\ufff3\010\ufff3\012\ufff3" +
    "\001\002\000\016\004\060\011\027\012\021\013\031\014" +
    "\022\015\024\001\002\000\004\002\000\001\002\000\012" +
    "\002\001\005\001\010\001\012\001\001\002\000\044\004" +
    "\ufff8\005\ufff8\006\ufff8\010\ufff8\011\ufff8\012\ufff8\013\031" +
    "\014\022\015\024\021\ufff8\022\ufff8\023\ufff8\024\ufff8\025" +
    "\ufff8\026\ufff8\027\ufff8\030\ufff8\001\002\000\010\005\ufff2" +
    "\010\ufff2\012\ufff2\001\002\000\004\004\064\001\002\000" +
    "\012\002\ufffe\005\ufffe\010\ufffe\012\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\012\002\007\003\003\004\012\005\011\001" +
    "\001\000\006\004\062\005\016\001\001\000\002\001\001" +
    "\000\006\004\061\005\016\001\001\000\004\005\060\001" +
    "\001\000\004\005\055\001\001\000\006\004\053\005\052" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\004" +
    "\050\005\016\001\001\000\006\004\017\005\016\001\001" +
    "\000\004\005\046\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\005\045\001\001\000\004\005\044\001\001" +
    "\000\004\005\043\001\001\000\004\005\042\001\001\000" +
    "\004\005\041\001\001\000\004\005\040\001\001\000\004" +
    "\005\037\001\001\000\004\005\036\001\001\000\004\005" +
    "\035\001\001\000\004\005\034\001\001\000\004\005\033" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SMPLParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SMPLParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SMPLParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

    // Create a lexer that reads from specified input stream
    if (in == null) {
		in = System.in;
		lexer = new SMPLLexer( new InputStreamReader(in) );
	}
	setScanner( lexer );

    }


	SMPLLexer lexer;
	InputStream in = null;

	public SMPLParser(String file) throws FileNotFoundException {
	    in = new FileInputStream(file);
		lexer = new SMPLLexer(new InputStreamReader(in));
	}

	public void report_error(String message, Object info) {
	    System.err.println(message + info);
	}

	public void syntax_error(Symbol cur_token) {
		System.err.print("Line " + lexer.getLine() +
				         " near char " + lexer.getChar() + ": ");
		report_error("Syntax error while reading: ", cur_token);
		System.err.println ("Last token read is " +
					        lexer.getText());
	}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$SMPLParser$actions {
  private final SMPLParser parser;

  /** Constructor */
  CUP$SMPLParser$actions(SMPLParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SMPLParser$do_action_part00000000(
    int                        CUP$SMPLParser$act_num,
    java_cup.runtime.lr_parser CUP$SMPLParser$parser,
    java.util.Stack            CUP$SMPLParser$stack,
    int                        CUP$SMPLParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SMPLParser$result;

      /* select the action based on the action number */
      switch (CUP$SMPLParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // expr_list ::= expr_list expr SEMI 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		 System.out.println(e);
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= expr_list EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		RESULT = start_val;
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SMPLParser$parser.done_parsing();
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr_list ::= expr SEMI 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		 System.out.println(e);
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr_list ::= condition_list condition SEMI 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Boolean c = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		 System.out.println(c);
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expr ::= expr PLUS expr 
            {
              Integer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = e1 + e2;       	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // expr ::= expr MINUS expr 
            {
              Integer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = e1 - e2;       	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expr ::= expr TIMES expr 
            {
              Integer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = e1 * e2;       	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expr ::= expr DIVIDE expr 
            {
              Integer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = e1 / e2;       	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expr ::= expr MOD expr 
            {
              Integer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = e1 % e2;       	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expr ::= MINUS expr 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = -e;				
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expr ::= LPAREN expr RPAREN 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		 RESULT = e;           	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expr ::= INTEGER_LITERAL 
            {
              Integer RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = n;           	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expr",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // condition_list ::= condition AND condition 
            {
              Object RESULT =null;
		int c1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int c1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Boolean c1 = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int c2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int c2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean c2 = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (c1 && c2);	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition_list",1, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // condition_list ::= condition OR condition 
            {
              Object RESULT =null;
		int c1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int c1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Boolean c1 = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int c2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int c2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean c2 = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (c1 || c2);	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition_list",1, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // condition_list ::= LPAREN condition RPAREN 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Boolean c = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		 RESULT = c;			
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition_list",1, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // condition_list ::= NOT condition 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean c = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (!c);		
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition_list",1, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // condition ::= expr GT expr 
            {
              Boolean RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (e1 > e2); 		
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // condition ::= expr LT expr 
            {
              Boolean RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (e1 < e2); 		
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // condition ::= expr EQ expr 
            {
              Boolean RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (e1 == e2); 	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // condition ::= expr LTEQ expr 
            {
              Boolean RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (e1 <= e2); 	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // condition ::= expr GTEQ expr 
            {
              Boolean RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (e1 >= e2); 	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // condition ::= expr NOTEQ expr 
            {
              Boolean RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = (e1 != e2); 	
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("condition",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SMPLParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SMPLParser$do_action(
    int                        CUP$SMPLParser$act_num,
    java_cup.runtime.lr_parser CUP$SMPLParser$parser,
    java.util.Stack            CUP$SMPLParser$stack,
    int                        CUP$SMPLParser$top)
    throws java.lang.Exception
    {
              return CUP$SMPLParser$do_action_part00000000(
                               CUP$SMPLParser$act_num,
                               CUP$SMPLParser$parser,
                               CUP$SMPLParser$stack,
                               CUP$SMPLParser$top);
    }
}

}
