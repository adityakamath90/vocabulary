package bwellthy.vocabulary.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwellthy.vocabulary.manager.VocabTable;

public class Vocabulary {

    private Integer version;
    private List<VocabTable> words = new ArrayList<>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version The version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return The words
     */
    public List<VocabTable> getWords() {
        return words;
    }

    /**
     * @param words The words
     */
    public void setWords(List<VocabTable> words) {
        this.words = words;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}