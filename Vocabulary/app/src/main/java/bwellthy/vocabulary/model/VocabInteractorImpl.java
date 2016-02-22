package bwellthy.vocabulary.model;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.List;

import bwellthy.vocabulary.manager.VocabDatabaseListener;
import bwellthy.vocabulary.manager.VocabListener;
import bwellthy.vocabulary.manager.VocabTable;
import bwellthy.vocabulary.network.RestClient;
import bwellthy.vocabulary.network.Vocabulary;
import bwellthy.vocabulary.persistence.DatabaseHelper;
import bwellthy.vocabulary.utility.ImageUtils;
import retrofit2.Callback;
import retrofit2.Response;

public class VocabInteractorImpl implements VocabInteractor {

    @Override
    public void getVocabulary(final VocabListener vocabListener, final DatabaseHelper helper) {
        new RestClient().getVocabService().getVocabulary().enqueue(new Callback<Vocabulary>() {
            @Override
            public void onResponse(Response<Vocabulary> response) {
                if (response != null && response.isSuccess() && response.body() != null) {
                    vocabListener.onVocabFetchedSucess(response.body(), helper);
                } else {
                    vocabListener.onVocabFailure();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                vocabListener.onVocabFailure();
            }
        });
    }

    @Override
    public void insertIntoDatabase(Vocabulary vocabulary, VocabDatabaseListener listener,
                                   DatabaseHelper helper) {
        if (vocabulary != null) {
            List<VocabTable> words = vocabulary.getWords();
            CollectionUtils.filter(words, new Predicate() {
                public boolean evaluate(Object input) {
                    VocabTable table = (VocabTable) input;
                    return !ImageUtils.isNegativeAspectRatio(table.getRatio());

                }
            });
            if (words != null) {
                helper.insertWords(words);
            }
            listener.onAddedToDbSuccessful(helper);
        } else {
            listener.onDbFailure();
        }

    }

    @Override
    public void getVocabFromDatabase(DatabaseHelper helper, VocabDatabaseListener listener) {
        List<VocabTable> wordList = helper.getAllWprds();
        listener.onGetWordsSuccesssful(wordList);
    }
}
