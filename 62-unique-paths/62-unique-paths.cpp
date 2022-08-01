class Solution {
public:
    int uniquePaths(int m, int n) {
        
        long long ans=1;
        int temp=min(m,n);
        n=max(m,n);
        m=temp;
        
        for(int i=1;i<m;i++){
            ans = ans * (m+n-1-i)/i;
            cout<<ans<<" ";
        }
        
        return ans;
        
    }
};