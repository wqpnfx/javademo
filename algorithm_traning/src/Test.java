import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        int[] nums1 = {2,2,1};
        int[] nums2 = {2,2,1};

        System.out.println(2^2^1^3^3);
//        System.out.println(singleNumber(nums));
        intersect(nums1,nums2);
    }

    public static void intersect(int[] nums1, int[] nums2) {
        List<Integer> list1=new ArrayList<Integer>();
        for(int i :nums1){
            list1.add(i);
        }
        List<Integer> list2=new ArrayList<Integer>();
        for(int i:nums2){
            list2.add(i);
        }
        list1.retainAll(list2);
        System.out.println(list1.toArray(new Integer[list1.size()]));
    }

    public static int maxProfit(int[] prices) {
        int k = 0;
        int sum = 0;
        return calProfit(prices, k, sum);
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {

        if(prices.length==0||prices.length<2){
            return 0;
        }

        int profile=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                profile+=prices[i+1]-prices[i];
            }
        }
        return profile;
    }


    /**
     * 股票求取利润问题
     * @param prices
     * @param k
     * @param sum
     * @return
     */
    private static int calProfit(int[] prices, int k, int sum) {

        int start = 0;
        int end = 0;
        boolean flag=true;
        //获得最低买入
        for (int i = k + 1; i < prices.length; i++) {
            flag=false;
            if (prices[k] >= prices[i]) {
                k++;
                if (k == prices.length - 1) {
                    return sum;
                }
                continue;
            }
            start = prices[k];
            break;
        }
        //没有买入 退出
        if(flag){
            return sum;
        }
        //获得最高值
        for (int i = k + 1; i < prices.length; i++) {
            if (prices[k] <= prices[i]) {
                k++;
                if (k == prices.length - 1) {
                    end = prices[k];
                    sum = sum + (end - start);
                    return sum;
                }
                continue;
            }
            end = prices[k];
            sum = sum + (end - start);
            break;
        }
        if (k + 1 == prices.length - 1) {
            return sum;
        }
        sum = calProfit(prices, k, sum);
        return sum;
    }

    public static int singleNumber(int[] nums) {
        //排除一个的特殊情况
        if (nums.length<2){
            return nums[0];
        }

        // 至少有三个
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++){
            //排序后 单独的元素不与前一个元素和后一个元素相等
            if((nums[i] !=nums[i-1]) & (nums[i] != nums[i+1])){
                return nums[i];
            }
        }
        //排除第一个和最后一个的特殊情况
        if(nums[0]!=nums[1]){
            return nums[0];
        }else{
            return nums[nums.length-1];
        }
    }

}
