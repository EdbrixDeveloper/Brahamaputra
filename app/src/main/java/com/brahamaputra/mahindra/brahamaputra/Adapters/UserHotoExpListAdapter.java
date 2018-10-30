package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.HotoListHeader;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoListTiketData;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.HashMap;
import java.util.List;

public class UserHotoExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<HotoListHeader> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<Object, List<HotoListTiketData>> _listDataChild;

    public UserHotoExpListAdapter(Context context, List<HotoListHeader> listDataHeader,
                                 HashMap<Object, List<HotoListTiketData>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final HotoListTiketData hotoListTiketData = (HotoListTiketData) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_user_hoto_list, null);
        }

        TextView textView_HotoName = (TextView) convertView.findViewById(R.id.textView_HotoName);
        TextView textView_SiteID = (TextView) convertView.findViewById(R.id.textView_SiteID);
        TextView textView_SiteAddress = (TextView) convertView.findViewById(R.id.textView_SiteAddress);

        textView_HotoName.setText(hotoListTiketData.getTiketId());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        HotoListHeader hotoListHeader = (HotoListHeader) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_user_hoto_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
        TextView textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

        textView_Date.setText(hotoListHeader.getHeaderName());
        textView_Date.setTypeface(null, Typeface.BOLD);

        textView_Count.setTypeface(null, Typeface.BOLD);
        textView_Count.setText(hotoListHeader.getHeaderCount());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
