class Solution {
    public int reverse(int x) {
     int y = 0;
     int temp;
     while (x!= 0){
        temp = x % 10;
        x/=10;
        if (
            y < 0 && y < (Integer.MIN_VALUE - temp)/10||
            y>0 && y>(Integer.MAX_VALUE - temp)/10
        )return 0;
        y = (y*10) + temp;
     }return y;      
    }
}