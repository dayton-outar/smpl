import smpl.lang.*;
import smpl.sys.Program;
import smpl.sys.values.IValue;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

import java_cup.runtime.*;

public class App {
    public static void main(String[] args) throws Exception {
		System.out.println("\u001B[1mWelcome to SMPL!\u001B[0m");

		try {
			InputStream in;

			if (args.length > 0) {				
				for (int i = 0; i < args.length; i++) {
					System.out.println();
					System.out.println( String.format("Reading %s ...", args[i]) );
					System.out.println();
					in = new FileInputStream( args[i] );
					parseSmpl(in);
				}
			} else {
				System.out.println("Please type your arithmethic expression:");
				String shellContent = System.console().readLine("\u001B[32m#smpl!\u001B[0m ");
				in = new ByteArrayInputStream(shellContent.getBytes(StandardCharsets.UTF_8));
				parseSmpl(in);
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("\u001B[31mFile not found error: \u001B[0m" +
				fnfe.getMessage());
		} catch (Exception e) {
			System.out.println( String.format("\u001B[31m$s\u001B[0m", e.getMessage()) );
			System.out.println("\u001B[31mLoaded program failed to compile\u001B[0m");
		}
    }

	public static void parseSmpl(InputStream in) throws Exception {
		SMPLLexer lexer = new SMPLLexer( new InputStreamReader(in) );
		SMPLParser p = new SMPLParser(lexer);
		
		Symbol parseResult = p.parse();
		
		Program program = (Program)parseResult.value;
		program.execute( new Hashtable<String, IValue>() );
	}
}
