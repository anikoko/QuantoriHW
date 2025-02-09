package lesson20240814;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PeptidesTest1 {

	private Peptides1 peptides1;
	private String peptide;
	private String protein;

	@Before
	public void setup() {
		peptide = "RNLKDGHI";
		protein = "ABERNLKDGHIHWEPOGCVNWOORNLKDGHIMXVNXMCWERY";
		var library = List.of(peptide, "ORNLKDGH", "ABCDEFGH");
		peptides1 = new Peptides1(Peptides1.DEFAULT_PEPTIDE_SIZE, protein, library);
	}
	
	@Test
	public void test() {
		List<Integer> positions = peptides1.search(peptide);
		assertTrue(positions.contains(3));
		assertTrue(positions.contains(23));
	}
	
	@Test
	public void testKMersExistAndFilledCorrectly() throws Exception {
		assertNotNull(peptides1.kmers);
		assertEquals(34, peptides1.kmers.size());
	}
	
	@Test
	public void testSpecificKMerExistsAtTwoPositions() throws Exception {
		assertEquals(List.of(3, 23), peptides1.kmers.get(peptide));
	}
	
	@Test
	public void testSearchLibraryPeptidesIsEmpty() throws Exception {
		peptides1 = new Peptides1(Peptides1.DEFAULT_PEPTIDE_SIZE, protein, List.of("HELLO", "BELLO"));
		Map<String, List<Integer>> existingPeptides = peptides1.searchLibrary();
		assertNotNull(existingPeptides);
		assertTrue(existingPeptides.isEmpty());
	}

	@Test
	public void testSearchLibraryPeptides() throws Exception {
		Map<String, List<Integer>> existingPeptides = peptides1.searchLibrary();
		assertNotNull(existingPeptides);
		assertEquals(2, existingPeptides.size());
	}
	
	@Test
	public void testAlphabetInit() throws Exception {
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", new String(Benchmark1.ALPHABET));
	}
	
}









