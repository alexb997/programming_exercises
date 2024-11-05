import java.util.Arrays;
import java.util.Comparator;

public class LargestConcatenatedInt {
    public static String largestNumber(int[] nums) {
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest Number: " + largestNumber(nums));
    }
}
