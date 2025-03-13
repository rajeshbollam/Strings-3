//The idea here is to solve dissect the number into triplets and solve for a triplet and repeat that for remaining triplets in the number
//We will add to the triplet the correct suffix as per the number of triplets present in the given number
//To calculate each triplet, we further dissect it into 3 conditions, whether the number is less than 20, between 20 and 99 and greater than 100
//Time Complexity: O(1) because only 4 maximum triplets as per valid int number
//Space Complexity: O(1)
class Solution {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }
        int i = 0; //suffix index
        String result = "";
        while(num > 0){
            int triplet = num %1000;
            if(triplet != 0){
                result = magic(triplet).trim() + " " + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }

    private String magic(int curr){
        if(curr < 20){
            return below_20[curr];
        }
        else if(curr <100){
            return tens[curr/10] + " " + magic(curr%10);
        }
        else{
            return below_20[curr/100] + " Hundred " + magic(curr%100);
        }
    }
}
