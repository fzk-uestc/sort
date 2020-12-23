package com.PrimarySort;

/**
 * 1.初级排序算法：
 * 1.3 希尔排序
 * 特点：1.是对插入排序的简单改进，类似于插入排序，但是增量为h，
 *      即数组中任意间隔为h的元素都是有序的，即h有序数组。
 *      2.希尔排序比插入排序和选择排序更高效，并且数组越大，优势越大；
 *      因为它权衡了子数组的规模和有序性。
 *      3.增量h的递增序列会影响算法性能，但在实际应用中区别不明显。
 *      4.复杂度分析：希尔排序难以准确描述其性能
 *              此例子中使用的递增序列在最坏情况下，比较次数和N^(3/2)成正比。
 *          时间复杂度：O(N^3/2)
 *          空间复杂度：O(1)
 * @author fzkstart
 * @create 2020-12-08 19:15
 */
public class Shell {
    public static void sort(Comparable[] a){
        //默认升序排序，Shell排序算法
        int n=a.length;
        int h=1;
        //h为间隔,此处选择较为简单的递增序列
        while(h<n/3)
            h=h*3+1;
        Comparable temp=null;
        int j=0;
        while(h>=1){
            for(int i=h;i<n;i++){
                temp=a[i];
                for(j=i;j>=h&&less(temp,a[j-h]);j-=h){
                    a[j]=a[j-h];
                }
                a[j]=temp;
            }
            h=h/3;
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
