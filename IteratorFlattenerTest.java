import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Sheshagiri
 *
 */
public class IteratorFlattenerTest {
	@Test
	public void testStringsFlattener() {
		List<String> words1 = Arrays.asList("sup1", "sup2", "sup3");
		List<String> words2 = Arrays.asList("sup4");
		List<String> words3 = Arrays.asList("sup5", "sup6", "sup7");
		List<String> expectedList = Arrays.asList("sup1", "sup2", "sup3", "sup4", "sup5", "sup6", "sup7");
		List<Iterator<String>> words = Arrays.asList(words1.iterator(), words2.iterator(), words3.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(words.iterator());
		List<String> flatList = new ArrayList<String>();
		while (flat.hasNext()) {
			flatList.add(flat.next());
		}
		Assert.assertEquals(expectedList, flatList);
	}
	@Test
	public void testIntegersFlattener() {
		List<Integer> numList1 = Arrays.asList(1,2,3);
		List<Integer> numList2 = Arrays.asList(5,6,7,8);
		List<Integer> numList3 = Arrays.asList(4);
		List<Integer> numList4 = Arrays.asList(10,20);
		List<Integer> expectedList = Arrays.asList(1,2,3,5,6,7,8,4,10,20);
		List<Iterator<Integer>> numListItr = Arrays.asList(numList1.iterator(),numList2.iterator(),numList3.iterator(),numList4.iterator());
		IteratorFlattener<Integer> flat = new IteratorFlattener<>(numListItr.iterator());
		List<Integer> flatList = new ArrayList<Integer>();
		while (flat.hasNext()) {
			flatList.add(flat.next());
		}
		Assert.assertEquals(expectedList, flatList);
	}
}
