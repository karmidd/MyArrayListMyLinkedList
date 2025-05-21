package Written;


import java.util.ArrayList;

public class Q2 {
    public static void main(String[] args) {
        int[] arr = {9,9,61,61,61,21,0,9,9,9,9,81,81};
        int count = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
                if(count > 1 && i == arr.length-2){
                    System.out.println("Value " + arr[i] + " is being repeated " + count + " times starting at index " + (i+1-count));
                }
            }
            else{
                if (count>1){
                    System.out.println("Value " + arr[i] + " is being repeated " + count + " times starting at index " + (i+1-count));
                    count = 1;
                }
            }
        }


    }
}
