package iamazon.logical.arrays;

public class MinHeap {

	static int[] HEAP;
	static int maxHeapSize;
	static int heapSize;

	public static void initialize(int size) {
		maxHeapSize = size;
		HEAP = new int[maxHeapSize];
		heapSize = 0;
	}

	static void insert(int k) {
		if (maxHeapSize == heapSize) {
			return;
		}

		// First insert the new key at the end
		heapSize++;
		int i = heapSize - 1;
		HEAP[i] = k;

		// Fix the min heap property if it is violated
		while (i != 0 && HEAP[getParent(i)] > HEAP[i]) {
			swap(i, getParent(i));
			i = getParent(i);
		}
	}

	static void swap(int i, int p) {
		int tmp = HEAP[i];
		HEAP[i] = HEAP[p];
		HEAP[p] = tmp;
	}

	static int getLeftChild(int p) {
		return 2 * p + 1;
	}

	static int getRightChild(int p) {
		return 2 * p + 2;
	}

	static int getParent(int c) {
		return (c - 1) / 2;
	}

	public static void main(String[] args) {
		initialize(6);
		insert(4);
		insert(3);
		insert(2);
		insert(6);
		insert(10);

		int firstMin = 0;
		int secondMin = 0;
		int price = 0;
		while(heapSize>0) {	
			firstMin = extractMinElement();
			secondMin = extractMinElement();
			price += firstMin + secondMin;
			if(heapSize == 0)
				break;
			insert(firstMin + secondMin);
			secondMin = firstMin = 0;
			
		}
		
		System.out.println(price);
		int[] a = { 4, 3, 2, 6, 10 };
		convertToMinHeap(a, 4);
		print();
	}

	static int extractMinElement() {
		if(heapSize == 0)
			return 0;
		int minElement = HEAP[0];
		//move last element into first position
		HEAP[0] = HEAP[heapSize-1];
		//decrease the heap size
		heapSize--; 
		minHeapify(0);
		return minElement;
	}

	private static void convertToMinHeap(int[] a, int sz) {
		HEAP = a;
		heapSize = sz;

		for (int p = (heapSize - 1) / 2; p >= 0; p--)
			minHeapify(p);
	}

	static boolean isLeaf(int pos) {
		if (pos >= (heapSize / 2) && pos <= heapSize)
			return true;

		return false;
	}

	static void minHeapify(int p) {
		int left = getLeftChild(p);
		int right = getRightChild(p);

		int smallest = p;
		if (left < heapSize && HEAP[p] > HEAP[left]) {
			smallest = left;
			swap(p, smallest);
			minHeapify(smallest);
		}

		if (right < heapSize && HEAP[p] > HEAP[right]) {
			smallest = right;
			swap(p, smallest);
			minHeapify(smallest);
		}

	}

	private static void print() {
		for (int i : HEAP) {
			System.out.println(i);
		}
	}

}
