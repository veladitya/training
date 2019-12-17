package iamazon.cache;

/* We can use Java inbuilt Deque as a double 
ended queue to store the cache keys, with 
the descending time of reference from front 
to back and a set container to check presence 
of a key. But remove a key from the Deque using 
remove(), it takes O(N) time. This can be 
optimized by storing a reference (iterator) to 
each key in a hash map. */
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

	public static Deque<String> dq;
	HashSet<String> set;

	int cacheSize;

	public LRUCache(int i) {
		dq = new LinkedList<>();
		set = new HashSet<>();
		cacheSize = i;
	}

	// display contents of cache
	public void display() {
		Iterator<String> itr = dq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4);
		ca.refer("1");
		ca.refer("2");
		ca.refer("3");
		ca.refer("4");
		ca.refer("5");
		ca.refer("5");
		ca.display();
	}

	private void refer(String i) {		
		if(!set.contains(i)) {
			if(dq.size() == cacheSize) {
				String last = dq.removeLast();
				set.remove(last);
			}
		}else {
			Iterator<String> itr = dq.iterator();
			
			int index = 0, j=0;
			while(itr.hasNext()) {
				if(itr.next().equalsIgnoreCase(i)) {
					index = j; 
				}
				j++;
			}
			
			dq.remove(index);			
		}
		dq.push(i);
		set.add(i);
	}
}
// This code is contributed by Gaurav Tiwari 
