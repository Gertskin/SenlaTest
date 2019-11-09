package by.gertskin;

import java.io.*;

public class Task5 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter word: ");
        String str = bufferedReader.readLine();

        System.out.println("Is palindrom - " +isPalindrome(str,false));

    }

    public static boolean isPalindrome(String str, boolean isCaseSensitive){
        if (!isCaseSensitive) {
            str = str.toLowerCase();
        };
        int i = str.length()-1;
        int j=0;
        while(i > j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
