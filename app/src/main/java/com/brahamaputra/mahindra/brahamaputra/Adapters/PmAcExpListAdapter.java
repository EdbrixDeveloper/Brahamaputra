package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.AcSitePMTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMACTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePmAcTicketList;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.List;

public class PmAcExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<SitePMTicketsDate> _listDataHeader; // header titles
    // child data in format of header title, child title
    private SitePmAcTicketList hotoTicketList;


    public PmAcExpListAdapter(Context _context, SitePmAcTicketList hotoTicketList) {
        this._context = _context;
        this.hotoTicketList = hotoTicketList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return hotoTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return Long.parseLong(hotoTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().get(childPosition).getId());
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final AcSitePMTicket AcSitePMTicket = (AcSitePMTicket) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_site_pm_ticket_list, null);
        }

        TextView textView_pmSiteName = (TextView) convertView.findViewById(R.id.textView_pmSiteName);
        TextView textView_SiteID = (TextView) convertView.findViewById(R.id.textView_SiteID);
        TextView textView_SiteName = (TextView) convertView.findViewById(R.id.textView_SiteName);
        TextView textView_SiteAddress = (TextView) convertView.findViewById(R.id.textView_SiteAddress);
        TextView textView_SiteSSA = (TextView) convertView.findViewById(R.id.textView_SiteSSA);

        textView_pmSiteName.setText(AcSitePMTicket.getSitePMAcTicketNo());
        textView_SiteID.setText("Site ID: " + AcSitePMTicket.getSiteId());
        textView_SiteName.setText("Site Name: " + AcSitePMTicket.getSiteName());
        textView_SiteAddress.setText("Site Address: " + AcSitePMTicket.getSiteAddress());
        textView_SiteSSA.setText("Site SSA: " + AcSitePMTicket.getSSAName());

        if (AcSitePMTicket.getStatus().equalsIgnoreCase("WIP")) {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.yellow));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.colorWhite));
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hotoTicketList.getSitePMTicketsDates().get(groupPosition).getSitePMAcTickets().size();
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return hotoTicketList.getSitePMTicketsDates().get(groupPosition);
//        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return hotoTicketList.getSitePMTicketsDates().size();
//        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        SitePMACTicketsDate SitePMACTicketsDate = (SitePMACTicketsDate) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_site_pm_ticket_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
        TextView textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

        textView_Date.setText(SitePMACTicketsDate.getTicketDate());
        textView_Date.setTypeface(null, Typeface.BOLD);

        textView_Count.setTypeface(null, Typeface.BOLD);
        textView_Count.setText("" + SitePMACTicketsDate.getSitePMAcTicketCount());

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