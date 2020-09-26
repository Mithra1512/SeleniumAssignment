package org.system;

public class Desktop extends Computer {

	public void desktopSize() {
		System.out.println("Inside Desktop Size");

	}
	
	public static void main(String[] args) {
		
		Desktop obj = new Desktop();
		obj.desktopSize();
		obj.computerModel();
		

	}

}
