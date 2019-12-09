package PIM;

import java.io.Serializable;
import java.util.*;

/*
 *@author:17130110034
 *@author:牛年 
 *@author:1310140596@qq.com
 */

public class PIMCollection implements Collection<PIMEntity>,Serializable{
	private static final long serialVersionUID=1L;
	private class Node<E> implements Serializable{
		private static final long serialVersionUID=1L;
		PIMEntity element;
		Node next;		//后一结点
		Node prev;		//前一结点
		Node(PIMEntity p){
			next=null;
			prev=null;
			element=p;
		}
	}
	
	private int size=0;			//结点的数量
	private Node head=null;			//头结点
	private Node last=null;			//尾结点
	
	public PIMCollection() {
		head=new Node(null);
		last=new Node(null);
		head.next=last;
		last.prev=head;
		size=0;
	}
	
	public PIMCollection getNotes() {
		PIMCollection c = new PIMCollection();
		if(size==0)
			return null;
		for(Node x=head.next;x!=null;x=x.next) {
			if((x.element.getClass().getName()).equals("PIM.PIMNote"))
				c.add(x.element);
		}
		return c;
	}
	
	public PIMCollection getTodos() {
		PIMCollection c = new PIMCollection();
		if(size==0)
			return null;
		for(Node x=head.next;x!=null;x=x.next) {
			if((x.element.getClass().getName()).equals("PIM.PIMTodo"))
				c.add(x.element);
		}
		return c;
	}
	
	public  PIMCollection getAppointments() {
		PIMCollection c = new PIMCollection();
		if(size==0)
			return null;
		for(Node x=head.next;x!=null;x=x.next) {
			if((x.element.getClass().getName()).equals("PIM.PIMAppointment"))
				c.add(x.element);
		}
		return c;
	}
	
	public PIMCollection getContact() {
		PIMCollection c = new PIMCollection();
		if(size==0)
			return null;
		for(Node x=head.next;x!=null;x=x.next) {
			if((x.element.getClass().getName()).equals("PIM.PIMContact"))
				c.add(x.element);
		}
		return c;
	}
	
	public PIMCollection getItensForDate(Date d) {
		PIMCollection c = new PIMCollection();
		if(size==0)
			return null;
		String date=d.toString();
		for(Node x=head;x!=null;x=x.next) {
			if(x.element.getDate().equals(date));
				c.add(x.element);
		}
		return c;
	}
	
	@Override
	public boolean add(PIMEntity p) {
		if(size==0)
			last.element=p;
		else {
			Node temp=new Node(p);
			temp.prev=last;
			last.next=temp;
			last=temp;
		}
		size++;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends PIMEntity> c) {
		for(PIMEntity p:c){
			add(p);
		}
		return true;
	}

	@Override
	public void clear() {
		head.next=last;
		last.element=null;
		size=0;
	}

	@Override
	public boolean contains(Object o) {
		for(Node x=head;x!=null;x=x.next) {
			if(o.equals(x.element))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o:c) {
			if(!contains(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if(size==0)	
			return true;
		return false;
	}
	
	@Override
	public Iterator<PIMEntity> iterator() {
		Iterator<PIMEntity> it=new Iterator<PIMEntity>() {
			int count=0;
			Node x=head;
			@Override
			public PIMEntity next() {
				count++;
				x=x.next;
				return x.element;				
			}			
			@Override
			public boolean hasNext() {
				return count<size;				
			}
		};
		return it;
	}

	@Override
	public boolean remove(Object o) {
		for(Node x=head;x!=null;x=x.next) {
			if(o.equals(x.element)) {
				(x.prev).next=x.next;
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o:c) {
			if(!remove(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for(Object temp:c) 
			if(contains(temp))
				return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] obj=new Object[size];
		Node x=head.next;
		for(int i=0; i<size && x!=null; i++,x=x.next) {
			obj[i]=x.element;
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] t) {
		Object[] obj=new Object[size];
		if(t.length<size) 
			t = (T[])java.lang.reflect.Array.newInstance(t.getClass().getComponentType(), size);
		int i = 0;
	    Object[] result = t;
	    for (Node x = head.next; x != null && i<size; x = x.next,i++)
	        result[i] = x.element;
	    if (t.length > size)
	        t[size] = null;
	    return t;
	}
	
	public static void main(String args[]) {
		PIMCollection pc=new PIMCollection();
		List<PIMEntity> list=new ArrayList<PIMEntity>();

		PIMAppointment pa=new PIMAppointment("this is appointment","2019-09-10");
		PIMContact pct=new PIMContact("niu", "nian", "1310140596@qq.com");
		PIMNote pn=new PIMNote("this is pimnote");
		PIMTodo pt=new PIMTodo("this is pimtodo", "2020-12-12");

		list.add(pn);
		list.add(pt);
		
		PIMCollection temp1=pc.getTodos();
		if(temp1==null)
			System.out.println("empty collection!");
		
		pc.add(pa);
		pc.add(pct);
		pc.addAll(list);
		
		
		System.out.println("--------------------");
		System.out.println("pc包含"+pc.size()+"个元素");
		System.out.println("\n--------contains测试--------");		
		if(pc.contains(pa))
			System.out.println("pc包含PIMAppointment");
		if(pc.containsAll(list))
			System.out.println("pc包含列表list");

		
		System.out.println("\n------get测试---------");
		PIMCollection cc;
		System.out.println("-----PIMAppointments-----");
		cc=pc.getAppointments();
		for(PIMEntity temp:cc) {
			System.out.println(temp.toString());
		}
		System.out.println("-----PIMContact-----");
		cc=pc.getContact();
		for(PIMEntity temp:cc) {
			System.out.println(temp.toString());
		}
		System.out.println("-------PIMNotes-------");
		cc=pc.getNotes();
		for(PIMEntity temp:cc) {
			System.out.println(temp.toString());
		}
		System.out.println("--------PIMTodos--------");
		cc=pc.getTodos();
		for(PIMEntity temp:cc) {
			System.out.println(temp.toString());
		}
		
		
		Object[] obj=pc.toArray();
		System.out.println("\n------toArray测试1-------");
		for(Object o:obj) {
			try {
				System.out.println(((PIMEntity)o).toString());
			}
			catch(NullPointerException n) {
				System.out.println(n);
			}
		}

		pc.remove(pa);
		
		PIMEntity[] pe = new PIMEntity[2];
		pe=pc.toArray(pe);
		System.out.println("\n------remove测试及toArray测试2--------");
		for(PIMEntity p:pe) {
			try {
				System.out.println(p.toString());
			}
			catch(NullPointerException n) {
				System.out.println(n);
			}
		}

		pc.removeAll(list);
		
		Iterator<PIMEntity> it=pc.iterator();
		System.out.println("\n------removeAll测试及Iterator测试--------");
		while(it.hasNext()) {
			PIMEntity temp=it.next();
			System.out.println(temp.toString());
		}
	}
}
