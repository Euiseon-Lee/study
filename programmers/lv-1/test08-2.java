class Solution {
    public boolean solution(int x) {
        int test = x;
        int sum = 0;
        
        while (test != 0){
            sum += test % 10;
            test /= 10;
        }
        
        return x % sum == 0;
        
        /*
        if문을 쓰지 않고도 boolean값으로 return이 가능
        
        if (x % sum == 0){
            return true;
        } else {
            return false;
        }
        */
         
    }
}
