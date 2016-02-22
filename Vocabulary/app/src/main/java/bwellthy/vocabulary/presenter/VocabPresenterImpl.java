package bwellthy.vocabulary.presenter;

import java.util.List;

import bwellthy.vocabulary.manager.VocabDatabaseListener;
import bwellthy.vocabulary.manager.VocabListener;
import bwellthy.vocabulary.manager.VocabTable;
import bwellthy.vocabulary.model.VocabInteractor;
import bwellthy.vocabulary.model.VocabInteractorImpl;
import bwellthy.vocabulary.network.Vocabulary;
import bwellthy.vocabulary.persistence.DatabaseHelper;
import bwellthy.vocabulary.view.VocabView;

public class VocabPresenterImpl implements VocabPresenter, VocabListener, VocabDatabaseListener {

    private VocabInteractor mVocabInteractor;
    private VocabView mVocabView;

    public VocabPresenterImpl(VocabView view) {
        mVocabInteractor = new VocabInteractorImpl();
        mVocabView = view;
    }


    @Override
    public void getVocabulary(DatabaseHelper helper) {
        mVocabView.showProgress();
        mVocabInteractor.getVocabulary(this, helper);
    }

    @Override
    public void getVocabFromDatabase(DatabaseHelper helper) {
        mVocabView.showProgress();
        mVocabInteractor.getVocabFromDatabase(helper, this);
    }

    @Override
    public void onVocabFetchedSucess(Vocabulary vocabulary, DatabaseHelper helper) {
        mVocabInteractor.insertIntoDatabase(vocabulary, this, helper);
    }

    @Override
    public void onVocabFailure() {
        mVocabView.hideProgress();

    }

    @Override
    public void onAddedToDbSuccessful(DatabaseHelper helper) {
        getVocabFromDatabase(helper);
    }

    @Override
    public void onGetWordsSuccesssful(List<VocabTable> wordList) {
        mVocabView.setVocabListAdapter(wordList);
        mVocabView.hideProgress();
    }

    @Override
    public void onDbFailure() {
        mVocabView.hideProgress();

    }

}
