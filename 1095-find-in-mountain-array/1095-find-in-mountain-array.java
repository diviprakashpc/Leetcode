/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray al) {
        int idx = getPeak(al,target);
        if(al.get(idx)==target) return idx;
        int left = find(0,idx-1,al,target,true);
        if(left!=-1) return left;
        int right = find(idx+1,al.length()-1,al,target,false);
        return right;
    }
    
    
    public int find(int start , int end , MountainArray al , int target,boolean inc){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(al.get(mid)>target){
                if(inc){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }else if(al.get(mid)<target){
                if(inc) start = mid+1;
                else end = mid - 1;
            }
            else return mid;
        }
        return -1;
    }
    
    public int getPeak(MountainArray al , int target){
        int start = 0;
        int end = al.length()-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(al.get(mid)<al.get(mid+1)){
                start = mid +1;
            }
            else end = mid;
        }
        return start;
    }
}