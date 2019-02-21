package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTicketList;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransaction;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransactionList;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketList;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.List;

public class EbSiteElectrificationExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<EbSiteElectrificationTransaction> _listDataHeader; // header titles
    // child data in format of header title, child title
    private EbSiteElectrificationTicketList ebSiteElectrificationTicketList;

    public EbSiteElectrificationExpListAdapter(Context _context, EbSiteElectrificationTicketList ebSiteElectrificationTicketList) {
        this._context = _context;
        this.ebSiteElectrificationTicketList = ebSiteElectrificationTicketList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return Long.parseLong(ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().get(childPosition).getId());
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final EbSiteElectrificationTransactionList EbSiteElectrificationTransactionList = (EbSiteElectrificationTransactionList) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_eb_site_electrification_list, null);
        }

        TextView textView_EbSiteElectrificationTicket = (TextView) convertView.findViewById(R.id.textView_EbSiteElectrificationTicket);
        TextView textView_SiteID = (TextView) convertView.findViewById(R.id.textView_SiteID);
        TextView textView_SiteName = (TextView) convertView.findViewById(R.id.textView_SiteName);
        TextView textView_SiteAddress = (TextView) convertView.findViewById(R.id.textView_SiteAddress);
        TextView textView_SiteSSA = (TextView) convertView.findViewById(R.id.textView_SiteSSA);

        textView_EbSiteElectrificationTicket.setText(EbSiteElectrificationTransactionList.getEbSiteElectrificationTicketNo());
        textView_SiteID.setText("Site Id: " + EbSiteElectrificationTransactionList.getSiteId());
        textView_SiteName.setText("Site Name: " + EbSiteElectrificationTransactionList.getSiteName());
        textView_SiteAddress.setText("Site Address: " + EbSiteElectrificationTransactionList.getSiteAddress());
        textView_SiteSSA.setText("Site SSA: " + EbSiteElectrificationTransactionList.getSsaName());

        /*if (EbSiteElectrificationTransactionList.getStatus().equalsIgnoreCase("WIP")) {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.yellow));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.colorWhite));
        }*/
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition).getEbSiteElectrificationList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return ebSiteElectrificationTicketList.getEbSiteElectrificationTransaction().size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        EbSiteElectrificationTransaction EbSiteElectrificationTransaction = (EbSiteElectrificationTransaction) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_eb_site_electrification_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
        TextView textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

        textView_Date.setText(EbSiteElectrificationTransaction.getDate());
        textView_Date.setTypeface(null, Typeface.BOLD);

        textView_Count.setTypeface(null, Typeface.BOLD);
        textView_Count.setText("" + EbSiteElectrificationTransaction.getEbSiteElectrificationTicketCount());

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