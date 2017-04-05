package com.test1.controller;

import java.util.Random;

public class CommonController {
	public static int generateRandomNum(){
		int min,max;
		min=1;
		max=9;
		Random r = new Random();
		int val = r.nextInt((max - min)+1)+min;
		//System.out.println(val);
		return val;
	}

}
