//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
public:
    void rem(string &s, string &ans, int i ){
        if ( i >= s.length())
            return;
        if (ans.empty())
            ans.push_back(s[i]);
        else{
            bool found = 0;
            while(i<s.length()&&s[i]==ans[ans.length()-1]){
                i++;
                found = 1;
            }
            if (found)
                ans.pop_back();
            if ( i != s.length())
                ans.push_back(s[i]);
        }
        
        rem(s, ans, i+1);
    }
    string rremove(string s){
        string ans = s;
        do{
            s = ans;
            ans = "";
            rem(s, ans, 0);
        }while(!ans.empty() && ans != s);
        return ans;
 }
};

//{ Driver Code Starts.

int main() {
    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);
        Solution ob;
        cout << ob.rremove(s) << "\n";
    }
    return 0;
}
// } Driver Code Ends