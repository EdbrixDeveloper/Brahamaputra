package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import java.util.ArrayList;
import java.util.TreeSet;

public class UserHotoListAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<String> mData = new ArrayList<String>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    private LayoutInflater mInflater;

    public UserHotoListAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final String item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.item_user_hoto_list, null);
                    holder.textView_HotoName = (TextView) convertView.findViewById(R.id.textView_HotoName);
                    holder.textView_SiteID = (TextView) convertView.findViewById(R.id.textView_SiteID);
                    holder.textView_SiteAddress = (TextView) convertView.findViewById(R.id.textView_SiteAddress);

                    holder.textView_HotoName.setText(mData.get(position));
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.item_user_hoto_list_seprator, null);
                    holder.textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
                    holder.textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

                    holder.textView_Date.setText(mData.get(position));
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.textView.setText(mData.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public TextView textView_Date;
        public TextView textView_Count;

        public TextView textView_HotoName;
        public TextView textView_SiteID;
        public TextView textView_SiteAddress;

    }
}