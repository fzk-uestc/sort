package com.QuickSort;

import com.PrimarySort.Insertion;

/**
 * 3.快速排序
 * 3.2 三向切分快速排序
 * 思想：当数组中存在大量重复元素，快速排序性能尚可，但还有巨大改进空间。
 *      将数组切分为三部分，分别对应小于、等于、大于切分元素。
 * 特点：1.对于存在大量重复元素的数组，归并排序时间复杂度是线性对数的，而三向切分则是线性的；
 *      2.三向切分快速排序对重复元素的适应性，使得其成为排序库函数的最佳算法选择；
 *      3.缺点：在数组中重复元素不多的情况下，它比标准二分法多了很多次交换。
 * @author fzkstart
 * @create 2020-12-09 22:28
 */
public class Quick3way {
    public static int M=5;//参数M是切换到插入排序的小数组长度，5~15都可以

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo+M){//切换到小数组的插入排序
            Insertion.sort(a,lo,hi);
            return;
        }
//        if(hi<=lo) return;
        int lt=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
        while(i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0)       exch(a,lt++,i++);
            else if(cmp>0)  exch(a,i,gt--);
            else            i++;
        }   //  现在a[lo..lt-1]<v=a[lt..gt]<a[gt+1..hi]成立
        sort(a,lo,lt-1);         //将左半部分a[lo..lt-1]排序
        sort(a,gt+1,hi);         //将右半部分a[gt+1..hi]排序
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
