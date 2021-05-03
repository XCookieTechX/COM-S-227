package lab5;

import java.util.Scanner;

public class Main {

	public static String getInitials(String name) {
		Scanner scnr = new Scanner(name);
		String initial = "";

		while (scnr.hasNext()){
			scnr.next();
			initial += name.charAt(0);
		}
	return initial;
	}

	public static int getVowel(String string){
		int index = -1;
		for (int i = 0; i < string.length(); i+= 1){
			if ("aeiouAEIOU".indexOf(i) >= 0){
				index = i;
			}
		}
		return index;
	}

}
