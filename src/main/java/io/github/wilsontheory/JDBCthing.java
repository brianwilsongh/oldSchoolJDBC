package io.github.wilsontheory;

import io.github.wilsontheory.dao.DAOthing;

public class JDBCthing {
	public static void main(String[] args){
		Cat cat = new DAOthing().getCat(1);
		System.out.println(cat.getName() + " has been retrieved from the database");
	}
}
