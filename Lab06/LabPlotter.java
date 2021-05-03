package lab6;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class LabPlotter {
	private static Polyline parseOneLine(String line){
		String color;
		line.trim();
		int width = 1;
		Scanner scanner = new Scanner(line);
		
		if (scanner.hasNextInt()) {
			width = scanner.nextInt();
		}
		color  = scanner.next();
		Polyline test = new Polyline(color, width);
		
		while(scanner.hasNextInt()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			Point tempTwo = new Point(x, y);
			test.addPoint(tempTwo);
		}
		
		
		return test;
	}

	public static void main(String[] args)
	{
	  Plotter plotter = new Plotter();
	  Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
	  plotter.plot(p);
	  
	  p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
	  plotter.plot(p);
	}
}
