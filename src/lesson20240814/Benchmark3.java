package lesson20240814;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Benchmark3 {
	
	private static final int PROTEIN_SIZE = 10_000;
	private static final int LIBRARY_SIZE = 100_000;
	static final byte[] ALPHABET = new byte[26];
	
	static {
		for (byte c = 'A'; c <= 'Z'; c++) {
			ALPHABET[c-'A'] = c;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Benchmark 3");
		System.out.println("generating data...");
		
		String protein = generateProtein(PROTEIN_SIZE);
		List<String> library = generateLibrary(LIBRARY_SIZE);
		long start1 = System.currentTimeMillis();
		Peptides3 peptides = new Peptides3(Peptides3.DEFAULT_PEPTIDE_SIZE, protein, library);
		long stop1 = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop1 - start1));

		
		System.out.println("searching peptides...");
		long start = System.currentTimeMillis();
		peptides.findPositionsInProtein();
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
		
		
	}

	static String generateProtein(int proteinSize) {
		Random r = new Random();
		var data = new byte[proteinSize];
		for (int i = 0; i < proteinSize; i++) {
			data[i] = ALPHABET[r.nextInt(ALPHABET.length)];
		}
		return new String(data);
	}

	private static List<String> generateLibrary(int librarySize) {
		var library = new ArrayList<String>(librarySize);
		for (int i = 0; i < librarySize; i++) {
			var peptide = generateProtein(PROTEIN_SIZE);
			library.add(peptide);
		}
		return library;
	}


}
