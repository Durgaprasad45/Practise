package org.example;

public class ReverseAnArray {
    public static void reverseAnArrayMethod1(int[] arr){
        int[] reversed = new int[arr.length];
        System.out.println(arr.length);
        System.out.println(reversed.length);
        for(int i=0;i<arr.length;i++){
            reversed[i] = arr[arr.length-1-i];
        }
        for (int a: reversed) {
            System.out.print(a+" ");
        }
    }

    public static void reverseAnArrayMethod2(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;

            left++;
            right--;
        }
        for (int a: arr) {
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8,9};
        reverseAnArrayMethod1(arr);
        System.out.println();
        reverseAnArrayMethod2(arr);
    }
}
