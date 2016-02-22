package bwellthy.vocabulary.presenter;

import bwellthy.vocabulary.persistence.DatabaseHelper;

public interface VocabPresenter {
    void getVocabulary(DatabaseHelper helper);

    void getVocabFromDatabase(DatabaseHelper helper);
}
