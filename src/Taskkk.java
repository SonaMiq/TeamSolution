import java.util.HashMap;
import java.util.Map;

public class Taskkk {
    int k = 0;

    Map<Integer, Integer> fn(int number) {
        k = digitCounts(number);
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < 10; i++) {

            int sum = 1;
            if (i == 0) {
                for (int j = 0; j < k - 1; j++) {
                    sum += j * 9 * (int) Math.pow(10, j - 1);
                }
            } else {
                sum = (k - 1) * (int) Math.pow(10, k - 2);
            }

            sum += f(number, i);

            map.put(i, sum);
        }

        return map;

    }

    int f(int number, int i) {
        int k = digitCounts(number);
        if (k <=1) {
            if(i<=number)
            return 1;
            return 0;
        }


        int[] arr = new int[k];
        int m = number;
        for (int j = k - 1; j >= 0; j--) {
            arr[j] = m % 10;
            m = m / 10;
        }
        if (i < arr[0] || i == 0) {
            int first = arr[0];
            if (k == this.k) {
                if (i == 0) {
                    return f(number % (int) Math.pow(10, k - 1), i);
                }

            } else first++;

            return (int) Math.pow(10, k - 1) + first * f(number % (int) Math.pow(10, k - 1), i);
        }
        if (i == arr[0]) {
            int first = arr[0];
            if (k != this.k)
                first++;
          return  arr[1]*(int) Math.pow(10, k - 2)+f(number % (int) Math.pow(10, k - 2),i)+ first * f(number % (int) Math.pow(10, k - 1), i);
        }
        if (i > arr[0]) {
            int first = arr[0];
            if (k != this.k)
                first++;
            return first * f(number % (int) Math.pow(10, k - 1), i);
        }

        return 0;

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
        System.out.println(new Taskkk().fn(125));
    }
}