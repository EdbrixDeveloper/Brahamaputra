package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketList;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicket;
import com.brahamaputra.mahindra.brahamaputra.R;
import java.util.List;

public class UserHotoExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<HotoTicketsDate> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HotoTicketList hotoTicketList;
    /*import java.util.HashMap;
    private HashMap<Object, List<HotoTicket>> _listDataChild;

    public UserHotoExpListAdapter(Context context, List<HotoTicketsDate> listDataHeader,
                                  HashMap<Object, List<HotoTicket>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }*/

    public UserHotoExpListAdapter(Context _context, HotoTicketList hotoTicketList) {
        this._context = _context;
        this.hotoTicketList = hotoTicketList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return hotoTicketList.getHotoTicketsDates().get(groupPosition).getHotoTickets().get(childPosititon);
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return Long.parseLong(hotoTicketList.getHotoTicketsDates().get(groupPosition).getHotoTickets().get(childPosition).getId());
//        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final HotoTicket HotoTicket = (HotoTicket) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_user_hoto_list, null);
        }

        TextView textView_HotoName = (TextView) convertView.findViewById(R.id.textView_HotoName);
        TextView textView_SiteID = (TextView) convertView.findViewById(R.id.textView_SiteID);
        TextView textView_SiteName = (TextView) convertView.findViewById(R.id.textView_SiteName);
        TextView textView_SiteAddress = (TextView) convertView.findViewById(R.id.textView_SiteAddress);
        TextView textView_SiteSSA = (TextView) convertView.findViewById(R.id.textView_SiteSSA);

        textView_HotoName.setText(HotoTicket.getHotoTicketNo());
        textView_SiteID.setText("Site Id: " + HotoTicket.getSiteId());
        textView_SiteName.setText("Site Name: " + HotoTicket.getSiteName());
        textView_SiteAddress.setText("Site Address: " + HotoTicket.getSiteAddress());
        textView_SiteSSA.setText("Site SSA: " + HotoTicket.getSsaName());

        if(HotoTicket.getStatus().equalsIgnoreCase("WIP")){
            convertView.setBackgroundColor(ContextCompat.getColor(_context,R.color.yellow));
        }else{
            convertView.setBackgroundColor(ContextCompat.getColor(_context,R.color.colorWhite));
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hotoTicketList.getHotoTicketsDates().get(groupPosition).getHotoTickets().size();
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return hotoTicketList.getHotoTicketsDates().get(groupPosition);
//        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return hotoTicketList.getHotoTicketsDates().size();
//        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        HotoTicketsDate HotoTicketsDate = (HotoTicketsDate) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_user_hoto_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
        TextView textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

        textView_Date.setText(HotoTicketsDate.getDate());
        textView_Date.setTypeface(null, Typeface.BOLD);

        textView_Count.setTypeface(null, Typeface.BOLD);
        textView_Count.setText(""+HotoTicketsDate.getHotoTicketCount());

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