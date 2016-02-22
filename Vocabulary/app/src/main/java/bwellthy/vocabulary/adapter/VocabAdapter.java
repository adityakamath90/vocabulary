package bwellthy.vocabulary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bwellthy.vocabulary.R;
import bwellthy.vocabulary.manager.VocabTable;
import bwellthy.vocabulary.utility.ImageUtils;

public class VocabAdapter extends RecyclerView.Adapter<VocabAdapter.VocabViewHolder> {

    private List<VocabTable> mVocabList;
    private LayoutInflater mInflater;

    public VocabAdapter(List<VocabTable> dealList, Context context) {
        mVocabList = dealList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public VocabAdapter.VocabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.vocab_item, parent, false);
        VocabViewHolder viewHolder = new VocabViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VocabAdapter.VocabViewHolder holder, int position) {

        Context context = mInflater.getContext();
        VocabTable word = mVocabList.get(position);

        if (!TextUtils.isEmpty(word.getWord()) && !TextUtils.isEmpty(word.getMeaning()) &&
                !ImageUtils.isNegativeAspectRatio(word.getRatio())) {
            holder.mText.setText(context.getString(R.string.title, word.getWord(), word
                    .getMeaning()));

        }
    }

    @Override
    public int getItemCount() {
        return ((mVocabList != null) ? mVocabList.size() : 0);
    }

    static class VocabViewHolder extends RecyclerView.ViewHolder {

        private TextView mText;

        public VocabViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.vocab_name);
        }
    }
}