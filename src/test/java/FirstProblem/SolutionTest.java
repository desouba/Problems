package FirstProblem;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isAnagramTest() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAnagram("anagram", "nagaram"));
        Assert.assertFalse(solution.isAnagram("anagram", "anagram1"));
        Assert.assertFalse(solution.isAnagram("anagram", "anagraa"));

    }
}