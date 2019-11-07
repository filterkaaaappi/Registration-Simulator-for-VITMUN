package com.cypher.dbms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DelegateListAdapter extends RecyclerView.Adapter<DelegateListAdapter.DelegateViewHolder> {

    class DelegateViewHolder extends RecyclerView.ViewHolder {
        private final TextView delegateItemView;

        private DelegateViewHolder(View itemView) {
            super(itemView);
            delegateItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Delegate> mDelegate;

    DelegateListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public DelegateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new DelegateViewHolder(itemView);
    }

    @NonNull
    @Override


    public void onBindViewHolder(DelegateViewHolder holder, int position) {
        if (mDelegate != null) {
            Delegate current = mDelegate.get(position);
            holder.delegateItemView.setText(current.getmDelegate());
        } else {
            // Covers the case of data not being ready yet.
            holder.delegateItemView.setText("No delegate");
        }
    }

    void setDelegates(List<Delegate> delegates){
        mDelegate = delegates;
        notifyDataSetChanged();
    }

    // mDelegate has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDelegate != null)
            return mDelegate.size();
        else return 0;
    }
    public Delegate getPosition(int position){
        return mDelegate.get(position);
    }
}
