package bwellthy.vocabulary.manager;

import bwellthy.vocabulary.network.Vocabulary;
import bwellthy.vocabulary.persistence.DatabaseHelper;

public interface VocabListener {
    void onVocabFetchedSucess(Vocabulary vocabulary, DatabaseHelper helper);

    void onVocabFailure();
}