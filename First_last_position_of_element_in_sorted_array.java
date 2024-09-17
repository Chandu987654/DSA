class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=leftsearch(nums, target);
        int right=rightsearch(nums, target);
        return new int[]{left, right};
    }
//divide array into two parts and apply two binary search ex: 1,4,3,1,5,5,5,5,5,4,3,2,1  target 5 
    public int leftsearch(int []nums, int target)
    {
        int low=0;
        int high=nums.length-1;
        int idx=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                idx=mid;
                high=mid-1;
            }
            else if(nums[mid]>=target)
            {
                 high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return idx;
    }


     public int rightsearch(int []nums, int target)
    {
        int low=0;
        int high=nums.length-1;
        int idx=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                idx=mid;
                low=mid+1;
                
            }
            else if(nums[mid]>=target)
            {
                 high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return idx;
    }

}
