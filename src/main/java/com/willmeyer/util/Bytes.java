package com.willmeyer.util;

public class Bytes {

	public static int toInt(byte b) {
		return (int)(0x000000FF & b);
	}
	
	/**
	 * Converts a four byte sequence into an int.
	 */
	public static int toInt(byte[] bytes) {
		int value = 0;
		int offset = 0;
	    for (int i = 0; i < 4; i++) {
	        int shift = (4 - 1 - i) * 8;
	        value += (bytes[i + offset] & 0x000000FF) << shift;
	    }
		return value;
	}
	
	public static String debugByte(byte b) {
		String theChar = ("" + (char)b).trim();
		String str = "0x" +  byteAsText(b) + " / '" + theChar + "' ";
		return str;
	}

	/**
	 * Converts a byte to a zero-padded hex string.
	 */
	public static String byteAsText(byte b) {
		return Integer.toString( ( b & 0xff ) + 0x100, 16 /* radix */ ).substring( 1 ).toUpperCase();
	}
	
	public static String debugBytes(byte[] bytes) {
		String str = "\r\n";
		for (int i = 0; i < bytes.length; i++) {
			str += ("[" + i + ": " + debugByte(bytes[i]) + "]\r\n");
		}
		return str;
	}
	
}
