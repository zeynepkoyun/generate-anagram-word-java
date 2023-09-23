import org.task.anagram.AnagramFind;
import org.junit.Assert;
import org.junit.Test;

public class AnagramFindTest {
    @Test
    public void testIsAnagram(){
        System.out.println("Start testGenerateAnagrams() and testIsAnagram()... ");
        AnagramFind anagramFind = new AnagramFind();
        String word = "anagram";
        String findAnagramWord = anagramFind.generateAnagrams(word).get(0);
        boolean isAnagram = anagramFind.isAnagram(word,findAnagramWord);

        Assert.assertEquals(isAnagram, true);
        System.out.println("Sonuç: " + isAnagram);
        System.out.println("End testGenerateAnagrams() and testIsAnagram()...");
    }

}
