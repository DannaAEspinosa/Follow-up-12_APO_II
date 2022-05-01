package model;

public class Person {

	private boolean turno;
	private int cantTurns;
	

	

	public int getCantTurns() {
		return cantTurns;
	}

	public void setCantTurns(int cantTurns) {
		this.cantTurns = cantTurns;
	}

	public Person(boolean turno) {
		super();
		this.turno = turno;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	
	
	
	
}
