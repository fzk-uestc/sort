package com.QuickSort;

import com.PrimarySort.Insertion;

/**
 * 3.快速排序
 * 3.1基本的快速排序(二分法)
 * 思想：该方法的关键在于切分：对于某个j，a[j]已经排定
 *      a[lo]到a[j-1]中所有元素都不大于a[j],a[j+1]到a[hi]所有元素都不小于a[j]
 * 特点：1.缺点：在切分不平衡时，会变得极为低效；
 *      2.复杂度分析：
 *          时间复杂度：O(NlgN)，平均~2NlnN次比较，~1/3NlnN次交换；
 *                      最多~N^2次比较，随机打乱数组可以预防这种情况；
 *                      移动次数相对于归并排序更少；
 *          空间复杂度：O(lgN)，原地排序（只需要一个很小的辅助栈）
 *       3.算法改进：1.对于小数组，插入排序更快，因为递归调用sort()影响速度；
 *                2.第二个方法是使用子数组的一部分元素的中位数切分数组，代价是需要计算中位数
 * @author fzkstart
 * @create 2020-12-09 16:42
 */
public class Quick {
    public static int M=5;//参数M是切换到插入排序的小数组长度，5~15都可以

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo+M){//切换到小数组的插入排序
            Insertion.sort(a,lo,hi);
            return;
        }
        int j=partition1(a,lo,hi);   //切分
        sort(a,lo,j-1);         //将左半部分a[lo..j-1]排序
        sort(a,j+1,hi);         //将右半部分a[j+1..hi]排序
    }

    /**
     * 快速排序的切分
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a,int lo,int hi){
        //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int i=lo,j=hi+1;    //左右扫描指针
        Comparable  v=a[lo];//切分元素
        while(true){//扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i],v)) if(i==hi) break;
            while(less(v,a[--j])) continue;
            if(i>=j) break;
            //这里可能会将一些等值的元素交换位置，
            // 当有大量的重复元素时，使用三向切分快速排序效率更高
            exch(a,i,j);
        }
        exch(a,lo,j);   //将v=a[j]放入正确的位置
        return j;       //a[lo..j-1]<=a[j]<=a[j+1..hi]达成
    }
    private static int partition1(Comparable[] a,int lo,int hi){
        //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int pivot=(int)(lo+Math.random()*(hi-lo+1));//切分元素的索引
        int i=lo-1,j=hi+1;    //左右扫描指针
        Comparable  v=a[lo];//切分元素
        while(true){//扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i],v)) continue;
            while(less(v,a[--j])) continue;
            if(i>=j) break;
            //这里可能会将一些等值的元素交换位置，
            // 当有大量的重复元素时，使用三向切分快速排序效率更高
            exch(a,i,j);
        }
        exch(a,pivot,j);   //将v=a[j]放入正确的位置
        return j;       //a[lo..j-1]<=a[j]<=a[j+1..hi]达成
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
