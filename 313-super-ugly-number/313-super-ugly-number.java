class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
       // int[] ptrs = new  int[primes.length];
       //  Arrays.fill(ptrs,1);
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int i = 0 ; i < primes.length ; i++){
            pq.add(new Tuple(primes[i],1,1L*primes[i]));
        }
        long[] dp = new long[n+1];
        dp[1] = 1;
        for(int i = 2 ; i <dp.length ;){
            Tuple t = pq.remove();
            Long min = t.value;
            if(dp[i-1]!=t.value){
                 dp[i] = min;
                i++;
            }
           
            pq.add(new Tuple(t.prime,t.ptr+1,t.prime*dp[t.ptr+1]));
            }
        return (int)dp[n];
    }
}

class Tuple implements Comparable<Tuple>{
    int prime;
    int ptr;
    long value;
    Tuple(int prime,int ptr,long value){
        this.prime = prime;
        this.ptr = ptr;
        this.value = value;
    }
    public int compareTo(Tuple t){
        return (int)this.value - (int)t.value; 
    }
}