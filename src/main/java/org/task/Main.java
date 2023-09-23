package org.task;

import org.task.anagram.AnagramFind;
import org.task.datasources.impl.DataSources;
import org.task.datasources.impl.FileSource;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        DataSources fileSource = new FileSource();
        AnagramFind anagramFind = new AnagramFind();

        String fileContent = fileSource.content("src/main/resources/input.txt");
        String[] words = fileContent.split("\n");
        for (String word : words) {
            List<String> anagrams = anagramFind.generateAnagrams(word);
            if (!anagrams.isEmpty()) {
                word = String.format("%s , %s", word, anagrams.get(0));
                fileSource.save("src/main/java/org/task/output/output4.txt",
                        word);
            }
        }
    }
}