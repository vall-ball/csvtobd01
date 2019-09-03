package ru.vallball.csvtobd01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.testng.annotations.Test;


public class CSVReaderTest {
	private CSVReader reader = new CSVReader();
	
	@Test
	public void testRead() throws IOException {
		reader.read(new File("C:\\Users\\val\\Desktop\\1\\java\\csvtobd01\\1.csv"));
		
	}
	
	@Test
	public void testForm() throws IOException {
		List<Color> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(mock(Color.class));
		}
		reader.listOfColor(reader.read(new File("C:\\Users\\val\\Desktop\\1\\java\\csvtobd01\\1.csv")));
			
	}
}
