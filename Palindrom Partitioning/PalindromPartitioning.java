import java.util.ArrayList;

public class PalindromPartitioning {
    public static boolean checkPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
    public static void partition(ArrayList<ArrayList<String>> res, String s, int ind, ArrayList<String> curr) {

        if(ind == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }

        String temp = "";

        for(int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);

            if(checkPalindrome(temp)){
                curr.add(temp);
                partition(res, s, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        String s = "caracter";

        int ind = 0;
        ArrayList<String> curr = new ArrayList<>();
        partition(res, s, ind, curr);
        for(ArrayList<String> iter : res) {
            System.out.println(iter);
        }
    }
}
