package src.LinkedListPractice;

public class LinkedList {
	Node head;
	public class Node{
		int data;
		Node next;		
	}
	public void delete(int data)
	{
		Node node = head;
		if(node!=null &&node.data==data)
		{
			head=node.next;
			System.out.println("node deleted");
		}
		Node prev=null;
		while(node!=null &&  node.data!=data)
		{
			prev=node;
			node=node.next;
		}
		if(node!=null)
		{
			prev.next=node.next;
			
		}
		if(node==null)
			System.out.println("List empty");

		
	}
	public void insert(int data)
	{
		Node node = new Node();
		node.data=data;
		node.next=null;
		if(head==null)
			head=node;
		else
		{
			Node n=head;
			while(n.next!=null)
			{
				n=n.next;
			}
			n.next=node;
		}	
	}
	
	public void show()
	{
		Node n=head;
		while(n.next!=null)
		{	System.out.println(n.data);
			n=n.next;
		}
		System.out.println(n.data);
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insert(5);
		list.insert(10);
		list.insert(12);
		list.insert(15);
		list.insert(30);
		list.delete(5);
		//list.delete(5);
		//list.delete(30);
		list.show();
	}
}
