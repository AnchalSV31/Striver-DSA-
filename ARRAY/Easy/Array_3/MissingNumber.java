package ARRAY.Easy.Array_3;

public class MissingNumber {
    public static void main(String args[]) {
        int N = 5;
        int a[] = {1, 2, 4, 5};

        //int ans = missingNumber(a, N);
        //int ans2 = missingNumber2(a, N);
        //int ans3 = missingNumber3(a, N);
        int ans4 = missingNumber4(a, N);
        System.out.println("The missing number is: " + ans4);
    }
    
    //BRUTE FORCE
    public static int missingNumber(int []a, int N){
        for(int i=1; i<=N; i++){
            int flag=0;
            for(int j=0; j<N-1; j++){
                if(a[j]==i){
                    //i is present in the array
                    flag=1;
                    break;
                }
            }
            //check if the element is missing, i.e flag==0
            if(flag==0){
                return i;
            }
        }
        return -1;
    }

    //Better approach
    public static int missingNumber2(int a[], int N){
        int hash[] = new int[N+1];
        for(int i=0; i<N-1; i++){
            hash[a[i]]++;
        }
        for(int i=1; i<N; i++){
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }

    //optimal approach
    //TYPE 1(SUM)
    public static int missingNumber3(int a[], int N){
        int sum=(N*(N+1))/2;
        int S2=0;
        for(int i=0; i<N-1; i++){
            S2+=a[i];
        }
        int missingNum = sum-S2;
        return missingNum;
    }

    //TYPE 2(XOR)
    public static int missingNumber4(int a[], int N){
        int xor1=0, xor2=0;

        for(int i=0; i<N-1; i++){
            xor2=xor2^a[i];    //xor of arry elements
            xor1=xor1^(i+1);  //xor upto [1....N-1]
        }
        xor1=xor1^N;   //xor upto [1....N]
        return (xor1^xor2); //missing number
    }
}
