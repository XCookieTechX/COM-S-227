package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String[] removeDuplicates(String[] words){
        ArrayList <String>wordsArray  = new ArrayList<String>();
        for(int i =0; i < words.length; i++){
            String secondWord = words[i];
            if(!(wordsArray.contains(secondWord))){
                wordsArray.add(secondWord);

            }
        }
        String[] newArray = wordsArray.toArray(new String[]{});



        return newArray;
    }

}
