package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.AcPMReportListData;
import com.brahamaputra.mahindra.brahamaputra.Data.AcPMReportTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.AcPMReportTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportListData;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.SitePMReportTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.List;

public class PmAcReportExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<AcPMReportTicketsDate> _listDataHeader; // header titles
    // child data in format of header title, child title
    private AcPMReportListData acPMReportListData;

    public PmAcReportExpListAdapter(Context _context, AcPMReportListData acPMReportListData){
        this._context = _context;
        this.acPMReportListData = acPMReportListData;
    }

    @Override
    public int getGroupCount() {
        return acPMReportListData.getAcPMReportTicketsDates().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return acPMReportListData.getAcPMReportTicketsDates().get(groupPosition).getAcPMReportTickets().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return acPMReportListData.getAcPMReportTicketsDates().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return acPMReportListData.getAcPMReportTicketsDates().get(groupPosition).getAcPMReportTickets().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;//Long.parseLong(acPMReportListData.getAcPMReportTicketsDates().get(groupPosition).getAcPMReportTickets().get(childPosition).getId());
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        AcPMReportTicketsDate acPMReportTicketsDate = (AcPMReportTicketsDate) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_ac_pm_report_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_Date = (TextView) convertView.findViewById(R.id.textView_Date);
        TextView textView_Count = (TextView) convertView.findViewById(R.id.textView_Count);

        textView_Date.setText(acPMReportTicketsDate.getTicketDate());
        textView_Date.setTypeface(null, Typeface.BOLD);

        textView_Count.setTypeface(null, Typeface.BOLD);
        textView_Count.setText("" + acPMReportTicketsDate.getAcPMTicketCount());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final AcPMReportTicket acPMReportTicket = (AcPMReportTicket) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_ac_pm_report_list, null);
        }

        TextView textView_reportSiteName = (TextView) convertView.findViewById(R.id.textView_reportSiteName);
        TextView textView_reportSiteId = (TextView) convertView.findViewById(R.id.textView_reportSiteId);
        TextView textView_reportLastTicketNo = (TextView) convertView.findViewById(R.id.textView_reportLastTicketNo);
        TextView textView_reportSiteSSA = (TextView) convertView.findViewById(R.id.textView_reportSiteSSA);
        TextView textView_reportSiteAddress = (TextView) convertView.findViewById(R.id.textView_reportSiteAddress);
        TextView textView_reportLastDoneDate = (TextView) convertView.findViewById(R.id.textView_reportLastDoneDate);
        /*TextView textView_reportSiteAddress = (TextView) convertView.findViewById(R.id.textView_reportSiteAddress);*/
        TextView textView_reportNextDueDate = (TextView) convertView.findViewById(R.id.textView_reportNextDueDate);


        textView_reportSiteName.setText("Site Name: " + acPMReportTicket.getSiteName());
        textView_reportSiteId.setText("Site ID: " + acPMReportTicket.getSiteId());

        textView_reportSiteSSA.setText("Site SSA: " + acPMReportTicket.getSiteSSA());

        /*if (sitePmReportType.equals("1")) {
            textView_reportLastTicketNo.setVisibility(View.GONE);
            textView_reportLastDoneDate.setVisibility(View.GONE);
            textView_reportNextDueDate.setVisibility(View.GONE);
        }*/
        if (acPMReportTicket.getAcPMLastTicketNo().isEmpty()) {
            textView_reportLastTicketNo.setVisibility(View.GONE);
        } else {
            textView_reportLastTicketNo.setText("Last Ticket No: " + acPMReportTicket.getAcPMLastTicketNo());
            textView_reportLastTicketNo.setVisibility(View.VISIBLE);
        }
        if (acPMReportTicket.getAcPMTicketLastDoneDate().isEmpty()) {
            textView_reportLastDoneDate.setVisibility(View.GONE);
        } else {
            textView_reportLastDoneDate.setText("Last Done Date: " + acPMReportTicket.getAcPMTicketLastDoneDate());
            textView_reportLastDoneDate.setVisibility(View.VISIBLE);
        }
        if (acPMReportTicket.getAcPMTicketNextDueDate().isEmpty()) {
            textView_reportNextDueDate.setVisibility(View.GONE);
        } else {
            textView_reportNextDueDate.setText("Next Due Date: " + acPMReportTicket.getAcPMTicketNextDueDate());
            textView_reportNextDueDate.setVisibility(View.VISIBLE);
        }

        textView_reportSiteAddress.setText("Site Address: " + acPMReportTicket.getSiteAddress());



        /*if (SitePMTicket.getStatus().equalsIgnoreCase("WIP")) {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.yellow));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(_context, R.color.colorWhite));
        }*/
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
