package bwellthy.vocabulary.manager;

import java.util.List;

import bwellthy.vocabulary.persistence.DatabaseHelper;

public interface VocabDatabaseListener {
    void onAddedToDbSuccessful(DatabaseHelper helper);

    void onGetWordsSuccesssful(List<VocabTable> wordList);

    void onDbFailure();
}
