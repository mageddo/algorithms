package urionlinejudge.iniciante.P1178;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by elvis on 09/07/21.
 */
public class Main {

	public static void main(String args[]) throws IOException {
		final var out = new BufferedOutputStream(System.out);
		final var in = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		double originalValue = Double.parseDouble(in.readLine()), currentValue = originalValue, previousValue = originalValue;

		for(; i < 100; i++){
			out.write(String.format("N[%d] = %.4f\n", i, currentValue).getBytes());
			currentValue = previousValue / 2;
			previousValue = currentValue;
		}
		out.flush();
	}
}
