package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C1_Container_With_Most_Water {
    // Question: https://leetcode.com/problems/container-with-most-water/

    // Logic: 2 - pointer approach:
    //      - height = we take min of height[start] & height[end]
    //      - width = diff of (end-start)
    // MaxArea - min height * width
    // if height[start] > height[end] => decrease end--;
    // if height[end] > height[start] => increase start++;

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};

        int ans_bf = maxArea_bf(height);

        System.out.println("Max Area: " + ans_bf);

        // 2 - pointer
        int ans_opti = maxArea_2_pointer(height);

        System.out.println("Max Area: " + ans_opti);
    }

    public static int maxArea_bf(int[] height){
        int maxArea = 0;
        int len = height.length;
        for(int i=0; i<len; i++){
            int h1 = height[i];
            for(int j=i+1; j<len; j++) {
                int h2 = height[j];
                maxArea = Math.max(maxArea, Math.min(h1, h2)*(j-i));
            }
        }
        return maxArea;
    }
    public static int maxArea_2_pointer(int[] height) {

        int start = 0;
        int len = height.length;
        int end = len-1;
        int maximumArea = Integer.MIN_VALUE;

        while(start<end)
        {
            maximumArea = Math.max(
                    maximumArea,
                    Math.min(height[start],height[end]) * (end-start)
            );

            if(height[start]>height[end]) // move left from top-most right
                end--;
            else // move right from top-most left
                start++;
        }

        // return the max area
        return maximumArea;
    }

}
