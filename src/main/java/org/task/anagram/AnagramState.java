package org.task.anagram;

public class AnagramState {
    String prefix;
    String remaining;

    AnagramState(String prefix, String remaining) {
        this.prefix = prefix;
        this.remaining = remaining;
    }
}
