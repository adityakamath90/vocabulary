package bwellthy.vocabulary.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import bwellthy.vocabulary.R;
import bwellthy.vocabulary.adapter.VocabAdapter;
import bwellthy.vocabulary.manager.VocabTable;
import bwellthy.vocabulary.persistence.DatabaseHelper;
import bwellthy.vocabulary.presenter.VocabPresenter;
import bwellthy.vocabulary.presenter.VocabPresenterImpl;
import bwellthy.vocabulary.utility.NetworkUtils;
import bwellthy.vocabulary.view.VocabView;

public class VocabularyActivity extends AppCompatActivity implements VocabView {

    private VocabPresenter mVocabPresenter;
    private DatabaseHelper mDatabaseHelper;
    private ProgressBar mProgressBar;
    private RecyclerView mWordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        initView();
        mVocabPresenter = new VocabPresenterImpl(this);
        mDatabaseHelper = DatabaseHelper.getInstance(this);
        if (NetworkUtils.isAvailable(this)) {
            initiateVocabApi();
        } else {
            NetworkUtils.displayNetworkDialog(this);
        }
    }

    private void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mWordList = (RecyclerView) findViewById(R.id.vocab_list);
        mWordList.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initiateVocabApi() {
        if (DatabaseHelper.getInstance(this).getAllWprds().isEmpty()) {
            mVocabPresenter.getVocabulary(mDatabaseHelper);
        } else {
            mVocabPresenter.getVocabFromDatabase(mDatabaseHelper);
        }
    }

    @Override
    public void setVocabListAdapter(List<VocabTable> wordList) {
        if (wordList != null) {
            mWordList.setAdapter(new VocabAdapter(wordList, VocabularyActivity.this));
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }
}
