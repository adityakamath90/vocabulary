package bwellthy.vocabulary.manager;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import bwellthy.vocabulary.utility.Constants;

@DatabaseTable(tableName = Constants.VOCAB_TABLE)
public class VocabTable {

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String word;

    @DatabaseField
    private String meaning;

    @DatabaseField
    private Integer variant;

    @DatabaseField
    private Double ratio;

    public Integer getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public Integer getVariant() {
        return variant;
    }

    public Double getRatio() {
        return ratio;
    }
}
