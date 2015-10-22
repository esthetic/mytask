package com.thecabine.sample.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thecabine.sample.R;
import com.thecabine.sample.domain.Item;
import com.thecabine.sample.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 10/21/15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder> {
    private List<Item> mItemList = new ArrayList<>();
    private Context mContext;
    private OnDetailItemClicked mListener;

    public interface OnDetailItemClicked {
        void onClick(Item item);
    }

    public ListAdapter(OnDetailItemClicked listener, Context context) {
        mContext = context;
        mListener = listener;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bindView(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mItemList == null)
            return 0;
        return mItemList.size();
    }

    public void setData(List<Item> items) {
        mItemList = items;
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.icon) CircleImageView mIcon;
        @Bind(R.id.title) TextView mTitle;
        @Bind(R.id.short_description) TextView mShortDescription;

        Item mCurrentItem;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(mCurrentItem);
                }
            });
        }

        public void bindView(Item item) {
            mCurrentItem = item;
            mTitle.setText(item.getTitle() != null ? item.getTitle() : "N/A");
            mShortDescription.setText(item.getShortDescription() != null ? item.getShortDescription() : "N/A");

            Picasso.with(mContext)
                    .load(item.getSmallImageUrl())
                    .placeholder(R.drawable.ic_insert_photo_grey600_48dp)
                    .error(R.drawable.ic_insert_photo_grey600_48dp)
                    .into(mIcon);
        }
    }
}
