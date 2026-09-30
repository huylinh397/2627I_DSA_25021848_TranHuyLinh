import java.util.List;

class EqualStacks {
    public static int equalStacks(List h1, List h2, List h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int h : h1) sum1 += h;
        for (int h : h2) sum2 += h;
        for (int h : h3) sum3 += h;

        int i1 = 0, i2 = 0, i3 = 0;

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(i2++);
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3.get(i3++);
            }
        }

        return sum1;
    }
}
