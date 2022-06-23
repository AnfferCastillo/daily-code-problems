package leetcode;

public class RemoveElement27 {

  public static void main(String[] args) {
      var test = new RemoveElement27();
    System.out.println(test.removeElement(new int[]{1}, 25)); //1
      System.out.println(test.removeElement(new int[]{25}, 25)); //0
    System.out.println(test.removeElement(new int[]{3,3,3,3}, 3)); //0
      System.out.println(test.removeElement(new int[]{3,3,3,3,3}, 3));//0*/
    System.out.println(test.removeElement(new int[]{3,2,2,3}, 3));//2
    System.out.println(test.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));//5
    System.out.println(test.removeElement(new int[]{1,2}, 3));//2
    System.out.println(test.removeElement(new int[]{1,2}, 2));//1
    System.out.println(test.removeElement(new int[]{1,2},1));//1
  }

    public int removeElement(int[] nums, int val) {
        var i = 0;
        var j = 1;

        if(nums.length == 1 && nums[i] != val) return 1;
        else if(nums.length == 1 && nums[i] == val) return 0;

        while(i < nums.length) {
            if(nums[i] == val) {
                if(j < nums.length && nums[j] != val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                    i++;
                } else if( j >= nums.length) {
                    return i;
                } else {
                    j++;
                }
            } else {
                i++;
                j = i + 1;
            }
        }

        return i;
    }
}
