// class Solution {
//   public void sortColors(int[] nums) {
//     int l = 0;
//     int r = nums.length - 1;


// //Dutch National flag Algorithm low, mid, high; 
//     for (int i = 0; i <= r;)
//       if (nums[i] == 0)
//         swap(nums, i++, l++);
//       else if (nums[i] == 1)
//         ++i;
//       else
//         swap(nums, i, r--);
//     }

//   private void swap(int[] nums, int i, int j) {
//     final int temp = nums[i];
//     nums[i] = nums[j];
//     nums[j] = temp;
//   }
// }

class Solution {
    public void sortColors(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<nums.length; j++){
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }
}