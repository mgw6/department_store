/**
*The ItemInfoNode class implements the ItemInfoNode object
*that contains a reference to an ItemInfoObject as well as to two 
*other ItemInfoNode objects, referred to as prev and next.
*
* @author MacGregor Winegard
* 	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
*
* @version 1 Build 1 July 15, 2020
**/
public class ItemInfoNode
{
	private ItemInfo     info;
	private ItemInfoNode     prev;
	private ItemInfoNode     next;
	//invariants
	// Info is the current item
	// previous is the prvious item
	// next is the next item
	/**
	* Returns an instance of an ItemInfoNode
	*
	* @param i
	*	the current node, refered to as info
	*
	* @param p
	*	the previous info node, referred to as prev
	*
	* @ param n
	*	the next info node, referred to as next.
	**/
	public ItemInfoNode(ItemInfo i)
	{
		this.info = i;
		this.prev = null;
		this.next = null;
	}
	/**
	*gets the InfoNode objecet called info
	*
	* @returns
	*	the info InfoNode object
	**/
	public ItemInfo getInfo()
	{
		return this.info;
	}
	/**
	*sets the info InfoNode obj of the ItemInfoNode obj
	*
	* @param inInfo
	*	the info node we want to set as the info obj
	**/
	public void setInfo(ItemInfo inInfo)
	{
		this.info =  inInfo;
	}
	/**
	*gets the InfoNode objecet called prev
	*
	* @returns
	*	the prev InfoNode object
	**/
	public ItemInfoNode getPrev()
	{
		return this.prev;
	}
	/**
	*sets the prev InfoNode obj of the ItemInfoNode obj
	*
	* @param inPrev
	*	the info node we want to set as the prev obj
	**/
	public void setPrev(ItemInfoNode inPrev)
	{
		this.prev =  inPrev;
	}
	/**
	*gets the InfoNode objecet called next
	*
	* @returns
	*	the next InfoNode object
	**/
	public ItemInfoNode getNext()
	{
		return this.next;
	}
	/**
	*sets the next InfoNode obj of the ItemInfoNode obj
	*
	* @param inNext
	*	the info node we want to set as the next obj
	**/
	public void setNext(ItemInfoNode inNext)
	{
		this.next =  inNext;
	}
}// end class