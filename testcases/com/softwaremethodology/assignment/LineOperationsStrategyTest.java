package com.softwaremethodology.assignment;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.softwaremethodology.assignment.countLine;

public class LineOperationsStrategyTest {
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Test
	public void testExecute() throws IOException {
		LineOperationsStrategy strategy =new countLine();
		String file = "The arguments 'wc', 'grep', and 'freq' are fixed, and given as is ";
		
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(file.getBytes());
		// read it with BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = br.readLine()) != null) {
			strategy.execute(line);
		}
		br.close();
		strategy.fclose();
		setUpStreams();
		assertEquals("number of lines: 1\r\n" + 
	    		"number of Words: 12\r\n" + 
	    		"number of characters: 66\r\n", outContent.toString());
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
