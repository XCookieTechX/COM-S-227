package lab6;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;


public class LabPlotter2 {
	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		ArrayList<Polyline>finalArray = new ArrayList<Polyline>();
	    File file = new File(filename);

		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			line = line.trim();
			System.out.println(line);
			Scanner scnr = new Scanner(line);
			if (((!line.isBlank() && ((line.charAt(0)) != '#')))) {
				int width = 1;
				if(scnr.hasNextInt()) {
					width = scnr.nextInt();
				}
				String color = scnr.next();
				Polyline ply = new Polyline(color, width);
				
				while(scnr.hasNextInt()) {
					int x = scnr.nextInt();
					int y = scnr.nextInt();
					Point point = new Point(x, y);
					ply.addPoint(point);
				}
				finalArray.add(ply);
				
				
			}
			
				
		}
		
		return finalArray;
	}
	
	
	
	 public static void main(String[] args) throws FileNotFoundException
	  {
	    ArrayList<Polyline> list = readFile("hello.txt");
	    Plotter plotter = new Plotter();

	    for (Polyline p : list)
	    {
	      plotter.plot(p);
	    }
	  }
}
