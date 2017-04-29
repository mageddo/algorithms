package mageddo.linkedlist.removeItemFromEnd;




/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 11/8/16 2:13 PM
 */
public class ElvisListNodeSolution implements Solution {
	@Override
	public ListNode removeNthFromEnd(ListNode head, int n) {

		if(n == 0){
			return head;
		}

		ListNode toRemove = head;
		ListNode curr=head;
		int i=0;
		for(; curr != null; i++, curr = curr.next){
			if(i > n){
				toRemove = toRemove.next;
			}
		}
		if(i == n){
			return toRemove.next;
		}

		if(toRemove.next == null){
			return null;
		}
		toRemove.next = toRemove.next.next;
		return head;
	}

}
