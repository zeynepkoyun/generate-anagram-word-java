package org.task.datasources.impl;

public interface DataSources {
    String content(String sourceName);

    boolean save(String sourceName, String anagramWord);
}
