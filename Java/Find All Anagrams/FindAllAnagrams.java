import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    public static List<Integer> solution(String s, String p){
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pCount = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sCount = new HashMap<>();
        int windowSize = p.length();

        for (int i = 0; i < windowSize; i++) {
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
        }

        if (sCount.equals(pCount)) {
            result.add(0);
        }

        for (int i = windowSize; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - windowSize);

            sCount.put(newChar, sCount.getOrDefault(newChar, 0) + 1);

            if (sCount.get(oldChar) == 1) {
                sCount.remove(oldChar);
            } else {
                sCount.put(oldChar, sCount.get(oldChar) - 1);
            }

            if (sCount.equals(pCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution(s, p);

        System.out.println(result);
    }
}
