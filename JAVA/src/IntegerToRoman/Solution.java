package IntegerToRoman;

public class Solution {
    String[] symbol = new String[]{
            "MMM", "MM", "M",
            "CM", "D", "CD",
            "CCC", "CC", "C",
            "XC", "L", "XL",
            "XXX", "XX", "X",
            "IX", "V", "IV",
            "III", "II", "I"};

    int[] value = new int[]{
            3000, 2000, 1000,
            900, 500, 400,
            300, 200, 100,
            90, 50, 40,
            30, 20, 10,
            9, 5, 4,
            3, 2, 1};

    StringBuilder sb = new StringBuilder();

    public String intToRoman(int num) {
        dfs(0, num);
        return sb.toString();
    }

    public void dfs(int strt, int num){
        if(num == 0){
            return;
        }

        for(int i=strt; i<value.length; i++){
            int val = value[i];

            if(num >= val){
                sb.append(symbol[i]);
                dfs(i+1, num-val);
                break;
            }
        }
    }
}
