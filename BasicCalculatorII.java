//The idea here is to perform operations on the go using calc and tail variables without using any extra stack space
//At each index, we calculate calc and tail variables as per the operator
//Another important point here is that at each index, we complete the operations till that index - 1
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int calculate(String s) {
        int currNum = 0; char lastsign = '+';
        int calc = 0; int tail = 0;

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if(lastsign == '+'){
                    calc = calc + currNum;
                    tail = currNum;
                }
                else if(lastsign == '-'){
                    calc = calc - currNum;
                    tail = -currNum;
                }
                else if(lastsign == '*'){
                    calc = calc - tail + tail * currNum;
                    tail = tail * currNum;
                } 
                else {
                    calc = calc - tail + tail / currNum;
                    tail = tail / currNum;
                }
                currNum = 0;
                lastsign = ch;
            }
        }
        return calc;
    }
}