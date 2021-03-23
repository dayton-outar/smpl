import smpl.lang.*;
import smpl.sys.Program;

import java.io.*;
import java_cup.runtime.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Please type your arithmethic expression:");
        SMPLParser p;

        if (args.length > 0) {
			System.out.println("Reading:");
			for (int i = 0; i < args.length; i++) {
				System.out.println("  " + args[i] + "...");
				try {
					p = new SMPLParser(args[i]);
                    Symbol parseResult = p.parse();
					
					Program program = (Program)parseResult.value;
					program.execute();

				} catch (FileNotFoundException fnfe) {
					System.out.println("File not found error: " +
						fnfe.getMessage());
				}
			}
		}
        
    }
}
