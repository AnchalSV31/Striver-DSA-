package ARRAY.Hard.Array_24_25_26;

public class FindMissingRepeatingNumbers {
    public static void main(String[] args) {
        int[] a={3,1,2,5,4,6,7,5};
        //int[] ans = findMissingRepeatingNumbers(a);
        //int[] ans = findMissingRepeatingNumbers2(a);
        //int[] ans = findMissingRepeatingNumbers3(a);
        int[] ans = findMissingRepeatingNumbers4(a);
        System.out.println("The repeating number is: {"+ans[0]+", "+ans[1] +"}");
    }

    //Brute Force
    public static int[] findMissingRepeatingNumbers(int[] a){
        int n= a.length;
        int repeating = -1, missing=-1;
        //find the repeating and missing number:
        for(int i=1; i<=n ;i++){
            //count the occurences:
            int cnt=0;
            for(int j=0; j<n; j++){
                if(a[j]==i) cnt++;
            }
            if(cnt==2) repeating=i;
            else if(cnt==0) missing=i;

            if(repeating!=-1 && missing!=-1) break;
        }
        int[] ans={repeating, missing};
        return ans;
    }
    
    //Better Approach[Using Hashing]
    public static int[] findMissingRepeatingNumbers2(int[] a){
        int n=a.length;
        int[] hash=new int[n+1];
        
        //update the hash array:
        for(int i=0; i<n; i++){
            hash[a[i]]++;
        }

        //find the repeating ans missing number:
        int repeating=-1, missing=-1;
        for(int i=1; i<=n; i++){
            if(hash[i]==2) repeating=i;
            else if(hash[i]==0) missing=i;

            if(repeating!=-1 && missing!=-1) break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }

    //Optimal approach[Using Maths]
    public static int[] findMissingRepeatingNumbers3(int[] a){
        long n=a.length;
        //Find Sn and S2n:
        long SN = n*(n+1)/2;
        long S2N = n*(n+1)*(2*n+1)/6;

        //calculate S an S2:
        long S=0, S2=0;
        for(int i=0; i<n; i++){
            S+=a[i];
            S2+=(long)a[i]*(long)a[i];
        }

        //S=Sn=X-Y
        long val1=S-SN;

        //S2-S2n=X^2-Y^2:
        long val2=S2-S2N;

        //Find X+Y=(X^2-Y^2)/(X-Y):
        val2=val2/val1;

        //Find X-Y: X=((X+Y)+(X-Y))/2 and Y=X-(X-Y),
        //here, X-Y=val1 and X+Y=val2:
        long x=(val1+val2)/2;
        long y=x-val1;

        int[] ans={(int)x, (int)y};
        return ans;
    }

    //Optimal Approach 2[Using XOR]
    public static int[] findMissingRepeatingNumbers4(int[] a){
        int n=a.length;
        int xor=0;

        //Step 1: Find XOR of all elements
        for(int i=0; i<n; i++){
            xor^=a[i];
            xor^=(i+1);
        }

        //STEP 2: find the differentiating bit number
        int number=(xor & ~(xor-1));

        //Step 3: Group the numbers:
        int zero=0;
        int one=0;
        for(int i=0; i<n; i++){
            //part of 1 group:
            if((a[i] & number)!=0){
                one=one^a[i];
            }
            //part of 0 group:
            else{
                zero=zero^a[i];
            }
        }
        for(int i=1; i<=n; i++){
            //part of 1 group:
            if((i & number)!=0){
                one =one^i;
            }
            //part of 0 group:
            else{
                zero=zero^i;
            }
        }

        //last step: Identify the numbers:
        int cnt=0;
        for(int i=0; i<n; i++){
            if(a[i]==zero) cnt++;
        }
        if(cnt==2) return new int[]{zero, one};
        return new int[]{one, zero};
    }
}