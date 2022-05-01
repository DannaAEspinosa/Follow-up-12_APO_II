package model;

public class Node {
	
	private Person person;
	private int turno;
	public  int counter;
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		counter = counter;
	}
	//enlaces
	private Node prev;
	private Node next;
	//Constructor
	
	public Node(int turno,Person person) {
		super();
		this.turno = turno;
		this.person = person;
		counter=0;
	}
	
	//Getters and setters.
	

	
	public Node(int i) {
		// TODO Auto-generated constructor stub
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
