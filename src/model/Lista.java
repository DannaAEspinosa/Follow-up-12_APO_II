package model;

public class Lista {
	private Node head;
	private Node tail;

	public void addLast(Node node) {
		if (head == null) {
			head = node;
			head.setNext(head);
			head.setPrev(head);
			
		} else {
			tail = head.getPrev();
			head.setPrev(node);
			tail.setNext(node);
			node.setNext(head);
			node.setPrev(tail);
			tail=node;
		}

	}

	public void moveTurn() {
		int dice = 1;
		Node personNode = findTurn(head);
		System.out.println("Nodo #" + personNode.getTurno());
		Person p = personNode.getPerson();

		int cAux = (personNode.getPerson().getCantTurns());
		cAux++;
		p.setCantTurns(cAux);
		boolean bandera = repeatTurn(p.getCantTurns());
		if (bandera == true) {
			p.setTurno(false);
			moveTurn(personNode, p, dice);

			System.out.println("Turno #" + personNode.getTurno() + "  Turno pasado numero # " + p.getCantTurns());

		} else {
			
			int x = personNode.getTurno();
			if(tail==head) {
				System.out.println("Es el unico turno, no se puede eliminar.Deberá agregar otro para poder eliminar este. ");
				return;
			}
			moveTurn(personNode, p, dice);
			p.setTurno(false);
			
			delete(x);
			
			

		}

	}
	public void delete(int value) {
		delete(head,value);
	}
	
	public void deleteCurrentShift() {
		Node personNode=findTurn(head);
		int value =personNode.getTurno();
		if(tail==head) {
			System.out.println("Es el unico turno, no se puede eliminar. Deberá agregar otro para poder eliminar este.");
			return;
		}
	
		delete(head, value);
		
	}

	private void moveTurn(Node current, Person person, int dice) {
		
		// Condición de parada
		if (dice == 0) {
			Person p = current.getPerson();
			p.setTurno(true);
			current.setPerson(p);
			return;
		}
		// Metodo recursivo
		moveTurn(current.getNext(), person, --dice);
	}

	private Node findTurn(Node current) {

		if (current.getPerson().isTurno() == true) {
			return current;
		}
		return findTurn(current.getNext());
	}

	private void delete(Node current, int value) {
		// Condición de parada

		if (current == null) {

			
			return;
		}
		
		if(value==head.getCounter() && value==tail.getCounter()&& current==head && current==tail) {
			head=null;
			tail=null;
		
		}

		if (value == head.getTurno() && current == head) {
			head.getNext().setPrev(tail);
			head = current.getNext();
			tail.setNext(head);
			System.out.println("Se eliminó el turno #" + value);
			return;
		}

		if (value == tail.getTurno() && current == tail) {
			
			tail.getPrev().setNext(head);
			tail = current.getPrev();
			head.setPrev(tail);
			
			System.out.println("Se eliminó el turno #" + value);
			return;

		}

		if (current.getTurno() == value) {
			
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
			System.out.println("Se eliminó el turno #" + value);
			
			return;

		}

		// Método recursivo
		delete(current.getNext(), value);

	}

	public boolean repeatTurn(int n) {
		boolean out;
		if (n < 3) {
			out = true;
		} else {
			out = false;
		}
		return out;
	}

	public void delete() {
		Node current = findTurn(head);
		int turnAct = current.getTurno();
		moveTurn(current, current.getPerson(),1);
		delete(head, turnAct);
	}

	public void printC() {
		Node nodeCurrent = findTurn(head);
		System.out.println("Current turn: " + nodeCurrent.getTurno());
	}

}
