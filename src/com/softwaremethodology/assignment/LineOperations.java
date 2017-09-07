package com.softwaremethodology.assignment;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineOperations {
	private LineOperationsStrategy strategy;

	public LineOperations(LineOperationsStrategy strategy) {
		super();
		this.strategy = strategy;
		}
	public void changeStrategy(LineOperationsStrategy strategy) {
		    this.strategy = strategy;
		    }
	public void performOperation(String filename) {
		try
        {
          BufferedReader reader = new BufferedReader(new FileReader(filename));
          String line;
         while ((line = reader.readLine()) != null)
          {
        	 strategy.execute(line);
	  			}
          reader.close();
          strategy.fclose();
          return;
        }
        catch (Exception e)
        {
          System.err.format("Exception occurred trying to read '%s'.", filename);
          e.printStackTrace();
          return;
        }
		    
	}

}
