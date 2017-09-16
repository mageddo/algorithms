package utils;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by elvis on 28/04/17.
 */
public final class TestUtils {

	public static InputStream getResource(String resource) {
		return TestUtils.class.getResourceAsStream(resource);
	}

	public static InputStream getResource(Class clazz, String resource) {
		final String pkg = clazz.getPackage().getName();
		return TestUtils.class.getResourceAsStream("/" + pkg.replaceAll("\\.", "/") + resource);
	}

	public static String getResourceAsString(Class clazz, String resource) throws IOException {
		return IOUtils.toString(getResource(clazz, resource));
	}

	public static InputStream getURIResource(String resource) {
		return TestUtils.class.getResourceAsStream("/urionlinejudge" + resource);
	}

	public static ByteArrayOutputStream setAndGetOut() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return out;
	}

	public static void writeToIn(byte[] bytes) {
		System.setIn(new ByteArrayInputStream(bytes));
	}

}
