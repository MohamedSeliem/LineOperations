package com.softwaremethodology.assignment;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class commandTranslatorTest {
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Test
	public void testMain() {
		String line="% run_program freq testcases/freqtest.txt";
		functionTest(line);

	}
	private void functionTest(String line) {
		String[] str=line.split(" ");
	    commandTranslator.main(str);
	    setUpStreams();
	    switch(str[2]) {
	    case "wc":
		    assertEquals("number of lines: 5\r\n" + 
		    		"number of Words: 62\r\n" + 
		    		"number of characters: 330\r\n", outContent.toString());
	    	break;
	    case "grep":
	    	 assertEquals("And the argument 'word' is replaced by a word to be searched.\r\n", outContent.toString());
	    	break;
	    case "freq":
	    	assertEquals("Word: line & Frequency: 10\r\n"+"Word: word & Frequency: 11\r\n", outContent.toString());
	    	break;
	    }
	    cleanUpStreams();
		
	}
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));	}
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

}