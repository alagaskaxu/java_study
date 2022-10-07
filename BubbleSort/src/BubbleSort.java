
import java.util.Arrays;

/**
 * 冒泡排序
 * 原理:两数比较,大数后移(或小数前移),
 * 将无序的分为无序与有序再逐渐变为有序的
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] v = {2,5,3,1,9,4,8,0,6,7};
        bubbleSort(v);
    }
    //冒泡排序算法
    public static void bubbleSort(int[] values) {
        //int values[] = {3,1,6,2,9,0,7,4,8,5};
        System.out.println("排序前数组元素:" + Arrays.toString(values));
        //冒泡排序
        System.out.println("具体运行过程:");
        //优化:排序完成则不进行后续的比较了
        //定义一个布尔类型变量,来标记数组是否到达有序状态(只要数组元素交换了则表明无序反之亦然不交换则表示有序)
        boolean flag = true;
        for (int i=0; i<values.length - 1; i++){
            //外层循环表示排序趟数,每一趟结束排好一个数;10个数最多排序(10-1)趟,排好9个数9趟,一趟最多比较9次
            //第1趟(i=0)排序结束后会把最大的9放在数组最后,一趟排好一个数,第9(i=8)趟排序完成
            for (int j = 1; j<values.length - i; j++){
                //每一次比较都需要从头开始循环
                //优化:每次只需排无序堆的数据,有序的数可以不比较,values.length - i 优化比较次数
                if (values[j-1] > values[j]){
                    //两数比较,大数置后
                    //前面大则交换位置
                    int temp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = temp;
                    //优化:发生交换则表明该趟还是无序状态
                    flag = false;
                }
                System.out.println("第"+ (i+1) +"趟:第"+j+"次排序:\n"+Arrays.toString(values));

            }

            System.out.println("第"+ (i+1) +"趟(i=" + i + ")完成后:\n"+Arrays.toString(values));

            //优化:利用状态标志减少运算
            if (flag){
                System.out.println("第"+(i+1)+"趟没交换过元素.结束循环,冒泡排序结束");
                break;  //break跳出循环
            }else{
                flag = true;    //flag判断完没跳出循环则重置为原值
            }
        }
        //排序结束
        System.out.println("简单升序冒泡排序后:"+Arrays.toString(values));

    }

}
