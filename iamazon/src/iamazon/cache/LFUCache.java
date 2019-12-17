package iamazon.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LFUCache {

	class CacheEntry {
		String data;
		int frequency = 0;

		CacheEntry(String data) {
			this.data = data;
		}

		public CacheEntry accessed() {
			this.frequency++;
			return this;
		}
	}

	int maxCapacity;
	LinkedHashMap<Integer, CacheEntry> cache = new LinkedHashMap<>();

	public LFUCache(int i) {
		this.maxCapacity = i;
	}

	public static void main(String[] args) {
		LFUCache ca = new LFUCache(4);
		ca.put(1, "aditya");

	}

	private void put(int key, String value) {
		if (!isFull()) {
			cache.put(key, new CacheEntry(value).accessed());
		} else {
			int minKey = getMinmumAccess();
			cache.remove(minKey);
			cache.put(key, new CacheEntry(value).accessed());
			
		}

	}

	public Integer getMinmumAccess() {
		Set<Entry<Integer, CacheEntry>> s = cache.entrySet();
		
		Iterator<Entry<Integer, CacheEntry>> itr = s.iterator();
		int min = Integer.MIN_VALUE;
		int key = 0;
		Entry<Integer, CacheEntry> e;
		while(itr.hasNext()) {
			e = itr.next();
			if(e.getValue().frequency < min) {
				
				min=e.getValue().frequency ;
				key=e.getKey();	
			}
		}
		
		return key;
	}

	public boolean isFull() {
		return (cache.size() == maxCapacity);
	}
}