package com.hamit.designpattern.creation;

import lombok.extern.java.Log;

@Log
public class Deneme {

	public static void main(String[] args) {
		
		int sayi=6;
		if(sayi==5) {
			System.out.println("sayi 4");
			log.info("sayi 4");
		}else {
			log.warning("sayý 5 farklý");
		}
	}
}
