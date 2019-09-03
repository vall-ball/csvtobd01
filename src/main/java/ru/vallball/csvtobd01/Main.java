package ru.vallball.csvtobd01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	 public static void main(String[] args) throws IOException {
	      SessionFactory sessionFactory = new Configuration().configure()
	                                                         .buildSessionFactory();
	   try {
	          persist(sessionFactory);
	          load(sessionFactory);
	      } finally {
	          sessionFactory.close();
	      }
	  }

 private static void load(SessionFactory sessionFactory) {
	      System.out.println("-- loading colors --");
	      Session session = sessionFactory.openSession();
	      @SuppressWarnings("unchecked")
	      List<Color> persons = session.createQuery("FROM Color").list();
	      persons.forEach((x) -> System.out.printf("- %s%n", x));
	      session.close();
	  }

	  private static void persist(SessionFactory sessionFactory) throws IOException {
	      CSVReader reader = new CSVReader();
		  List<Color> colors = reader.listOfColor(reader.read(new File("C:\\Users\\val\\Desktop\\1\\java\\csvtobd01\\1.csv")));
		  System.out.println("-- persisting persons --");
	     
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      session.save(colors.get(0));
	      session.save(colors.get(1));
	      session.getTransaction().commit();
	  }
	
}
