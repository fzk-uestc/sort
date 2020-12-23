package com.QuickSort;

import org.junit.Test;

import java.util.*;

/**
 * 调用Collections.shuffle(list)方法打乱数组
 * @author fzkstart
 * @create 2020-12-11 9:35
 */
public class ShuffleClass {
    /**
     * 随机打乱传入的整数数组
     * @param a
     */
    public static void shuffle(int[] a) {
        List<Integer> list = new ArrayList<Integer>();
        int n=a.length;
        for (int i = 0; i < n; i++)
            list.add(new Integer(a[i]));
//            System.out.println("打乱前:");
//            System.out.println(list);

//                System.out.println("第" + i + "次打乱：");
            Collections.shuffle(list);
//                System.out.println(list);
        for(int i=0;i<n;i++)
            a[i]=list.get(i);
    }
    @Test
    public void testShuffle(){
        int []a =new int[]{100,1,3,5,6,3,2,4,7,9,8,0,1,2,3,4,88,0,0,0,23,67,3,544,7};
        shuffle(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"\t");
        }
    }
}
