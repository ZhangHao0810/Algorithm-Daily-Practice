package Q04_二维数组中的查找;

import org.junit.Test;

/**
 * @author Super-Zhang
 * @date 2021-08-03 11:09
 * @update 2023年3月29日14:00:21
 * <p>
 * 描述
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * <p>
 * 给定 target = 7，返回 true。
 * 给定 target = 3，返回 false。
 * <p>
 * 0 <= array.length <= 500
 * 0 <= array[0].length <= 500
 */
public class FindInDoubleDimensionalArray {

    /**
     * 思路很重要，暴力解法不可取。O(m*n)
     * <p>
     * 而通过借鉴类似图片放大缩小的手法，可以将最大复杂度降到O(m+n)
     * 我为这种方法起了一个名字： 【对角元素限制法】
     * <p>
     * 见名之意，日后遇见类似二维数组中查找的题目，可借鉴对角元素限制法。
     * <p>
     * 仔细分析给定数组的形式，从列和行的反极开始遍历。如 行最大列最小 or 行最小列最大。
     */

    @Test
    public void mainTest() {
        int[][] arrary = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(7, arrary));
        System.out.println(find(3, arrary));

    }

    /**
     * @description 算法，最重要的是逻辑，他是逻辑的书面表达。要以逻辑的角度去读取，否则与天书无异。
     * @author zh
     * @data 2023/3/29
     */
    public boolean find(int target, int[][] arrary) {

        if (arrary == null || arrary.length == 0 || arrary[0].length == 0) {
            return false;
        }
        int rowLength = arrary.length;
        int colLength = arrary[0].length;

        //row 行，col 列。
        int row = 0, col = colLength - 1;
        while (row < rowLength && col >= 0) {
            if (target == arrary[row][col]) {
                return true;
            }
            if (target > arrary[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
