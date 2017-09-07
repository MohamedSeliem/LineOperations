package com.softwaremethodology.assignment;

public class printLine implements LineOperationsStrategy{
	private String search_word;
	
	public printLine(String word) {
		super();
		// TODO Auto-generated constructor stub
		search_word = word;
	}
	@Override
	public void execute(String line) {
		    String[] words = line.split(" ");
	        for (String wo : words) {
	        	if (wo.equalsIgnoreCase(search_word)) {
	        		System.out.println(line);
	        		break;
	        	}

	        }
     }
	@Override
	public void fclose() {
		// TODO Auto-generated method stub
		
	}

}
