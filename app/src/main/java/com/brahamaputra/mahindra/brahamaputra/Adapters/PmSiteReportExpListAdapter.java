package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportListData;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMTicketsList;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.List;

public class PmSiteReportExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<SitePMReportTicketsDate> _listDataHeader; // header titles
    // child data in format of header title, child title
    private SitePMReportListData hotoTicketList;


    public PmSiteReportExpListAdapter(Context _context, SitePMReportListData hotoTicketList) {
        this._context = _context;
        this.hotoTicketList = hotoTicketList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return hotoTicketList.getSitePMReportTicketsDates().get(groupPosition).getSitePMReportTickets().get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return Long.parseLong(hotoTicketList.getSitePMReportTicketsDates().get(groupPosition).getSitePMReportTickets().get(childPosition).getId());
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final SitePMReportTicket SitePMReportTicket = (SitePMReportTicket) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_site_pm_report_list, null);
        }

        TextView textView_reportSiteName = (TextView) convertView.findViewById(R.id.textView_reportSiteName);
        TextView textView_reportSiteId = (TextView) convertView.findViewById(R.id.textView_reportSiteId);
        TextView textView_reportLastTicketNo = (TextView) convertView.findViewById(R.id.textView_reportLastTicketNo);
        TextView textView_reportSiteSSA = (TextView) convertView.findViewById(R.id.textView_reportSiteSSA);
        TextView textView_reportLastDoneDate = (TextView) convertView.findViewById(R.id.textView_reportLastDoneDate);
        /*TextView textView_reportSiteAddress = (TextView) convertView.findViewById(R.id.textView_reportSiteAddress);*/
        TextView textView_reportNextDueDate = (TextView) convertView.findViewById(R.id.textView_reportNextDueDate);


        textView_reportSiteName.setText("Site Name: " + SitePMReportTicket.getSiteName());
        textView_reportSiteId.setText("Site ID: " + SitePMReportTicket.getSiteId());
        textView_reportLastTicketNo.setText("Last Ticket No: " + SitePMReportTicket.getSitePMLastTicketNo());
        textView_reportSiteSSA.setText("SSA: " + SitePMReportTicket.getSiteSSA());
        if (SitePMReportTicket.getSitePMTicketLastDoneDate().isEmpty() && SitePMReportTicket.getSitePMTicketNextDueDate().isEmpty()) {
            textView_reportLastDoneDate.setVisibility(View.GONE);
            textView_reportNextDueDate.setVisibility(View.GONE);
        }
        textView_reportLastDoneDate.setText("Last Done Date: " + SitePMReportTicket.getSitePMTicketLastDoneDate());
        /*textView_reportSiteAddress.setText("Site Address: " + SitePMReportTicket.getSiteAddress());*/
        textView_reportNextDueDate.setText("Next Due Date: " + SitePMReportTicket.getSitePMTicketNextDueDate());


        /*if (SitePMTicket.getStatus().equalsIgnoreCase("WIP")) {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.yellow));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.colorWhite));
        }*/
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hotoTicketList.getSitePMReportTicketsDates().get(groupPosition).getSitePMReportTickets().size();
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return hotoTicketList.getSitePMReportTicketsDates().get(groupPosition);
//        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return hotoTicketList.getSitePMReportTicketsDates().size();
//        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        SitePMReportTicketsDate SitePMReportTicketsDate = (SitePMReportTicketsDate) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_site_pm_report_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
        TextView textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

        textView_Date.setText(SitePMReportTicketsDate.getTicketDate());
        textView_Date.setTypeface(null, Typeface.BOLD);

        textView_Count.setTypeface(null, Typeface.BOLD);
        textView_Count.setText("" + SitePMReportTicketsDate.getSitePMTicketCount());

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