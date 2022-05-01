package main;

import java.util.Scanner;

import model.Lista;
import model.Node;
import model.Person;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Lista list = new Lista();
	static int counter=0;

	public static void main(String[] args) {
		

		

		boolean flag = false;

		do {
			int option = menu();
			chooseOption(option);
			if (option == 0) {
				flag = true;
			}
		} while (!flag);

	}

	public static int menu() {
		System.out.println("0. Close application \n" + "1.Give turn \n" + "2. Show turn \n" + "3. Pass turn \n"
				+ "4. Delete current shift");

		int input = sc.nextInt();
		return input;
	}

	public static void chooseOption(int input) {
		switch (input) {
		case 0:
			System.out.println("Closing the application");
			break;
		case 1:
			GiveTurn();
			break;
		case 2:list.printC();
			break;
		case 3:list.moveTurn();
			break;
		case 4:list.deleteCurrentShift();
			break;
		}

	}
	
	public static void GiveTurn() {
		counter++;
		if (counter==1) {
			Node node=new Node(counter, new Person(true));
			list.addLast(node);
		}else {
			Node node =new Node(counter, new Person(false));
			list.addLast(node);
		}
	
		System.out.println("Se agregó el turno #"+counter);
		
			
		
	}
	
	public static void delete() {
		list.delete();
		list.printC();
	}
	
	
}
