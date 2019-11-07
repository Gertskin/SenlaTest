package by.gertskin;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter number: ");
        String number = bufferedReader.readLine();
        int N = Integer.parseInt(number);

        boolean[] a = new boolean[N];
        for (int i = 2; i < N; i++) a[i] = true;
        for (int i = 2; i < N; i++)
            if (a[i] != false)
                for (int j = i; i*j < N; j++)
                    a[i*j] = false;

        for (int i = 2; i < N; i++)
            if (a[i]) System.out.print(i + " ");

        System.out.println();
    }
}
