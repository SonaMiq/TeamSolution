import java.util.HashMap;
import java.util.Map;

public class Taskkk {
    int k = 0;

    Map<Integer, Integer> fn(int number) {
        k = digitCounts(number);
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < 10; i++) {
         // from 7891 first count from 0 to 999
            int sum = 1;
            if (i == 0) {
                for (int j = 0; j < k - 1; j++) {
                    sum += j * 9 * (int) Math.pow(10, j - 1);
                }
            } else {
                sum = (k - 1) * (int) Math.pow(10, k - 2);
            }

            // from 7891 from 1000 to 6999
            int first=number/(int)Math.pow(10,k-1);
            if(first-1!=0) {
                sum += (k - 1) * (number / (int) Math.pow(10, k - 1) - 1) * (int) Math.pow(10, k - 2) +
                        (int) Math.pow(10, k - 1);
            }
           // to count only for 7000-7891
            sum += f(number, i);

            map.put(i, sum);
        }

        return map;

    }

    int f(int number, int i) {

       int k=digitCounts(number);
       int count=0;
        for (int j = number/(int) Math.pow(10,k-1)*(int) Math.pow(10,k-1); j <=number; j++) {
             count+=occurCount(j,i);
        }
          return count;
       }

    int occurCount(int number,int i){
        int count=0;
        while (number!=0){
            if(number%10==i) {
                count++;
            }
            number=number/10;
        }
        return count;
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
        System.out.println(new Taskkk().fn(123456));
    }
}