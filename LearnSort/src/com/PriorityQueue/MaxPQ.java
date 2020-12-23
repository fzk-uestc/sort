package com.PriorityQueue;

/**
 * 基于堆的优先队列
 * @author fzkstart
 * @create 2020-12-11 11:05
 */
public class MaxPQ <T extends Comparable<T>>{

    private T[] pq;     //基于堆的完全二叉树
    private int n=0;    //存储于pq[1..n],pq[0]没有使用

    /**
     * 建立最大堆
     * 注意：
     * 这里并没有考虑优先队列内存使用率以及内存不足的扩容问题
     * 可以自己写扩容代码和长度减短的代码，
     * 也可以省心的直接用ArrayList<T>,它内部实现了这些代码
     * @param maxN 优先队列的最大容量
     */
    public MaxPQ(int maxN){
        pq= (T[]) new Comparable[maxN+1];
    }
//    public MaxPQ(T[] a){
//    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public void insert(T t){
        pq[++n]=t;
        swim(n);
    }
    public T delMax(){
        T max=pq[1];    //从根结点得到最大元素
        exch(1,n--);    //将其和最后一个结点交换
        pq[n+1]=null;   //防止对象游离
        sink(1);        //恢复堆的有序性
        return max;
    }

    //辅助方法
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i,int j){
       T t=pq[i];
       pq[i]=pq[j];
       pq[j]=t;
    }

    /**
     * 由下至上的堆有序化(上浮)实现
     * @param k 优先级改变（变大）元素的索引
     */
    private void swim(int k){
        while(k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    /**
     * 由上至下的堆有序化（下沉）实现
     * @param k 优先级改变（变小）元素的索引
     */
    private void sink(int k){
        while(k*2<=n){
            //找到左右孩子中较大的一个孩子
            int j=k*2;  //j指向较大的子结点
            if(j<n&&less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
}
