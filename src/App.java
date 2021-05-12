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
			Hashtable<String, IValue> heap = new Hashtable<String, IValue>();

			if (args.length > 0) {

				for (int i = 0; i < args.length; i++) {
					System.out.println();
					System.out.println( String.format("\u001B[32mReading %s ...\u001B[0m", args[i]) );
					System.out.println();
					//---
					File file = new File( args[i] );
					if ( file.isFile() ) {
						in = new FileInputStream( args[i] );
						try {
							parseSmpl(in, heap);
						} catch (Exception e) {
							System.out.println( String.format("\u001B[31m%s\u001B[0m", e.getMessage()) );
							System.out.println("\u001B[31mLoaded program failed to compile\u001B[0m");
						}
					} else if ( file.isDirectory() ) {
						for (File smplFile : file.listFiles( (f, s) -> s.endsWith(".smpl") )) {
							System.out.println();
							System.out.println( String.format("\u001B[32mReading %s ...\u001B[0m", smplFile.getName()) );
							System.out.println();

							in = new FileInputStream( smplFile.getPath() );
							try {
								parseSmpl(in, heap);
							} catch (Exception e) {
								System.out.println( String.format("\u001B[31m%s\u001B[0m", e.getMessage()) );
								System.out.println("\u001B[31mLoaded program failed to compile\u001B[0m");
							}
						}
					} else {
						System.out.println( String.format("Argument, %s, is not valid", args[i]) );
					}
				}

			} else {
				System.out.println("Please type your arithmethic expression:");
				String shellContent = "";

				while( (shellContent.equals("quit") || shellContent.equals("exit")) == false ) {
					System.out.println();
					shellContent = System.console().readLine("\u001B[32m\u001B[1m#smpl!\u001B[0m ");
					in = new ByteArrayInputStream(shellContent.getBytes(StandardCharsets.UTF_8));
					if ((shellContent.equals("quit") || shellContent.equals("exit")) == false) {
						try {
							parseSmpl(in, heap);
						} catch (Exception e) {
							System.out.println( String.format("\u001B[31m%s\u001B[0m", e.getMessage()) );
							System.out.println("\u001B[31mLoaded program failed to compile\u001B[0m");
						}
					}
				}
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("\u001B[31mFile not found error: \u001B[0m" +
				fnfe.getMessage());
		}
    }

	public static void parseSmpl(InputStream in, Hashtable<String, IValue> heap) throws Exception {
		SMPLLexer lexer = new SMPLLexer( new InputStreamReader(in) );
		SMPLParser p = new SMPLParser(lexer);
		
		Symbol parseResult = p.parse();
		
		Program program = (Program)parseResult.value;
		program.execute( heap );
	}
}
