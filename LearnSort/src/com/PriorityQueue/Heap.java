package com.PriorityQueue;

/**
 * 4.堆排序
 * 思想：用数组模拟堆的完全二叉树。从右向左用下沉方法sink()构造子堆，
 * 如果一个节点左右子树已经是堆，再调用sink()，可以将它们变成一个堆。
 * 将堆的最大元素a[0]和a[n-1]交换,此时堆长-1，再重新有序化堆。重复操作直至堆空。
 * 特点：1.分两步：构造堆；下沉排序
 *      2.不稳定
 *      3.复杂度：
 *          时间复杂度：O(NlogN); 最多2NlgN+2N次比较和一般次数的交换；
 *                     2N来自于堆构造；每次下沉最多2NlgN比较
 *          空间复杂度：O(1),原地排序。
 *      4.唯一能够同时最优利用空间和时间的方法；在空间很紧张时很流行；
 *      5.缺点：现代系统很多应用很少使用它，因为它无法利用缓存。缓存未命中次数远高于相邻元素比较法，
 *       如快速排序、归并排序，甚至是希尔排序。
 * @author fzkstart
 * @create 2020-12-11 12:19
 */
public class Heap {
    public static void HeapSort(Comparable[] a){
        int n=a.length; // n为数组长度
        //  左子树和右子树分别是2k+1和2k+2

        //1.阶段一：for循环构造堆,此时a[0]为最大元素，最大堆
        for(int k=n/2-1;k>=0;k--)
            sink(a,k,n);
        //2.阶段二：下沉排序
        while(n>1){
            //while循环将a[0]和a[n-1]交换并修复堆（此时n--，堆长减1）,
            //通过sink()重新选择最大元素到a[0]
            exch(a,0,--n);
            sink(a,0,n);
        }
    }

    private static void sink(Comparable[] a,int k,int n){
        while(2*k+1<n){    //存在左子树
            int maxIndex = k*2+1; //指向左子树
            //如果有右子树，且右子树大于左子树，则将最大指针指向右子树
            if (maxIndex+1<n&&less(a[maxIndex],a[maxIndex+1]))
                maxIndex ++;
            //父节点是最大值时，退出循环
            if(!less(a[k],a[maxIndex])) break;
            //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
            exch(a,k,maxIndex);
            k=maxIndex;
        }
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
}
