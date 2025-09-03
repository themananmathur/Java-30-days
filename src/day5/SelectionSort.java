package day5;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        for(int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Selection Sorted array: ");
        for(int num:arr) System.out.print(num+" ");
    }
}
