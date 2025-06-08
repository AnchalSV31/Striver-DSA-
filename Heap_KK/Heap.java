package Heap_KK;
import java.util.*;

public class Heap {
    private ArrayList<Integer> list;

    public Heap(){
        list=new ArrayList<>();
    }

    private void swap(int first, int second){
        int temp= list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    //Everything according to 0-indexing
    private int parent(int index){
        return (index-1)/2;
    }

    private int left(int index){
        return 2*index+1;
    }

    private int right(int index){
        return 2*index+2;
    }

    public void insert(int value){
        list.add(value);
        upHeap(list.size()-1);
    }

    //Min Heap
    private void upHeap(int index){
        if(index==0){
            return;
        }
        int p=parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index, p);
            upHeap(p);
        }
    }

    public int remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("removing from an empty heap!");
        }
        int temp=list.get(0);
        int last=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }
        return temp;
    }

    
    private void downHeap(int index){   
        int min=index;
        int left=left(index);
        int right=right(index);

        if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=index){
            swap(min, index);
            downHeap(min);
        }
    }

    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        while(!list.isEmpty()) {
          data.add(this.remove());
        }
        return data;
    }

    public static void main(String[] args) throws Exception{
        Heap heap = new Heap();
    
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        //remove min ele
        // System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    
    }
}
