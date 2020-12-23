package com.MergeSort;

/**
 * 2. 归并排序
 * 2.1 自顶向下的归并排序
 * 特点：1.递归归并，体现分治思想，化整为零，递归解决
 *      2.稳定性分析：具有稳定性
 *      3.复杂度分析：
 *          时间复杂度：O(NlogN);
 *                      需要1/2NlgN~NlgN次比较，最多需要访问数组6NlgN次；
 *                      归并树状图层数为lgN，每层归并最多访问6N次数组，
 *                      2N用于复制，2N用于移动，2N用于比较；
 *          空间复杂度：O(N)
 *      4.性能优化：递归会使得小规模问题中方法的调用过于频繁，
 *      可以尝试用插入排序处理小规模数组(如n<15)，一般能将归并排序的
 *      运行时间缩短10%~15%。
 * @author fzkstart
 * @create 2020-12-09 10:06
 */
public class Merge {

    /**
     * 自顶向下的归并排序
     * 基于原地归并的抽象来实现
     * @param a
     */
    public static void sort(Comparable[]a){
        // 归并所需的辅助数组
        Comparable[] aux=new Comparable[a.length]; // 一次性分配空间
        sort(a,aux,0,a.length-1);
    }
    private static void sort(Comparable[]a,Comparable[] aux,int lo,int hi){
        // 将数组a[lo..hi]排序
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,aux,lo,mid);             // 将左半边排序
        sort(a,aux,mid+1,hi);       // 将右半边排序
        merge(a,aux,lo,mid,hi);        // 归并结果
    }

    /**
     * 原地递归的抽象方法
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi){
        // 将a[lo..mid]和a[mid+1..hi]归并
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k]=a[k]; // 将a[lo..hi]复制到aux[lo..hi]

        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }

    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static boolean isSorted(Comparable []a){
        //测试数组是否有序
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }
}
