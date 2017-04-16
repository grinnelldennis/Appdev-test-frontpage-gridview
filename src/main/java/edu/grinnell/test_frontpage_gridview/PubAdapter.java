package edu.grinnell.test_frontpage_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @uahtor Dennis Chan on 4/15/2017.
        */

public class PubAdapter extends BaseAdapter {

    private class Publication {
        String mName;
        int mImageLink;
        boolean mIsFavorite;
        public Publication (String name, int link, boolean fav){
            mName = name; mImageLink = link; mIsFavorite = fav;
        }
    }

    ArrayList<Publication> mPublications;
    Context mContext;

    // Constructor
    public PubAdapter(Context c) {
        mPublications = new ArrayList<>();
        mContext = c;
        populateArrayTest();
    }

    private void populateArrayTest() {
        String[] pubNames = {"S&B", "The GUM", "B&S"};
        int[] pubImages = {R.drawable.sandb, R.drawable.thegum, R.drawable.bands};
        boolean[] isFavorited = {true, false, true};
        for (int i = 0; i < pubNames.length; i++) {
            mPublications.add(new Publication(pubNames[i], pubImages[i], isFavorited[i]));
        }
    }

    public int getCount() { return mPublications.size(); }
    public Object getItem (int i) { return mPublications.get(i); }
    public long getItemId (int i) { return i; }

    class ViewHolder {
        ImageView mImageView;
        ImageView mStar;
        TextView mTextView;
        public ViewHolder (View v) {
            mImageView = (ImageView) v.findViewById(R.id.cardPubImage);
            mStar = (ImageView) v.findViewById(R.id.cardPubFavorite);
            mTextView = (TextView) v.findViewById(R.id.cardPubName);
        }
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.pseudo_card_view, viewGroup, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else { holder = (ViewHolder) row.getTag(); }

        if (mPublications.get(position).mIsFavorite) holder.mStar.setImageResource(R.drawable.star);
        holder.mImageView.setImageResource(mPublications.get(position).mImageLink);
        holder.mTextView.setText(mPublications.get(position).mName);

        return row;

    }


}
