package mageddo.lrucache.v1;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 11/8/16 11:19 AM
 */
public interface LRUCache {

	int get(final int key);
	void set(final int key, final int val);
}
