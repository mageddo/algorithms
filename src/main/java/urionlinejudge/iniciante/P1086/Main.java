package urionlinejudge.iniciante.P1086;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by elvis on 12/11/16.
 */
public class Main {

	private static final byte[] IMPOSSIVEL = "impossivel".getBytes();
	private static long START = System.nanoTime();

	public static void main(String[] args) throws IOException {

		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedOutputStream out = new BufferedOutputStream(System.out);

	/*
		dimensao do salao em metros  (1 ≤ N,M ≤ 104)
	*/
		int dimensaoX, dimensaoY;

	/*
		em cm (1 ≤ L ≤ 100)
	*/
		int larguraTabuas;

	/*
		(1 ≤ K ≤ 105)
	*/
		int tabuasDoadas;

	/*
		tamanho de cada tabua doada (1 ≤ Xi ≤ 104 para 1 ≤ i ≤ K)
	*/
		Integer[] tamanhoTabuasDoadas;
		String lastLine = in.readLine();
		do{

//			printEnd("start");

			final StringTokenizer dimensoes = new StringTokenizer(lastLine);

			// primeira linha
			dimensaoX = Integer.parseInt(dimensoes.nextToken());
			dimensaoY = Integer.parseInt(dimensoes.nextToken());

			// segunda linha
			larguraTabuas = new Integer(in.readLine());


			// terceira linha
			tabuasDoadas = new Integer(in.readLine());

			// quarta linha
			tamanhoTabuasDoadas = new Integer[tabuasDoadas];

			StringTokenizer boards = new StringTokenizer(in.readLine());
			int i=0, countTokens = boards.countTokens();
			for(; i < countTokens; i++){
				tamanhoTabuasDoadas[i] = new Integer(boards.nextToken());
			}

			float larguraTabuasMetro = larguraTabuas / 100.0f;

//			printEnd("in");

			Arrays.sort(tamanhoTabuasDoadas);

//			printEnd("sort");

			int r1 = calcQtdTabuas(tabuasDoadas, tamanhoTabuasDoadas,
				larguraTabuasMetro, dimensaoX, dimensaoY);
			int r2 = calcQtdTabuas(tabuasDoadas, tamanhoTabuasDoadas, larguraTabuasMetro, dimensaoY, dimensaoX);

//			printEnd("calc");

			if(r1 > -1 && r2 > -1){
				out.write(Integer.toString(r1 < r2 ? r1 : r2).getBytes());
				out.write('\n');
			}else if(r1 > -1 || r2 > -1){
				out.write(Integer.toString(r1 > r2 ? r1 : r2).getBytes());
				out.write('\n');
			}else{
				out.write(IMPOSSIVEL);
				out.write('\n');
			}

//			printEnd("out");

		}while(!(lastLine = in.readLine()).equals("0 0"));

		out.flush();
	}

	static int calcQtdTabuas(int tabuasDoadas, Integer[] tamanhoTabuasDoadas, float larguraTabuasMetro, int dimensaoX, int dimensaoY){

		if(dimensaoX * 100 % (int)(larguraTabuasMetro * 100) != 0){
			return -1;
		}

		int qtdTabuas = 0, qtdTabuasLargura = 0, qtdTabuasNecessariasLargura = (int) (dimensaoX / larguraTabuasMetro),
			lastIndex = 0;
		for(int i=tabuasDoadas-1; i >= 0; i--){
			int tabua = tamanhoTabuasDoadas[i], resto = dimensaoY - tabua;
			if(resto > 0 && lastIndex < i){
				for(int j=lastIndex; j < i; j++){
					if(resto == tamanhoTabuasDoadas[j]){
						lastIndex = j+1;
						qtdTabuas += 2;
						qtdTabuasLargura++;
						break;
					}
				}

			}else if(resto == 0){
				qtdTabuas++;
				qtdTabuasLargura++;
			}
			if(qtdTabuasLargura == qtdTabuasNecessariasLargura)return qtdTabuas;
		}
		return -1;
	}

//	static void printEnd(String msg){
//		System.out.printf("\t\t%s=%d\n", msg, System.nanoTime() - START);
//		START = System.nanoTime();
//	}
}
