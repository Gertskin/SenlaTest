package by.gertskin;

import java.io.*;

public class Task4 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter numbers: \n");
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());

        System.out.println("NOD = " + NOD(a, b));
        System.out.println("NOK = " + NOK(a, b));


    }

    public static int NOD(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return NOD(b, a % b);
    };

    public static int NOK(int a, int b) {
        return (a / NOD(a, b) * b);
    }
}
