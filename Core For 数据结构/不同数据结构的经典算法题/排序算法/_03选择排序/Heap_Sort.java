package _03选择排序;

import java.util.Arrays;

/**
 * @author Super-Zhang
 * @date 2021-04-05 14:56
 * <p>
 * 堆排序的时间复杂度，主要在初始化堆过程和每次选取最大数后重新建堆的过程；
 * <p>
 * 利用堆的概念进行选择排序。
 * <p>
 * 堆是一个 父节点大于或者小于所有子节点的 完全二叉树。 用一维数组的形式存储。
 * <p>
 * 1、从上到下，从左到右 将数组元素构建完全二叉树。
 * 2. 调整
 * <p>
 * 【这几个完全二叉树中的表示要牢记！！】
 * 用数组表达完全2叉树中，第i个元素的左右子节点是2i+1,2i+2
 * i节点的 父节点为：(i-1)/2；最后一个非叶子节点：n/2 - 1
 * <p>
 * <p>
 * 输出堆顶元素就是：把堆顶元素与最后一个元素交换，然后把最后一个元素从堆中摘除,
 * 下次排数组下标为0到n-2的元素，即n-1位置第2次不参与排序了
 * <p>
 * <p>
 * 堆排序的时间复杂度为：O(nlogn)
 * <p>
 * 【空间复杂度】
 * 因为堆排序是就地排序，空间复杂度为常数：O(1)
 *
 *
 *
 */
public class Heap_Sort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 7, 11, 5, 12, 3, 0, 1};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序前：" + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {

//        首先默认该数组中存储的是一个完全二叉树。元素之间是没有大小关系的。
//        数组中的存储对应二叉树依次是 从上到下，从左到右。

        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {    //arr.length/2-1 是最后一个非叶子节点
            //从最后一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length-1);  // 从最后一个非叶子开始，不断调整，树从小到大，逐渐形成堆。
        }

        //此时已经得到一个大顶堆了。 所有父节点大于子节点。
        // 接下来就是输出堆顶元素 放在数组的最后位置。 对剩下的再次排序 得到大顶堆。

        //2.从数组的最后位置开始 调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) { //j是下标。
//            j指向堆中的最后一个元素 即待排序的序列的最后一个元素。
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换，即将堆顶移出 （ 0 位置是堆顶）
            adjustHeap(arr, 0, j - 1);//将除了最后一个位置的元素 重新对堆进行调整

        }
    }

    /**
     * 已经是大顶堆了，但是把堆顶换成了i
     * i 目标节点坐标（方法开始时在堆顶，不一定是最大，要把它调整到合适位置）
     * last  堆空间是 arr【i】-arr【last】
     */
    private static void adjustHeap(int[] arr, int i, int last) {
        int temp = arr[i];//先取出当前元素i ，i=0的话就是堆顶元素

        for (int k = i * 2 + 1; k <= last; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            //k是左子节点。 k+1 是右子节点。
//          //这里无论是k还是k+1都是取不到last的。所以不影响。
//            k=k*2+1下一次循环，就是孙子辈
            if (k + 1 <= last && arr[k] < arr[k + 1]) {//如果右子节点存在且左子结点小于右子结点，k指向右子结点
                k++;
            }
            //此时的k是 大的那个子节点。【注意，子节点不一定是儿子，可能是重重孙子】
            if (arr[k] > temp) {//如果子节点大于当前元素，将子节点值赋给目标节点（不用进行交换）
                arr[i] = arr[k];
                i = k; //将比目标节点大的孩子的下标k 给到未来的目标下标。
//                进入下一次for循环，再看儿子的儿子是什么情况。
            } else {
                break;
            }
        }

        arr[i] = temp;//将目标值（形参i=0的话就是堆顶值）放到最终的位置
    }

    /**
     * 交换元素
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
