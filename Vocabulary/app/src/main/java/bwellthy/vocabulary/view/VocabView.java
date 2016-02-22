package bwellthy.vocabulary.view;

import java.util.List;

import bwellthy.vocabulary.manager.VocabTable;

public interface VocabView {
    void setVocabListAdapter(List<VocabTable> wordList);

    void showProgress();

    void hideProgress();
}
