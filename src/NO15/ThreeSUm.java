package NO15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSUm {
    /**
     * @param nums [-1, 0, 1, 2, -1, -4]
     * @return [
     *         [-1, 0, 1],
     *         [-1, -1, 2]
     *         ]
     */
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);        //sort the array to avoid duplicated solutions

        for(int i = 0; i< nums.length - 2; i++){
//            if(i == 0 || (i >= 1 && nums[i] != nums[i - 1])){
              if(i == 0 ||  nums[i] != nums[i - 1]){ //对于相等的nums[i]和nums[i+1] 得到的结果相同
                int low = i + 1;             //结果只包含nums[i]一次
                int high = nums.length - 1;
                int target = 0 - nums[i];    //问题等同于

                while(low < high){
                    if(nums[low] + nums[high] == target){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) //找到一个match后需要移动指针
                            low++;                                       //保证在指针移动时，当前值不重复出现
                        while(low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] < nums[i])
                        low++;
                    else
                        high--;
                }
            }
        }
        return result;
    }


}
