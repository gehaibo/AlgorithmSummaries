package algorithm.leetcode.algorithm;
/*
 * easy
 * 661. Image Smoother 
 * Given a 2D integer matrix M representing the gray scale of an image, 
 * you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down)
 *  of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0

Note:
    1.	The value in the given matrix is in the range of [0, 255].
    2.	The length and width of the given matrix are in the range of [1, 150].

 */
public class NO661_ImageSmoother {
	//方法1：
	//直接统计
	public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0 || M[0] == null || M[0].length == 0){
            return M;
        }
        int m = M.length,n = M[0].length;
        int[][] result = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int count = 0,sum = 0;
                for(int x = -1 ; x <= 1 ; x++){
                    for(int y = -1 ; y <= 1 ; y++){
                        if(i+x >= 0 && i+x < m && j+y >=0 && j+y < n){
                            count++;
                            sum+=M[i+x][j+y];
                        }
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
}
