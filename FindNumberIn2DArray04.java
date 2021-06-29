package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: FindNumberIn2DArray04
 * @Author: hp
 * @Date: 23/06/2021 16:11
 * @Version: 1.0
 * @Description:
 */
public class FindNumberIn2DArray04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = matrix[0].length - 1; j >= 0; j--) {
                if(matrix[i][j] == target) {
                    return true;
                }
                if(matrix[i][j] > target) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
