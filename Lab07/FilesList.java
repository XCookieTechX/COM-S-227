package lab7;

import java.io.File;

public class FilesList {
    public static void main(String[] args) {

    }

    public static int countFiles(File f) {
        int count = 0;
        if(!(f.isDirectory())){
            return 1;
        }else{
            File[] file = f.listFiles();
            for(int i = 0; i < file.length; i++){
                count += countFiles(file[i]);
            }
        }
        return count;
    }

    public static int countPatterns(int n){
        if( n < 0){
            return 0;
        }else if(n == 0){
            return 1;
        }else{
            return countPatterns(n - 1) + countPatterns(n - 3);
        }
    }
}


