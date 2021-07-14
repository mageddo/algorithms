package urionlinejudge.iniciante.P1180;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by elvis on 09/07/21.
 */
public class Main {

  private static final BufferedOutputStream out = new BufferedOutputStream(System.out);
  private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String args[]) throws IOException {

    final var numbers = Integer.parseInt(in.readLine());
    final var tokenizer = new StringTokenizer(in.readLine());

    int lowest = Integer.MAX_VALUE, pos = 0;

    for (int i = 0; tokenizer.hasMoreTokens(); i++) {
      final var v = Integer.parseInt(tokenizer.nextToken());
      if (v < lowest) {
        lowest = v;
        pos = i;
      }
    }

    out.write(String.format("Menor valor: %d\nPosicao: %d\n", lowest, pos).getBytes());
    out.flush();

  }

}
