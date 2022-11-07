class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        if(sumOfDigits(n)<=target) return 0;
        int power = 1;
        long orignal_n = n;
        while(true){
          long n_state = ((n/(long)Math.pow(10,power))+1)*(long)Math.pow(10,power);
          if(n_state==0) break;
          if(sumOfDigits(n_state)<=target) return Math.abs(n - n_state);
          power++;
        }
      return 0;
    }
  
    public long sumOfDigits(long n){
      long sum = 0;
      
      while(n!=0){
        sum+=(n%10);
        n = n/10;
      }
      return sum;
    }
}