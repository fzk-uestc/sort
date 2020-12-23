package com.PrimarySort;

/**
 * 1. 初级排序算法
 * 1.1 选择排序
 * 特点：1.运行时间与输入元素的有序程度无关，排序时间一样长;
 *      2.数据移动是最少的;
 *      3.不稳定的排序方法;
 *      4.复杂度分析：
 *          时间复杂度：n次交换，n*(n-1)/2次比较；O(N^2)
 *          空间复杂度：O(1)
 *
 * @author fzkstart
 * @create 2020-12-06 16:05
 * 排序算法类的模板
 */
public class Selection {
    public static void sort(Comparable[] a){
        //默认升序排序
        int n=a.length;
        for(int i=0;i<n;i++){
            int minIndex=i;  //  最小元素的索引
            for(int j=i+1;j<n;j++)
                if(less(a[j],a[minIndex]))
                    minIndex=j;
            exch(a,i,minIndex);
        }

    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void show(Comparable []a){
        //在一行中打印数组
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    public static boolean isSorted(Comparable []a){
        //测试数组是否有序
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }
}
