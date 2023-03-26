package app;

import business.UserBL;

public class UserView {

	public static void main(String[] args) {
		UserBL ubl = new UserBL();
		System.out.println(ubl.getUserById(2));
	}

}
