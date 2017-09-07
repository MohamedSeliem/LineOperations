package com.softwaremethodology.assignment;

import java.util.Enumeration;
import java.util.Hashtable;

public class wordFreq implements LineOperationsStrategy {
	Hashtable<String, Integer> table= new Hashtable<String, Integer>();

	
	public wordFreq() {
		super();
		// TODO Auto-generated constructor stub
	}
@Override
	public void execute(String line) {
			String[] words = line.split(" ");
	        for (String wo : words) {
	        	Integer test=table.get(wo.toLowerCase());
	        	if(test==null)
	        	{
	        		table.put(wo.toLowerCase(), 1);
	        	}
	        	else
	        	{
	        		table.put(wo.toLowerCase(), test+1);
	        	}
	        }

     }
@Override
public void fclose() {
    Enumeration<String> names;
    String key;

    names = table.keys();
    while(names.hasMoreElements()) {
       key = (String) names.nextElement();
       System.out.println("Word: " +key+ " & Frequency: " +
       table.get(key));
       }
	
}
}
