package com.willmeyer.util;

public final class Delay {
	
	private Delay() {}
	
	public static void delay(long ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {}
	}
	
}
