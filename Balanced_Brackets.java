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

class Balanced_Brackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> history = new Stack<>();
        long size = s.length();

        for (int i = 0; i < size; i++){
            Character tar = s.charAt(i);
            if (history.isEmpty() &&(tar == ')' || tar == ']' || tar == '}')){
                return "NO";
            }
            if (tar == '(' || tar == '[' || tar == '{'){
                history.push(tar);
            }
            else{
                Character old = history.pop();
                if(tar == ')' && old == '('){continue;}
                if(tar == ']' && old == '['){continue;}
                if(tar == '}' && old == '{'){continue;}
                else{return "NO";}

            }
        }
        if(!history.isEmpty()){
            return "NO";
        }
        return "YES";
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Balanced_Brackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
