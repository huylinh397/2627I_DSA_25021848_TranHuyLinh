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
public class Find_the_running_medium {
}

class Result {
    static class Node implements Comparable<Node> {
        int val;
        int id;

        Node(int val, int id) {
            this.val = val;
            this.id = id;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        TreeSet<Node> bst = new TreeSet<>();
        List<Double> res = new ArrayList<>();

        Node left = null;
        Node right = null;

        for (int i = 0; i < a.size(); i++) {
            Node cur = new Node(a.get(i), i);
            bst.add(cur);

            if (i == 0) {
                left = right = cur;
            } else if (bst.size() % 2 == 0) {
                if (cur.compareTo(left) < 0) {
                    left = bst.lower(left);
                } else {
                    right = bst.higher(right);
                }
            } else {
                if (cur.compareTo(left) < 0) {
                    right = left;
                } else if (cur.compareTo(right) > 0) {
                    left = right;
                } else {
                    left = right = cur;
                }
            }

            double median = (left.val + right.val) / 2.0;
            res.add(median);
        }

        return res;
    }

}
class Solutio {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
