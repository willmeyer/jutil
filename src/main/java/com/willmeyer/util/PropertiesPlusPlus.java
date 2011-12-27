package com.willmeyer.util;

import java.util.*;

/**
 * Super simple props help.
 */
public class PropertiesPlusPlus extends Properties {
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	public static class PropertyException extends Exception {
		
		private static final long serialVersionUID = 7526472295622776147L;
		
		protected String propName;
		
		public PropertyException(String propertyName) {
			super("Missing or invalid property '" + propertyName + "'");
			this.propName = propertyName;
		}
		
		public String getPropName() {
			return propName;
		}
	}
	
	public boolean getBooleanProperty(String name, boolean dflt) {
		boolean val = dflt;
		try {
			String strVal = this.getProperty(name);
			val = Boolean.parseBoolean(strVal);
		} catch (Exception e) {}
		return val;
	}

	public boolean getBooleanPropertyRequired(String name) throws PropertyException {
		boolean val;
		try {
			String strVal = getPropertyRequired(name);
			val = Boolean.parseBoolean(strVal);
		} catch (Exception e) {
			throw new PropertyException(name);
		}
		return val;
	}

	public String getPropertyRequired(String name) throws PropertyException {
		String strVal;
		strVal = this.getProperty(name);
		if ((strVal == null) || (strVal.trim().length() == 0)) {
			throw new PropertyException(name);
		}
		return strVal.trim();
	}
	
	public int getIntProperty(String name, int dflt) {
		int val = dflt;
		try {
			val = Integer.parseInt(this.getProperty(name));
		} catch (Exception e) {}
		return val;
	}

	public int getIntPropertyRequired(String name) throws PropertyException {
		int val;
		try {
			val = Integer.parseInt(this.getPropertyRequired(name));
		} catch (Exception e) {
			throw new PropertyException(name);
		}
		return val;
	}
}
