package ro.ase.acs.main;

import ro.ase.acs.models.Meeting;

public class Main {

	public static void main(String[] args) {
		//Playground
		//here you can test your code manually
		Meeting meeting1 = new Meeting("Meeting1", 9, 22);
		meeting1.setParticipants(new String[]{"Robert", "Madalina", "Georgiana"});
		Meeting meeting2 = new Meeting("Meeting2", 10, 10);
		meeting2.setParticipants(new String[]{"Robert", "Ionelia", "Georgiana"});
		meeting1.concatenate(meeting2);

		meeting1.print();
	}

}
