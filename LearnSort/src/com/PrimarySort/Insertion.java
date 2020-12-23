package com.PrimarySort;

/**
 * 1.初级排序算法
 * 1.2 插入排序
 * 特点：1.所需的时间取决于数组中元素的初始顺序，时间上：部分有序<随机数组<逆序数组
 *      2.复杂度分析：
 *      时间复杂度： 最坏情况：1/2N^2次比较1/2N^2次移动；O(N^2)
 *                  最好情况：N-1次比较和0次移动; O(N)
 *                  平均情况：1/4N^2次比较和1/4N^2移动; O(N^2)
 *      空间复杂度：O(1)
 * @author fzkstart
 * @create 2020-12-06 16:57
 */

public class Insertion {
    public static void sort(Comparable[] a){
        //正向插入排序算法，升序，从左向右，稳定
        int n=a.length;
        Comparable temp=null;
        int j=0;
        for(int i=1;i<n;i++){
            temp=a[i];
            //将 a[i] 插入到a[i-1]、a[i-2]...中
            /* 不使用exch方法：
            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
            exch(a,j,j-1); */
            //改为将较大的元素右移而不是交换，访问数组次数可以减半
            for(j=i;j>0&&less(temp,a[j-1]);j--){
                a[j]=a[j-1];
            }
            a[j]=temp;
        }
    }
    public static void sort(Comparable[] a,int lo,int hi){
        //正向插入排序算法，升序，从左向右，稳定
        Comparable temp=null;
        int j=0;
        for(int i=lo+1;i<=hi;i++){
            temp=a[i];
            for(j=i;j>lo&&less(temp,a[j-1]);j--){
                a[j]=a[j-1];
            }
            a[j]=temp;
        }
    }
    public static void sortReverseStable(Comparable[] a){
        //反向插入排序算法，降序，从右向左,稳定
        int n=a.length;
        Comparable temp=null;
        int j=0;
        for(int i=n-2;i>=0;i--){
            temp=a[i];
            for(j=i;j<n-1&&less(temp,a[j+1]);j++){
                a[j]=a[j+1];
            }
            a[j]=temp;
        }
    }
    public static void sortReverseUnStable(Comparable[] a){
        //反向插入排序算法，降序，从右向左，不稳定
        int n=a.length;
        Comparable temp=null;
        int j=0;
        for(int i=n-2;i>=0;i--){
            temp=a[i];
            for(j=i;j<n-1&&temp.compareTo(a[j+1])<=0;j++){
                a[j]=a[j+1];
            }
            a[j]=temp;
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
