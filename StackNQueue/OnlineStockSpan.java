package StackNQueue;
import java.util.*;

public class OnlineStockSpan {
    //maximum consecutive days for which the stock price was less than or equal to current day

    //Brute Force
    // private ArrayList<Integer> arr;
    // public int next(int price){
    //     arr.add(price);        
    //     int cnt=1;
    //     for(int i=arr.size()-2; i>=0; i--){
    //         if(arr.get(i)<=price) cnt++;
    //         else break;
    //     }
    //     return cnt;
    // }
    // public void stockSpanner() {
    //     arr= new ArrayList<>();
    // }

    //Optimal Solution
    private Stack<int[]> stack;
    int index;

    public void stockSpanner() {
        index= -1;
        stack = new Stack<>();
    }

    // Function to calculate the stock span
    public int next(int price) {
        index=index+1; // Default span is 1 for the current day

        while (!stack.isEmpty() && stack.peek()[1] <= price)
            stack.pop();
        
        int ans = index-(stack.isEmpty() ? -1 : stack.peek()[0]);

        stack.push(new int[]{index, price});        
        return ans;
    }

    public static void main(String[] args){
        OnlineStockSpan stockSpanner = new OnlineStockSpan();
        stockSpanner.stockSpanner(); // Initialize the stock spanner object
        
        String[] commands = {"StockSpanner", "next", "next", "next", "next", "next", "next", "next"};
        int[][] inputs = {{}, {100}, {80}, {60}, {70}, {60}, {75}, {85}};
        
        for (int i = 1; i < commands.length; i++) { // Skip "StockSpanner" command
            int price = inputs[i][0];
            System.out.println("Span for " + price + ": " + stockSpanner.next(price));
        }
    }
}
