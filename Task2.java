package by.gertskin;

import java.io.*;

public class Task2 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter number: ");
        String number = bufferedReader.readLine();
        int N = Integer.parseInt(number);

        for (int i = 0 ; i < N; i++)
            System.out.print(fibonacci(i) + " ");

    }

    public static int fibonacci(int n)  {
        if (n < 2)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


}
