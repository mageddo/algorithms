package utils;

import java.io.InputStream;

/**
 * Created by elvis on 28/04/17.
 */
public final class TestUtils {

	public static InputStream getResource(String resource){
		return TestUtils.class.getResourceAsStream(resource);
	}

	public static InputStream getURIResource(String resource){
		return TestUtils.class.getResourceAsStream("/urionlinejudge" + resource);
	}
}
