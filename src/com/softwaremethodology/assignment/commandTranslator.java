package com.softwaremethodology.assignment;

public class commandTranslator {
	  /**
	    * The main() routine simply gets the arguments from the
	    * command line and calls the suitable routine to process
	    * user request.  Since any errors are handled in the commandTranslator()
	    * routine, the main program will continue after an error occurs
	    * while trying to process one of the files.
	    */  
	   static LineOperations lineOperations=new LineOperations(new countLine());
	   public static void main(String[] args) {
		  
	      if (args.length == 0) {
	             // This program must have at least one command-line 
	             // argument to work with.
	          System.out.println("% run_program  <function-name> <file-name.txt>");
	          return;
	      }
	      String filename=args[args.length-1];
	      String op=args[2];
			switch(op) {
			case "wc":
				lineOperations.performOperation(filename);
				break;
			case "grep":
				lineOperations.changeStrategy(new printLine(args[3]));
				lineOperations.performOperation(filename);
				break;
			case "freq":
				lineOperations.changeStrategy(new wordFreq());
				lineOperations.performOperation(filename);
				break;
			default:
				System.out.println("function is not supported");
				break;  			
				}
    
	   }  // end main()
}
