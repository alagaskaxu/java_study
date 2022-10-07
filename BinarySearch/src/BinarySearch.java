import java.util.Arrays;

/**
 * 二分查找
 * 在有序数组中寻找对应的数值
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {30,20,50,10,80,9,7,12,100,40,8};
        int searchword = 80;    //查找目标数组20

        int index = binarySearch(arr,searchword);
        System.out.println(searchword+"的数组下标索引位置为"+index);

    }

    /**
     * 二分查找方法
     * @param array 目标数组
     * @param value 目标数值
     * @return 返回索引下标,或返回-1表示未找到
     */
    public static int binarySearch(int[] array, int value){
        //先用Arrays.sort排序工具将数组排序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int low = 0;    //低位索引下标
        int high = array.length - 1;   //高位索引下标

        while(low <= high){
            int middle = (low + high)/2;    //中间索引值,也是正在比较的值
            if (value == array[middle]){    //中间值等于目标值表明找到目标返回索引下标
                return middle;
            }
            //目标大于中间值则去 中间值-高位 之间查找其中间值
            if (value > array[middle]){
                low = middle + 1;
            }
            //目标小于中间值则去 低位下标-中间值 之间查找其中间值
            if (value < array[middle]){
                high = middle - 1;
            }
        }
        return -1;

    }

}
