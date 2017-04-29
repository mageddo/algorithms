package mageddo.lrucache.v1;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 11/8/16 11:37 AM
 */
public class LRUCacheImpl implements LRUCache {

	private final int capacity;
	protected Map<Integer, Node> cache = new LinkedHashMap<>();

	public LRUCacheImpl(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int get(int key) {
		if(cache.containsKey(key)){
			final Node node = cache.get(key);
			node.count++;
			return node.value;
		}
		return -1;
	}

	@Override
	public void set(int key, int val) {

		if (cache.size() >= capacity && !cache.containsKey(key)) {

			Node lessUsed = null;
			for (Node n : cache.values()) {
				if(lessUsed == null || lessUsed.count > n.count){
					lessUsed = n;
				}
			}
			if(lessUsed!=null){
				cache.remove(lessUsed.key);
			}

		}
		cache.put(key, new Node(key, val));
	}
}

class Node {
	int count;
	int key;
	int value;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.count = 0;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder()//
			.append("Node [")//
			.append("count=")//
			.append(count)//
			.append(",key=")//
			.append(key)//
			.append(",value=")//
			.append(value)//
			.append("]");
		return builder.toString();
	}
}
