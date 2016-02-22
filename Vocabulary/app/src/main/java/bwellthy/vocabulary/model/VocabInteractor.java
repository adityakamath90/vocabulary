package bwellthy.vocabulary.model;

import bwellthy.vocabulary.manager.VocabDatabaseListener;
import bwellthy.vocabulary.manager.VocabListener;
import bwellthy.vocabulary.network.Vocabulary;
import bwellthy.vocabulary.persistence.DatabaseHelper;

public interface VocabInteractor {
    void getVocabulary(VocabListener vocabListener, DatabaseHelper helper);

    void insertIntoDatabase(Vocabulary vocabulary, VocabDatabaseListener listener, DatabaseHelper
            helper);

    void getVocabFromDatabase(DatabaseHelper helper, VocabDatabaseListener listener);
}
