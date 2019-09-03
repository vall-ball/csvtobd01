package ru.vallball.csvtobd01;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import static  java.nio.file.CopyOption.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVReader {
	
	private static final Logger logger = LoggerFactory.getLogger(CSVReader.class);
	public static void main(String[] args) throws IOException, URISyntaxException {
		CSVReader r = new CSVReader();
		r.listOfColor(r.read(new File("C:\\Users\\val\\Desktop\\1\\java\\csvtobd01\\1.csv")));
		r.moveFile(new File("C:\\Users\\val\\Desktop\\1\\java\\csvtobd01\\1.csv"));
		
	}

	public List<String> read(File file) throws IOException  {
		 try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\val\\Desktop\\1\\java\\csvtobd01\\1.csv"))) {

	            stream.forEach(System.out::println);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		List<String> list = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
		logger.info("Был считан файл " + file);
		logger.info("Содержимое файла " + list);
		return list;
	}

	public List<Color> listOfColor(List<String> list){
		int k = Integer.parseInt("2");
		System.out.println("k=" + k);
		List<Color> colors = new ArrayList<>();
		for (String s : list) {
			String[] subs = s.split(",");
			System.out.println(subs[0] + " " + subs[1]);
			int j = Integer.parseInt(subs[0]);
			Color color = new Color(j,subs[1]);
			colors.add(color);
		}
		logger.info("Был сформирован список цветов");
		return colors;
		
	}
	
	public void moveFile(File file) throws IOException, URISyntaxException {
		File f = new File(file.getParent() + "\\ready\\" + file.getName());
		Files.move(file.toPath(), Paths.get(f.toURI()));
				
	}

}
