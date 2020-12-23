package com.MergeSort;

/**
 * 2.归并排序
 * 2.2 自底向上的归并排序
 * 特点：1.循序渐进解决
 *      2.其他特点同自顶向下的归并排序
 *      3.当数组长度为2的幂时，两者的比较次数和访问次数同，其他情况次序会有所不同
 *      4.自底向上归并排序比较适合用于链表
 * @author fzkstart
 * @create 2020-12-09 11:58
 */
public class MergeBU {
    /**
     * 自顶向下的归并排序
     * 基于原地归并的抽象来实现
     * @param a
     */
    public static void sort(Comparable[]a){
        int N=a.length; // 进行lgN次两两归并
        Comparable []aux=new Comparable[N]; // 归并所需的辅助数组
        for(int sz=1;sz<N;sz+=sz)  // sz是子数组的大小
            for(int lo=0;lo<N-sz;lo+=sz+sz) // lo:子数组索引
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }

    /**
     * 原地递归的抽象方法
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a,Comparable[]aux,int lo,int mid,int hi){
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
