package com.hwp.study.algorithems;

import java.util.Arrays;

public class Sort {
    private static void swap(int i, int j, Comparable[] num){
        Comparable tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    /**
     * Compare times is n * (n + 1)/2
     * Exchange time is n * (n + 1)/2
     * Extra memory is 1
     */
    public static void bubbleSort(Comparable[] num){
        for(int i = 0; i < num.length; i++){
            for(int j = 1; j < num.length - i; j++){
                if(num[j].compareTo(num[j - 1]) < 0){
                    swap(j-1, j, num);
                }
            }
        }
    }

    /**
     * Compare times is n * (n + 1)/2
     * Exchange time is n
     * Extra memory is 1
     * @param num
     */
    public static void selectSort(Comparable[] num){
        for(int i = 0; i < num.length; i++){
            int min = i;
            for(int j = i + 1; j < num.length; j++){
                if(num[j].compareTo(num[min]) < 0){
                    min = j;
                }
            }
            swap(i, min, num);
        }
    }

    /**
     * Compare times: average n*n/4, worst n*n/2, best n -1
     * Exchange times: average n*n/4, worst n*n/2, best 0
     * @param num
     */
    public static void insertSort(Comparable[] num){
        for(int i = 1; i < num.length; i++){
            int j = i;
            while(j > 0 && num[j].compareTo(num[j-1]) < 0){
                swap(j, j -1, num);
                j--;
            }
        }
    }

    /**
     *
     * @param num
     */
    public static void shellSort(Comparable[] num){
        int n = num.length;
        int h = n >> 1;
        while(h > 0){
            for(int i = 0; i < num.length; i = i+h){
                int j = i;
                while(j >= h && num[j].compareTo(num[j-h]) < 0){
                    swap(j, j-h, num);
                    j = j - h;
                }
            }

            h = h >> 1;
        }
    }

    private static void merge(Comparable[] num, int low, int mid, int high){
        Comparable[] temp = new Comparable[high - low + 1];

        int i = low;
        int j = mid + 1;
        int m = 0;
        while(i <= mid && j <= high){
            if(num[i].compareTo(num[j]) <= 0){
                temp[m++] = num[i++];
            } else {
                temp[m++] = num[j++];
            }
        }

        while(i <= mid){
            temp[m++] = num[i++];
        }

        while(j <= high){
            temp[m++] = num[j++];
        }

        for(int l = 0; l < temp.length; l++){
            num[l + low] = temp[l];
        }

        temp = null;
    }

    private static void mergeSort(Comparable[] num, int low, int high){
        if (low >= high){
            return;
        }

        int mid = (high + low)/2;
        mergeSort(num, low, mid);
        mergeSort(num, mid + 1, high);

        if (num[mid].compareTo(num[mid + 1]) <= 0){
            return;
        }
        merge(num, low, mid, high);
    }

    public static void mergeSort(Comparable[] num){
        mergeSort(num, 0, num.length - 1);
    }

    private static void quickSort(Comparable[] num, int low, int high){
        if(low >= high){
            return;
        }

        Comparable base = num[low];
        int i = low;
        int j = high;
        while(i < j){

            while(j > i && num[j].compareTo(base) >= 0){
                j--;
            }

            while(j > i && num[i].compareTo(base) <= 0){
                i++;
            }

            if(i < j){
                swap(i, j, num);
            }
        }

        num[low] = num[j];
        num[j] = base;

        quickSort(num, low, j-1);
        quickSort(num, j+1, high);
    }

    public static void quickSort(Comparable[] num){
        quickSort(num, 0, num.length - 1);
    }

    public static void main(String[] args){
        Integer[] num = {9, 6, 10, 3, 14, 5, 8, 4, 19, 14};

        Sort.quickSort(num);

        System.out.println(Arrays.toString(num));

        String[] str = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        Sort.quickSort(str);
        System.out.println(Arrays.toString(str));
    }
}
