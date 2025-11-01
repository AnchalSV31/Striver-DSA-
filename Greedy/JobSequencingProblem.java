package Greedy;
import java.util.*;

public class JobSequencingProblem {
    //TC:O(N log N) + O(N*M)  SC:O(M)
    static class Job{
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id=x;
            this.deadline=y;
            this.profit=z;
        }
    }

    public static int[] JobScheduling(Job arr[], int n){
        //sort in descending order of profit
        Arrays.sort(arr, (a,b)-> (b.profit-a.profit));

        int maxi=0;

        //find the maximum deadline
        for(int i=0; i<n; i++){
            if(arr[i].deadline>maxi){
                maxi=arr[i].deadline;
            }
        }

        int result[]= new int[maxi+1];

        //set each array index as -1 initially
        for(int i=1; i<=maxi; i++){
            result[i]=-1;
        }

        int countJobs=0, jobProfit=0;

        for(int i=0; i<n; i++){
            for(int j=arr[i].deadline; j>0; j--){
                if(result[j]==-1){
                    result[j]=i;
                    countJobs++;
                    jobProfit+=arr[i].profit;
                    break;
                }
            }
        }
        int ans[]=new int[2];
        ans[0]=countJobs;
        ans[1]=jobProfit;
        return ans;
    }

    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        int[] res= JobScheduling(arr, 4);
        System.out.println(res[0]+" "+res[1]);

    }
}
