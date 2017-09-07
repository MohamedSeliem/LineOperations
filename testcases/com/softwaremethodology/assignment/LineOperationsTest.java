package com.softwaremethodology.assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LineOperationsTest {
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));	}
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	@Test
	public void testPerformOperation() {
		LineOperationsStrategy strategy=mock(LineOperationsStrategy.class);
	    LineOperations lineOperations = new LineOperations(strategy);
	    lineOperations.performOperation("testcases\\\\file.txt");	    
	    verify(strategy).execute("In the above 'run_program' represents the command given to run your Java program.");
	    verify(strategy).fclose();
	    assertEquals("", outContent.toString());
	}
	/**
	   * Verify if the Line operations uses the new strategy after a change of strategy
	   */
	  @Test
	  public void testChangeStrategy() throws Exception {
	    LineOperationsStrategy initialStrategy = mock(LineOperationsStrategy.class);
	    LineOperations lineOperations = new LineOperations(initialStrategy);

	    lineOperations.performOperation("testcases\\\\file.txt");
	    verify(initialStrategy).execute("In the above 'run_program' represents the command given to run your Java program.");

	    final LineOperationsStrategy newStrategy = mock(LineOperationsStrategy.class);
	    lineOperations.changeStrategy(newStrategy);

	    lineOperations.performOperation("testcases\\\\file.txt");
	    verify(newStrategy).execute("In the above 'run_program' represents the command given to run your Java program.");
	}

}
