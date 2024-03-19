/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rr
 */
public class SaveableDictionary {

    private Map<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.fileName = file;
    }

    public boolean load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    this.dictionary.put(parts[0].trim(), parts[1].trim());
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : this.dictionary.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void add(String words, String translation) {

        this.dictionary.putIfAbsent(words, translation);
    }

    public void delete(String word) {
        // delete the word if word matches
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        }
        // deletes the word if translation matches
        for (Map.Entry<String, String> entry : this.dictionary.entrySet()) {
            if (entry.getValue().equals(word)) {
                this.dictionary.remove(entry.getKey());
                break;
            }
        }
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.getOrDefault(word, null);
        }
        if (this.dictionary.containsValue(word)) {
            for (Map.Entry<String, String> entry : this.dictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

}
