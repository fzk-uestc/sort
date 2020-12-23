package com.PrimarySort;

import com.MergeSort.Merge;
import com.MergeSort.MergeBU;
import com.PriorityQueue.Heap;
import com.QuickSort.Quick;
import com.QuickSort.Quick3way;
import org.junit.Test;

/**
 * @author fzkstart
 * @create 2020-12-06 16:12
 */
public class TestSort {
    @Test
    public void testSelection()  {
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            Selection.sort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Selection.show(a);
        System.out.println("选择排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testInsertion(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            Insertion.sortReverseUnStable(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Insertion.show(a);
        System.out.println("不稳定反向插入排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testShell(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            Shell.sort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Shell.show(a);
        System.out.println("希尔排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testMerge(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            Merge.sort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Selection.show(a);
        System.out.println("自顶向下的归并排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testMergeBU(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            MergeBU.sort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Selection.show(a);
        System.out.println("自底向上的归并排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testQuick(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            Quick.sort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Selection.show(a);
        System.out.println("快速排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testQuick3way(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++){
            a =new Integer[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
            Quick3way.sort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Selection.show(a);
        System.out.println("三向切分快速排序用时："+(end-begin)+"ms");
    }
    @Test
    public void testHeapSort(){
        Integer []a=null;
        //记录开始的时间
        long begin=System.currentTimeMillis();
        for(long i=0;i<5000000;i++) {
            a = new Integer[]{100, 1, 3, 5, 6, 3, 2, 4, 7, 9, 8, 0, 1, 2, 3, 4, 88, 0, 0, 0, 23, 67, 3, 544, 7};
            Heap.HeapSort(a);
        }
        long end=System.currentTimeMillis();//排序完成时间
        Selection.show(a);
        System.out.println("堆排序用时："+(end-begin)+"ms");
    }
}

