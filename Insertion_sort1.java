import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Insertion_sort1 {
    class Result {

        /*
         * Complete the 'insertionSort1' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        public static void insertionSort1(int n, List<Integer> arr) {

            // Write your code here

            int [] tar = new int[n];

            for (int i = 0; i < n; i++ ){

                tar[i] = arr.get(i);

            }

            int end = tar[n-1];

            for(int j = n-2; j >=-1 ; j-- ){
                if(j == -1){
                    tar[0] = end;
                    for (int i = 0; i < n; i++ ){System.out.print(tar[i] + " ");}

                    System.out.print("\n");
                    break;
                }

                if(end > tar[j]){

                    tar[j+1] = end;

                    for (int i = 0; i < n; i++ ){System.out.print(tar[i] + " ");}

                    System.out.print("\n");
                    break;

                }

                else{
                    int tmp = tar[j];

                    tar[j+1] = tmp;

                    for (int i = 0; i < n; i++ ){System.out.print(tar[i] + " ");}

                    System.out.print("\n");

                }

            }

        }





    }



    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            Result.insertionSort1(n, arr);

            bufferedReader.close();
        }
    }

}
