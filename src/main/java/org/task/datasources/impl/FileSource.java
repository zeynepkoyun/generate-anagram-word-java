package org.task.datasources.impl;

import org.task.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSource implements DataSources {
    Logger logger = Logger.getLogger(Main.class.getName());

    @Override
    public String content(String sourceName) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(sourceName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File Read Error!", e);
        }
        return fileContent.toString();
    }

    @Override
    public boolean save(String sourceName, String anagramWord) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sourceName, true))) {
            writer.write(anagramWord);
            writer.newLine();
            return true;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File Write Error!", e);
            return false;
        }
    }
}
