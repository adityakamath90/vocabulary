package bwellthy.vocabulary.network;

public class Word {

    private Integer id;
    private String word;
    private Integer variant;
    private String meaning;
    private Double ratio;


    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word The word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return The variant
     */
    public Integer getVariant() {
        return variant;
    }

    /**
     * @param variant The variant
     */
    public void setVariant(Integer variant) {
        this.variant = variant;
    }

    /**
     * @return The meaning
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * @param meaning The meaning
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    /**
     * @return The ratio
     */
    public Double getRatio() {
        return ratio;
    }

    /**
     * @param ratio The ratio
     */
    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }


}