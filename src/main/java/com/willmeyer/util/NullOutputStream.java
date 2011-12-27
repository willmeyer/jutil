package com.willmeyer.util;

import java.io.IOException;
import java.io.OutputStream;

/**
 * A simple stupid null output stream.
 */
public class NullOutputStream extends OutputStream {

	@Override
	public void write(int b) throws IOException {
	}

}
