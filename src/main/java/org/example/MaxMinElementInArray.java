package org.example;

import java.util.Arrays;
import java.util.Collections;

public class MaxMinElementInArray {
    public static void minMaxWithSingleLoop(int[] arr){
        int max = arr[0];
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
        }
        System.out.println(max+"-----"+min);//O(n)
    }

    public static void minMaxWithCollections(Integer[] arr){
        int min = Collections.min(Arrays.asList(arr));
        int max = Collections.max(Arrays.asList(arr));
        System.out.println(max +"------"+ min);//O(n)
    }

    public static void minMaxWithStreams(int[ ] arr){
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max +"-------"+ min);//O(n)
    }

    public static void main(String[] args){
        int[] arr = {12,11,34,15,1,50,22};
        Integer[] arr1 = new Integer[]{12,3,4,5,3,1,5,12,23,32,22,1,12,2};

        minMaxWithCollections(arr1);
        minMaxWithStreams(arr);
        minMaxWithSingleLoop(arr);
    }
}
