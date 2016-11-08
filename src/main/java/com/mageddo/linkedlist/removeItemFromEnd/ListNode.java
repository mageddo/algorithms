package com.mageddo.linkedlist.removeItemFromEnd;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 11/8/16 2:11 PM
 */
public class ListNode {

	public int val;
	public ListNode next;
	public ListNode(int x){
		val = x;
	}

	@Override
	public String toString() {
		return String.format("val=%d, %s", this.val, next != null ? String.valueOf(next) : "");
	}
}
