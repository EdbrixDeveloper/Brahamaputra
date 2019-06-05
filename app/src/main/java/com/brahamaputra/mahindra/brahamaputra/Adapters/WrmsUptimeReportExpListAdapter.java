package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.WrmsUptimeReportListData;
import com.brahamaputra.mahindra.brahamaputra.Data.WrmsUptimeReportTicket;
import com.brahamaputra.mahindra.brahamaputra.Data.WrmsUptimeReportTicketsDate;
import com.brahamaputra.mahindra.brahamaputra.R;

public class WrmsUptimeReportExpListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    // child data in format of header title, child title
    private WrmsUptimeReportListData wrmsUptimeReportListData;

    public WrmsUptimeReportExpListAdapter(Context _context, WrmsUptimeReportListData wrmsUptimeReportListData) {
        this._context = _context;
        this.wrmsUptimeReportListData = wrmsUptimeReportListData;
    }

    @Override
    public int getGroupCount() {
        return wrmsUptimeReportListData.getWrmsUptimeReportTicketsDates().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return wrmsUptimeReportListData.getWrmsUptimeReportTicketsDates().get(groupPosition).getWrmsUptimeReportTickets().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return wrmsUptimeReportListData.getWrmsUptimeReportTicketsDates().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return wrmsUptimeReportListData.getWrmsUptimeReportTicketsDates().get(groupPosition).getWrmsUptimeReportTickets().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;//Long.parseLong(wrmsUptimeReportListData.getWrmsUptimeReportTicketsDates().get(groupPosition).getWrmsUptimeReportTickets().get(childPosition).getId());
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        WrmsUptimeReportTicketsDate wrmsUptimeReportTicketsDate = (WrmsUptimeReportTicketsDate) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_wrms_uptime_report_list_seprator, null);
            convertView.setClickable(false);
        }
        TextView textView_reportSiteName = (TextView) convertView.findViewById(R.id.textView_reportSiteName);
        TextView textView_reportSiteId = (TextView) convertView.findViewById(R.id.textView_reportSiteId);
        TextView textView_reportSiteSSA = (TextView) convertView.findViewById(R.id.textView_reportSiteSSA);
        TextView textView_reportSiteUptime = (TextView) convertView.findViewById(R.id.textView_reportSiteUptime);
        TextView textView_reportSiteDeviation = (TextView) convertView.findViewById(R.id.textView_reportSiteDeviation);
        TextView textView_reportNoOfEvents = (TextView) convertView.findViewById(R.id.textView_reportNoOfEvents);
        TextView textView_totalOutageMinutes = (TextView) convertView.findViewById(R.id.textView_totalOutageMinutes);

        textView_reportSiteName.setText(wrmsUptimeReportTicketsDate.getSiteName());
        textView_reportSiteName.setTypeface(null, Typeface.BOLD);
        textView_reportSiteId.setText(wrmsUptimeReportTicketsDate.getSiteId());
        textView_reportSiteSSA.setText(wrmsUptimeReportTicketsDate.getSiteSSA());
        textView_reportSiteUptime.setText(wrmsUptimeReportTicketsDate.getSiteUptime());
        textView_reportSiteDeviation.setText(wrmsUptimeReportTicketsDate.getSiteDeviation());
        textView_reportNoOfEvents.setText(wrmsUptimeReportTicketsDate.getNoOfEvents());
        textView_totalOutageMinutes.setText(wrmsUptimeReportTicketsDate.getTotalOutageMinutes());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final WrmsUptimeReportTicket wrmsUptimeReportTicket = (WrmsUptimeReportTicket) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_wrms_uptime_report_list, null);
        }

        TextView textView_reportEventDate = (TextView) convertView.findViewById(R.id.textView_reportEventDate);
        TextView textView_reportDuration = (TextView) convertView.findViewById(R.id.textView_reportDuration);


        textView_reportEventDate.setText("Event Date: " + wrmsUptimeReportTicket.getEventDate());
        textView_reportDuration.setText("Duration(in min): " + wrmsUptimeReportTicket.getDurationInMinutes());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
