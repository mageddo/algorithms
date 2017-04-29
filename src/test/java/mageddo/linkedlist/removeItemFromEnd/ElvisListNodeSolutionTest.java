package mageddo.linkedlist.removeItemFromEnd;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 11/8/16 3:34 PM
 */
public class ElvisListNodeSolutionTest {

	@Test
	public void removeNthFromEnd() throws Exception {

		// montando a lista
		ListNode head = new ListNode(1);
		ListNode curr=head;
		for(int i=2; i <= 5; i++){
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		// removendo e validando
		final Solution solution = getInstance();
		Assert.assertEquals("val=1, val=2, val=3, val=4, val=5, ", head.toString());

		head = solution.removeNthFromEnd(head, 2);
		Assert.assertEquals("val=1, val=2, val=3, val=5, ", head.toString());

		head = solution.removeNthFromEnd(head, 3);
		Assert.assertEquals("val=1, val=3, val=5, ", head.toString());

		head = solution.removeNthFromEnd(head, 1);
		Assert.assertEquals("val=1, val=3, ", head.toString());

		head = solution.removeNthFromEnd(head, 2);
		Assert.assertEquals("val=3, ", head.toString());

		head = solution.removeNthFromEnd(head, 0);
		Assert.assertEquals("val=3, ", head.toString());

		head = solution.removeNthFromEnd(head, 1);
		Assert.assertNull(head);

	}

	@Test
	public void removeNthFromEnd2() throws Exception {

		// montando a lista
		ListNode head = new ListNode(1);
		ListNode curr=head;
		for(int i=2; i <= 2; i++){
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		// removendo e validando
		final Solution solution = getInstance();
		Assert.assertEquals("val=1, val=2, ", head.toString());

		head = solution.removeNthFromEnd(head, 0);
		Assert.assertEquals("val=1, val=2, ", head.toString());

		head = solution.removeNthFromEnd(head, 2);
		Assert.assertEquals("val=2, ", head.toString());

	}

	@Test
	public void removeNthFromEndRemovingLast() throws Exception {

		// montando a lista
		ListNode head = new ListNode(1);
		ListNode curr=head;
		for(int i=2; i <= 2; i++){
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		// removendo e validando
		final Solution solution = getInstance();
		Assert.assertEquals("val=1, val=2", head.toString());

		head = solution.removeNthFromEnd(head, 1);
		Assert.assertEquals("val=1", head.toString());

	}


	private ElvisListNodeSolution getInstance() {
		return new ElvisListNodeSolution();
	}


}