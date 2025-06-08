package BinarySearch;

public class MedianOfTwoSortedArrays {
    //Brute Force  TC:O(n1+n2) SC:O(n1+n2)
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1=arr1.length;
        int n2=arr2.length;
        
        int[] arr3= new int[n1+n2];

        int i=0, j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]) arr3[i+j]=arr1[i++];
            else arr3[i+j]=arr2[j++];
        }
        while(i<n1) arr3[i+j]=arr1[i++];
        while(j<n2) arr3[i+j]=arr2[j++];
        int n= n1+n2;
        if(n%2==1) return arr3[n/2];

        return (double)((double)(arr3[n/2]+(double)(arr3[n/2-1]))/2.0);
    }

    //Better Approach   TC:O(n1+n2) SC:O(1)
    public static double findMedianSortedArrays2(int[] arr1, int[] arr2) {
        int n1=arr1.length;
        int n2=arr2.length; 
        int n=(n1+n2);
        int i=0, j=0;
        int ind2=n/2;
        int ind1=ind2-1;
        int cnt=0;

        int ind1el=-1, ind2el=-1;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                if(cnt==ind1) ind1el=arr1[i];
                if(cnt==ind2) ind2el=arr1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1) ind1el=arr2[j];
                if(cnt==ind2) ind2el=arr2[j];
                cnt++;
                j++;
            }
        }
        while(i<n1){
            if(cnt==ind1) ind1el=arr1[i];
            if(cnt==ind2) ind2el=arr1[i];
            cnt++;
            i++;
        }
        while(j<n2){
            if(cnt==ind1) ind1el=arr2[j];
            if(cnt==ind2) ind2el=arr2[j];
            cnt++;
            j++;
        }
        if(n%2==1) return ind2el;                         //for odd
        return (double)((double)(ind1el+ind2el)/2.0);    //for even
    }
  
    //Optimal approach  TC:O(log(min(n1,n2))) sc:O(1)
    public static double findMedianSortedArrays3(int[] arr1, int[] arr2) {
        int n1=arr1.length;
        int n2=arr2.length;
        if(n1>n2) return findMedianSortedArrays3(arr2, arr1);
        int low=0, high=n1;
        int left=(n1+n2+1)/2;
        int n=n1+n2;

        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;                                                                                         
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            
            if(mid1<n1) r1=arr1[mid1];
            if(mid2<n2) r2=arr2[mid2];
            if(mid1>0) l1=arr1[mid1-1];
            if(mid2>0) l2=arr2[mid2-1];

            if(l1<=r2 && l2<=r1){
                if(n%2==1) return Math.max(l1,l2);
                return (double)((double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0);
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr1={1, 4, 7, 10, 12};
        int[] arr2={2, 3, 6, 15};
        System.out.println(findMedianSortedArrays(arr1,arr2));
        System.out.println(findMedianSortedArrays2(arr1,arr2));
        System.out.println(findMedianSortedArrays3(arr1,arr2));
    }
}
