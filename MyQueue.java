/*
 *InfixPostfixCalculator
 *Version 1.0
 *Copyright Margaret M. Curtis
 *CSC 172 Spring 2015
 *Margaret M. Curtis
 *MW 2-3:15PM
 *Partners: Scott Onestak, Elias Davis
 *Last Revised: March 7, 2015
 */
public class MyQueue<AnyType> implements Queue<AnyType>
{
	private DNode<AnyType> first;
	private DNode<AnyType> last;

	public MyQueue()
	{
		first = new DNode <AnyType>(null);
		last = new DNode <AnyType>(null);
		first.prev = null;
		first.next = last;
		last.prev = first;
		last.next = null;
	}

	public boolean isEmpty() 
	{
		if(first.data == null && last.data == null)
		{
			return true;
		}
		return false;
	}

	public void enqueue(AnyType x){
		if(isEmpty()){
			first.data = x;
			last = first;
		}
		else{	
			DNode <AnyType> temp = last;
			last = new DNode<AnyType>(x);
			last.data = x;
			last.next = null;
			last.prev = temp;
			temp.next = last;
		}
	}
	public AnyType dequeue(){
		if(isEmpty() == false){
			AnyType data = first.data;
			if(first.next == null){
				first.data = null;
				last = first;
			}
			else{
				first = first.next;
				first.prev = null;
			}
			return data;
		}
		else
			return null;
		}
	public AnyType peek(){return first.data;}
	public void printQueue(){
		DNode<AnyType> front = first;
		while(front!=null){
			System.out.println(front.data.toString());
			front = front.next;
		}
	}
}