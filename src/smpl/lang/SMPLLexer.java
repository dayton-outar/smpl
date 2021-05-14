/* The following code was generated by JFlex 1.7.0 */

package smpl.lang;

import java_cup.runtime.*;

/**
 * This class is a simple example lexer.
 */

public class SMPLLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int INJEXP = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\54\1\46"+
    "\1\0\1\70\1\34\1\37\1\0\1\60\1\61\1\5\1\35\1\64"+
    "\1\36\1\7\1\4\1\11\1\13\6\17\2\6\1\43\1\32\1\45"+
    "\1\33\1\44\1\42\1\0\6\15\24\10\1\62\1\71\1\63\1\41"+
    "\1\10\1\0\1\25\1\12\2\15\1\23\1\24\5\10\1\26\1\10"+
    "\1\72\1\16\2\10\1\21\1\27\1\20\1\22\2\10\1\14\2\10"+
    "\1\31\1\40\1\30\1\52\130\0\1\47\37\0\1\50\u02c8\0\1\65"+
    "\u1d46\0\1\66\312\0\1\53\76\0\1\67\10\0\1\51\105\0\1\57"+
    "\3\0\1\56\1\55\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uddaa\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\2\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\5\2\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\4\1\3\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\1\1\47\1\3\1\4"+
    "\1\50\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\24\1\2\1\0\1\51\1\52\1\53\1\0"+
    "\1\54\1\6\3\0\2\6\1\55\1\56\1\57\1\60"+
    "\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70"+
    "\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100"+
    "\2\0\1\101\1\102\1\103\2\6\1\0\1\2\1\104"+
    "\1\6\1\105";

  private static int [] zzUnpackAction() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\73\0\166\0\261\0\354\0\261\0\u0127\0\u0162"+
    "\0\u019d\0\u01d8\0\u0213\0\u024e\0\u0289\0\u02c4\0\261\0\261"+
    "\0\261\0\u02ff\0\u033a\0\u0375\0\u03b0\0\u03eb\0\u0426\0\u0461"+
    "\0\u049c\0\u04d7\0\u0512\0\u054d\0\261\0\261\0\261\0\261"+
    "\0\261\0\261\0\u0588\0\261\0\261\0\261\0\261\0\261"+
    "\0\261\0\261\0\261\0\261\0\261\0\261\0\u05c3\0\261"+
    "\0\u05fe\0\u0639\0\u0674\0\u06af\0\261\0\261\0\261\0\u06ea"+
    "\0\u0725\0\u0760\0\261\0\261\0\261\0\u079b\0\u07d6\0\u0811"+
    "\0\261\0\261\0\261\0\u01d8\0\u01d8\0\u084c\0\u0887\0\u08c2"+
    "\0\u08fd\0\u0938\0\u0973\0\261\0\261\0\261\0\261\0\261"+
    "\0\261\0\261\0\261\0\261\0\261\0\261\0\261\0\261"+
    "\0\261\0\261\0\261\0\261\0\261\0\261\0\261\0\u09ae"+
    "\0\u09e9\0\u0887\0\u08c2\0\u08fd\0\u0a24\0\u0a5f\0\u0a9a\0\u09ae"+
    "\0\u0213\0\u0ad5\0\u0213";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\2\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\13\1\11\3\13\1\11\1\15\3\13\1\16"+
    "\3\13\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
    "\1\56\2\4\1\13\1\57\2\4\26\57\1\4\14\57"+
    "\1\60\21\57\1\61\1\62\1\57\1\4\1\5\2\6"+
    "\1\63\1\64\1\11\1\12\1\13\1\14\1\13\1\11"+
    "\3\13\1\11\10\13\1\65\2\4\1\22\1\66\1\67"+
    "\1\70\1\71\1\72\1\73\1\74\1\75\1\33\1\76"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\2\4\1\13\75\0\1\6\74\0\1\77"+
    "\1\100\25\0\1\101\44\0\1\102\25\0\1\103\45\0"+
    "\1\11\1\104\1\0\1\11\1\0\1\11\3\0\1\11"+
    "\61\0\1\105\2\0\1\105\1\0\1\105\3\0\1\105"+
    "\61\0\1\106\1\0\1\13\1\106\1\13\1\106\3\13"+
    "\1\106\10\13\42\0\1\13\6\0\1\11\1\104\1\0"+
    "\1\11\1\107\1\11\1\110\1\0\1\111\1\11\61\0"+
    "\1\106\1\0\1\13\1\106\1\13\1\106\3\13\1\106"+
    "\1\13\1\112\6\13\42\0\1\13\6\0\1\106\1\0"+
    "\1\13\1\106\1\13\1\106\3\13\1\106\5\13\1\113"+
    "\2\13\42\0\1\13\33\0\1\114\10\0\1\115\61\0"+
    "\1\116\72\0\1\117\1\0\1\120\70\0\1\121\2\0"+
    "\1\122\5\0\1\42\61\0\1\123\3\0\1\124\66\0"+
    "\1\125\4\0\1\126\65\0\1\127\102\0\1\130\73\0"+
    "\1\131\61\0\1\44\72\0\1\45\7\0\1\132\62\0"+
    "\1\46\37\0\1\57\2\0\26\57\1\0\14\57\1\0"+
    "\21\57\2\0\1\57\31\0\1\133\61\0\1\134\1\135"+
    "\24\0\1\136\23\0\1\137\4\0\1\77\1\100\72\0"+
    "\1\102\131\0\1\42\65\0\1\124\73\0\1\126\65\0"+
    "\1\45\37\0\1\77\1\5\1\6\70\77\5\140\1\141"+
    "\65\140\6\0\1\106\2\0\1\106\1\0\1\106\3\0"+
    "\1\106\64\0\1\142\1\0\1\142\65\0\1\143\2\0"+
    "\3\143\1\0\1\143\1\0\1\143\3\0\3\143\56\0"+
    "\1\144\1\0\1\144\3\0\1\144\61\0\1\106\1\0"+
    "\1\13\1\106\1\13\1\106\3\13\1\106\2\13\1\145"+
    "\5\13\42\0\1\13\6\0\1\106\1\0\1\13\1\106"+
    "\1\13\1\106\3\13\1\106\6\13\1\146\1\13\42\0"+
    "\1\13\5\140\1\147\71\140\1\150\1\147\65\140\6\0"+
    "\1\106\1\0\1\13\1\106\1\13\1\106\3\13\1\106"+
    "\3\13\1\151\4\13\42\0\1\13\6\0\1\106\1\0"+
    "\1\13\1\106\1\13\1\106\3\13\1\106\7\13\1\152"+
    "\42\0\1\13\4\140\1\6\1\147\65\140\6\0\1\106"+
    "\1\0\1\13\1\106\1\13\1\106\3\13\1\106\3\13"+
    "\1\153\4\13\42\0\1\13";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2832];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\1\1\1\11\10\1\3\11\13\1\6\11"+
    "\1\1\13\11\1\1\1\11\4\1\3\11\3\1\3\11"+
    "\2\1\1\0\3\11\1\0\2\1\3\0\2\1\24\11"+
    "\2\0\5\1\1\0\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  StringBuffer string = new StringBuffer();

  public int getColumn()
  {
    return yycolumn + 1;
  }

  public int getLine()
  {
	  return yyline + 1;
  }

  public String getText()
  {
	  return yytext();
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public SMPLLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 200) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { 	return new Symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return new Symbol(sym.error, yytext());
            } 
            // fall through
          case 70: break;
          case 2: 
            { /* ignore */
            } 
            // fall through
          case 71: break;
          case 3: 
            { return new Symbol(sym.DIVIDE);
            } 
            // fall through
          case 72: break;
          case 4: 
            { return new Symbol(sym.TIMES);
            } 
            // fall through
          case 73: break;
          case 5: 
            { return new Symbol(sym.LONG, Long.valueOf(yytext()));
            } 
            // fall through
          case 74: break;
          case 6: 
            { return new Symbol(sym.IDENTIFIER, yytext());
            } 
            // fall through
          case 75: break;
          case 7: 
            { return new Symbol(sym.RBRACE);
            } 
            // fall through
          case 76: break;
          case 8: 
            { return new Symbol(sym.LBRACE);
            } 
            // fall through
          case 77: break;
          case 9: 
            { return new Symbol(sym.SEMI);
            } 
            // fall through
          case 78: break;
          case 10: 
            { return new Symbol(sym.ASSIGN);
            } 
            // fall through
          case 79: break;
          case 11: 
            { return new Symbol(sym.MOD);
            } 
            // fall through
          case 80: break;
          case 12: 
            { return new Symbol(sym.PLUS);
            } 
            // fall through
          case 81: break;
          case 13: 
            { return new Symbol(sym.MINUS);
            } 
            // fall through
          case 82: break;
          case 14: 
            { return new Symbol(sym.AMP);
            } 
            // fall through
          case 83: break;
          case 15: 
            { return new Symbol(sym.BAR);
            } 
            // fall through
          case 84: break;
          case 16: 
            { return new Symbol(sym.CARET);
            } 
            // fall through
          case 85: break;
          case 17: 
            { return new Symbol(sym.QUERY);
            } 
            // fall through
          case 86: break;
          case 18: 
            { return new Symbol(sym.COLON);
            } 
            // fall through
          case 87: break;
          case 19: 
            { return new Symbol(sym.GT);
            } 
            // fall through
          case 88: break;
          case 20: 
            { return new Symbol(sym.LT);
            } 
            // fall through
          case 89: break;
          case 21: 
            { string.setLength(0);
                                    yybegin(STRING);
            } 
            // fall through
          case 90: break;
          case 22: 
            { return new Symbol(sym.RADICAL);
            } 
            // fall through
          case 91: break;
          case 23: 
            { return new Symbol(sym.TILDE);
            } 
            // fall through
          case 92: break;
          case 24: 
            { return new Symbol(sym.IMPLY);
            } 
            // fall through
          case 93: break;
          case 25: 
            { return new Symbol(sym.NOT);
            } 
            // fall through
          case 94: break;
          case 26: 
            { return new Symbol(sym.GTEQ);
            } 
            // fall through
          case 95: break;
          case 27: 
            { return new Symbol(sym.LTEQ);
            } 
            // fall through
          case 96: break;
          case 28: 
            { return new Symbol(sym.NOTEQ);
            } 
            // fall through
          case 97: break;
          case 29: 
            { return new Symbol(sym.LPAREN);
            } 
            // fall through
          case 98: break;
          case 30: 
            { return new Symbol(sym.RPAREN);
            } 
            // fall through
          case 99: break;
          case 31: 
            { return new Symbol(sym.LBRAK);
            } 
            // fall through
          case 100: break;
          case 32: 
            { return new Symbol(sym.RBRAK);
            } 
            // fall through
          case 101: break;
          case 33: 
            { return new Symbol(sym.COMMA);
            } 
            // fall through
          case 102: break;
          case 34: 
            { return new Symbol(sym.PI);
            } 
            // fall through
          case 103: break;
          case 35: 
            { return new Symbol(sym.EULER);
            } 
            // fall through
          case 104: break;
          case 36: 
            { return new Symbol(sym.SIGMA);
            } 
            // fall through
          case 105: break;
          case 37: 
            { string.append( yytext() );
            } 
            // fall through
          case 106: break;
          case 38: 
            { yybegin(YYINITIAL);
                                    return new Symbol(sym.STRING, string.toString());
            } 
            // fall through
          case 107: break;
          case 39: 
            { string.append('\\');
            } 
            // fall through
          case 108: break;
          case 40: 
            { string.delete(0, string.length());
                                    yybegin(STRING);
            } 
            // fall through
          case 109: break;
          case 41: 
            { return new Symbol(sym.ASSIGNDIVIDE);
            } 
            // fall through
          case 110: break;
          case 42: 
            { return new Symbol(sym.EXPONENT);
            } 
            // fall through
          case 111: break;
          case 43: 
            { return new Symbol(sym.ASSIGNTIMES);
            } 
            // fall through
          case 112: break;
          case 44: 
            { return new Symbol(sym.DOUBLE, Double.valueOf(yytext()));
            } 
            // fall through
          case 113: break;
          case 45: 
            { return new Symbol(sym.EQ);
            } 
            // fall through
          case 114: break;
          case 46: 
            { return new Symbol(sym.MAP);
            } 
            // fall through
          case 115: break;
          case 47: 
            { return new Symbol(sym.ASSIGNMOD);
            } 
            // fall through
          case 116: break;
          case 48: 
            { return new Symbol(sym.ASSIGNADD);
            } 
            // fall through
          case 117: break;
          case 49: 
            { return new Symbol(sym.INCREMENT);
            } 
            // fall through
          case 118: break;
          case 50: 
            { return new Symbol(sym.ASSIGNSUB);
            } 
            // fall through
          case 119: break;
          case 51: 
            { return new Symbol(sym.DECREMENT);
            } 
            // fall through
          case 120: break;
          case 52: 
            { return new Symbol(sym.ASSIGNAMP);
            } 
            // fall through
          case 121: break;
          case 53: 
            { return new Symbol(sym.AND);
            } 
            // fall through
          case 122: break;
          case 54: 
            { return new Symbol(sym.ASSIGNBAR);
            } 
            // fall through
          case 123: break;
          case 55: 
            { return new Symbol(sym.OR);
            } 
            // fall through
          case 124: break;
          case 56: 
            { return new Symbol(sym.ASSIGNCARET);
            } 
            // fall through
          case 125: break;
          case 57: 
            { return new Symbol(sym.CASES);
            } 
            // fall through
          case 126: break;
          case 58: 
            { return new Symbol(sym.PRINT);
            } 
            // fall through
          case 127: break;
          case 59: 
            { return new Symbol(sym.READ);
            } 
            // fall through
          case 128: break;
          case 60: 
            { yybegin(INJEXP);
                                    return new Symbol(sym.STRING, string.toString());
            } 
            // fall through
          case 129: break;
          case 61: 
            { string.append('\t');
            } 
            // fall through
          case 130: break;
          case 62: 
            { string.append('\r');
            } 
            // fall through
          case 131: break;
          case 63: 
            { string.append('\"');
            } 
            // fall through
          case 132: break;
          case 64: 
            { string.append('\n');
            } 
            // fall through
          case 133: break;
          case 65: 
            { return new Symbol(sym.BINARY, yytext().substring(2));
            } 
            // fall through
          case 134: break;
          case 66: 
            { return new Symbol(sym.HEX, yytext().substring(2));
            } 
            // fall through
          case 135: break;
          case 67: 
            { return new Symbol(sym.OCTAL, yytext().substring(2));
            } 
            // fall through
          case 136: break;
          case 68: 
            { return new Symbol(sym.TRUE);
            } 
            // fall through
          case 137: break;
          case 69: 
            { return new Symbol(sym.FALSE);
            } 
            // fall through
          case 138: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
