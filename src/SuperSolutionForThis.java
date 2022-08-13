import java.util.HashMap;
import java.util.Map;

public class SuperSolutionForThis {

    int k_start;
    int k;

    Map<Integer, Integer> fn(int number) {

        k_start = digitCounts(number);
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < 10; i++) {

            map.put(i, fff(number, i));
        }
        return map;
    }

    int fff(int number, int i) {

        int sum = 1;
        int k_last = k;
        k = digitCounts(number);
        if (number == 0) {
            //check if we have zeros in middle of number 70897
            if (k_last - k > 1) {
                if (i == 0) {
                    return  (k_last - k - 1) * (number + 1);
                }
            }
            return 0;
        }
        if (k == 1) {
            //check if we have zeros in middle of number 70897
            if (k_last - k > 1) {
                if (i == 0) {
                    return  (k_last - k - 1) * (number + 1)+1;
                }
            }
            if (i <= number)
                return 1;
            return 0;
        }

        // from 7891 first count from 0 to 999
        if (i == 0 && k == k_start) {
            for (int j = 0; j < k - 1; j++) {
                sum += j * 9 * (int) Math.pow(10, j - 1);
            }
        } else {
            sum = (k - 1) * (int) Math.pow(10, k - 2);
        }

        // from 7891 from 1000 to 6999
        int first = number / (int) Math.pow(10, k - 1);

        sum += (k - 1) * (first - 1) * (int) Math.pow(10, k - 2);

        //in this case put i in first position
        if (i != 0 && i < first && k == k_start) {
            sum += (int) Math.pow(10, k - 1);
        }
        if (i < first && k != k_start) {
            sum += (int) Math.pow(10, k - 1);
        }
        if (i == first) {
            sum += number % (int) Math.pow(10, k - 1) + 1;
        }

        //check if we have zeros in middle of number 70897
        if (k_last - k > 1) {
            if (i == 0) {
                sum += (k_last - k - 1) * (number + 1);
            }
        }
        sum += fff(number % (int) Math.pow(10, k - 1), i);

        return sum;
    }

    int digitCounts(int number) {
        int d = 0;
        while (number != 0) {
            d++;
            number = number / 10;

        }
        return d;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(new Taskkk().fn(400580230));
        System.out.println(System.currentTimeMillis() - time);
    }
}
