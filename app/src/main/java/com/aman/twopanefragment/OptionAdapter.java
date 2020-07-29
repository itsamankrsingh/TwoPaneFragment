package com.aman.twopanefragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ViewHolder> {

    private List<OptionalList> listItems;
    private Context context;
    private OnOptionListener mOnOptionListener;


    public OptionAdapter(List<OptionalList> listItems, Context context,OnOptionListener onOptionListener) {
        this.listItems = listItems;
        this.context = context;
        this.mOnOptionListener=onOptionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view,mOnOptionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OptionalList list = listItems.get(position);
        holder.background.setText(list.getBackground());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView background;
        OnOptionListener onOptionListener;

        public ViewHolder(@NonNull View itemView,OnOptionListener onOptionListener) {
            super(itemView);
            background = itemView.findViewById(R.id.txtCardView);
            this.onOptionListener=onOptionListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onOptionListener.OnOptionClick(getAdapterPosition());
        }
    }


    public interface OnOptionListener {
        public void OnOptionClick(int position);
    }
}
