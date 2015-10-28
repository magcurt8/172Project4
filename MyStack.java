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
public class MyStack<AnyType> implements Stack<AnyType> {
	public Node<AnyType> first;
	
	public boolean isEmpty() {
		if(first == null){
			return true;
		}
		return false;
	}
	
	public void push(AnyType x) {
		Node <AnyType> NewNode = new Node <AnyType>(x);
		NewNode.data = x;
		NewNode.next = first;
		first = NewNode;
	}
	
	public AnyType pop() {
		if(isEmpty() == false){
			Node<AnyType> temp = first;
			first = first.next;
			return temp.data;	
		}
		else
			return null;
	}
	
	public AnyType peek() {
		if(isEmpty()){
			return null;
		}
		else{
			return first.data;
		}
	}
	
	public void printStack() {
		Node<AnyType> x = first;
		while(x!=null) {
			System.out.println((x.data).toString());
			x= x.next;
		}
	}
}