package lesson20240814;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Peptides3 {

	public static final int DEFAULT_PEPTIDE_SIZE = 8;
	public static final int DEFAULT_RADIX = 36;

	private String protein;
	private int peptideSize;

	HashMap<Long, List<Integer>> peptides;

	public Peptides3(int peptideSize, String protein, List<String> peptidesList) {
		this.peptideSize = peptideSize;
		this.protein = protein;
		this.peptides = mapPeptides(peptidesList);
	}

	private HashMap<Long, List<Integer>> mapPeptides(List<String> peptidesList) {
		peptides = new LinkedHashMap<Long, List<Integer>>();
		for (String peptide : peptidesList) {
			Long value = stringToLong(peptide);
			peptides.put(value, null);
		}
		return peptides;
	}

	void findPositionsInProtein() {
		for (int i = 0; i < protein.length() - peptideSize + 1; i++) {
			String kmer = protein.substring(i, i + peptideSize);
			Long kmerLong = stringToLong(kmer);
			if (isPeptide(kmerLong)) {
				List<Integer> positions = peptides.get(kmerLong);
				if (positions == null) {
					positions = new ArrayList<>();
					peptides.put(kmerLong, positions);
				}
				positions.add(i);
			}
		}
//		System.out.println(peptides);
	}

	public boolean isPeptide(long kmer) {
		return peptides.containsKey(kmer);
	}

	public List<Integer> search(String peptide) {
		Long value = stringToLong(peptide);
		return peptides.getOrDefault(value, List.of());
	}

	private long stringToLong(String str) {
		long longValue = 0;
		for (char c : str.toCharArray()) {
			longValue += (long) c;
		}
		return longValue;
	}

}
