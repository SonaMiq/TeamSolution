import java.util.HashMap;
import java.util.Map;

public class Task {
    Map<Integer, Integer> fn(int number) {
        int k = digitCounts(number);
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < 10; i++) {
            int sum=1;
            if (i == 0) {
                for (int j = 0; j < k-1; j++) {
                    sum+=j*9*(int)Math.pow(10,j-1);
                }
            }

            else {
                sum = (k - 1) * (int) Math.pow(10, k - 2);
            }
                for (int num = (int) Math.pow(10, k - 1); num <= number; num++) {
                    sum += occurCount(num, i);
                }
                map.put(i, sum);
            }


        return map;
    }

    int occurCount(int number, int digit) {
        int cout = 0;
        while (number != 0) {
            if (number % 10 == digit)
                cout++;
            number = number / 10;
        }
        return cout;
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
        System.out.println(new Task().fn(123456789));
    }

}

