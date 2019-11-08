import java.util.*;

public class BinaryHeap {
	int[] data = new int[10];
	int size = 0;


	public void add(int priority){
		if(size==data.length) //grows the array by double, if the data exceeds the size
			grow_array();
		data[size++] = priority;
		int child = size-1;
		int parent = (child-1)/2;
		while(parent>=0 && data[parent]>data[child]){
			swap(data,parent,child);
			child = parent;
			parent = (child-1)/2;
		}
	}
	public void swap(int[] arr, int x, int y){ //swaps the position of two elements
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public int remove(){ //removes an element
		int temp = data[0];
		data[0] = data[--size];
		siftdown(0);
		return temp;
	}

	public void siftdown(int parent){ //this compares the children with the parent & then swaps them
		int child = parent*2 +1;
		if(child>=size)
			return;
		if((data[child]>data[child+1]) && (child+1<size))
			child+=1;
		if(data[parent]>data[child]){
			swap(data,parent,child);
			siftdown(child);
		}
	}
	public void grow_array(){ //grows the array by doubling it in size
		int[] new_arr = (int[]) (new int[data.length*2]);
		for(int i=0;i<data.length;i++)
			new_arr[i] = data[i];
		data = new_arr;
	}
}