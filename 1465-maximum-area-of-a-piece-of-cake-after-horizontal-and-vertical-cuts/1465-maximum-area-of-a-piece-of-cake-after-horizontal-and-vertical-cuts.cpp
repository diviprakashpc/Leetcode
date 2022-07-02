class Solution {
public:
     int maxArea(int h, int w, vector<int>& horizontal, vector<int>& vertical) {
        sort(begin(horizontal), end(horizontal));              // n(logn)
        sort(begin(vertical), end(vertical));                       // n(logn)
        
        long long hmx = 0, vmx = 0, prev = 0;
        
        for(auto i: horizontal)                                          // O(n)  
            hmx = max(hmx, i - prev), prev = i;
        hmx = max(hmx, h - prev);
        
        prev = 0;
        for(auto i: vertical)                                              // O(n)  
            vmx = max(vmx, i - prev), prev = i;
        vmx = max(vmx, w - prev);
        
        int mod = 1e9 + 7;
        return hmx * vmx % mod;
    }
};