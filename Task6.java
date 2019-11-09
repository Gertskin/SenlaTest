package by.gertskin;

import java.io.*;

public class Task6 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter string: ");
        String str = bufferedReader.readLine();

        System.out.println(str.replaceAll("\\d", ""));
    }
}
