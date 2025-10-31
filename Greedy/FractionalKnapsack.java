package Greedy;
import java.util.*;

public class FractionalKnapsack {
    //TC: O(n log n + n)*O(n log n)  SC:O(1)
    public static double fractionalKnapsack(int[] weight, int[] value, int capacity){
        int n=weight.length;

        Arrays.sort(weight);
        Arrays.sort(value);
        
        int currWeight=0;
        double finalValue=0.0;

        for(int i=0; i<n; i++){
            if(currWeight+weight[i]<=capacity){
                currWeight+=weight[i];
                finalValue+=value[i];
            }else{
                int remain=capacity-currWeight;
                finalValue+= ((double)value[i]/(double)weight[i])*(double)remain;
                break;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        int capacity=50;
        int[] weight = {20,10,30};
        int[] value = {100,60,120};

        double result= fractionalKnapsack(weight, value, capacity);
        System.out.println(result);
    }
}
