package BinarySearch;

import java.util.PriorityQueue;

public class MinimiseMaxDistance {
    //Minimise Maximum distance between gas stations

    //BRUTE FORCE  TC:O(k*n)+O(n)  SC:O(n-1)
    public static double minMaxDist(int[] arr, int k){
        int n=arr.length;
        int[] howMany= new int[n-1];

        for(int gasSt=1; gasSt<=k; gasSt++){
            double maxSection=-1;
            int maxInd=-1;
            for(int i=0; i<n-1; i++){
                double diff=(arr[i+1]-arr[i]);
                double sectionLength=diff/(double)(howMany[i]+1);
                if(sectionLength>maxSection){
                    maxSection=sectionLength;
                    maxInd=i;
                }
            }
            howMany[maxInd]++;
        }
        double maxAns=-1;
        for(int i=0; i<n-1; i++){
            double diff =(arr[i+1]-arr[i]);
            double sectionLength=diff/(double)(howMany[i]+1);
            maxAns=Math.max(maxAns,sectionLength);
        }
        return maxAns;
    }

    //BETTER APPROACH  TC:O(nlogn + klogn)  SC:O(n-1)   [using heap/priority queue]
    public static double minMaxDist2(int[] arr, int k){
        int n=arr.length;
        int[] howMany= new int[n-1];
        PriorityQueue<Pair> pq= new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        for(int i=0; i<n-1; i++){
            pq.add(new Pair(arr[i+1]-arr[i], i));
        }
        for(int gasSt=1; gasSt<=k; gasSt++){
            Pair tp=pq.poll();
            
            int secInd=tp.second;
            howMany[secInd]++;
            double iniDiff=arr[secInd+1]-arr[secInd];
            double newSecLen = iniDiff/(double)(howMany[secInd]+1);
            pq.add(new Pair(newSecLen, secInd));
        }
       
        return pq.peek().first;
    }

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    //OPTIMAL SOLUTION  TC:O(n*log(Len))+O(n) SC:O(1)    [using binary search]
    public static double minMaxDist3(int[] arr, int k){
        int n=arr.length;
        double low=0, high=0;

        for(int i=0; i<n-1; i++){
            high=Math.max(high, (double)(arr[i+1]-arr[i]));
        }

        double diff=1e-6;
        while(high-low> diff){
            double mid=low+(high-low)/2;
            int cnt=gasStationsReq(arr,mid);
            if(cnt>k){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;
    }

    public static int gasStationsReq(int[] arr, double dist){
        int cnt=0;
        for(int i=1; i<arr.length; i++){
            int numberInBetween=(int)((arr[i]-arr[i-1])/dist);
            if((arr[i]-arr[i-1])==(dist*numberInBetween)){
                numberInBetween--;
            }
            cnt+=numberInBetween;
        }
        return cnt;
    }
    

    public static void main(String[] args) {
        int[] arr={1,13,17,23};
        int k=5;
        System.out.println(minMaxDist(arr,k));
        System.out.println(minMaxDist2(arr,k));
        System.out.println(minMaxDist3(arr,k));
    }
    
}
