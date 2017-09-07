package com.softwaremethodology.assignment;

public class countLine implements LineOperationsStrategy {

	int wcount=0;
	int ccount=0;
	int lcount=0;

	@Override
	public  void execute(String line) {
		    lcount++;
			char[] array = line.toCharArray();
	        for (char ch : array) {
	        	ccount++;
	        	if((ch==' ')||(ch=='.')||(ch=='_')) {
	        		wcount++;
	        	}
	        }
     }

	@Override
	public void fclose() {
		System.out.println("number of lines: "+ lcount);
		System.out.println("number of Words: "+ wcount);
		System.out.println("number of characters: "+ ccount);
		
	}
	

}
