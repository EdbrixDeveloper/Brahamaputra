package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.DiselRequestTransactionList;
import com.brahamaputra.mahindra.brahamaputra.Data.EbSiteElectrificationTransaction;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;

public class EbSiteElectrificationTicketListAdapter extends ArrayAdapter<EbSiteElectrificationTransaction>
        implements View.OnClickListener {

    private ArrayList<EbSiteElectrificationTransaction> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView textView_ebSiteElectrificationTicketNo;
        TextView textView_ebSiteElectrificationSiteName;
        TextView textView_ebSiteElectrificationTicketDate;
        TextView textView_ebSiteElectrificationSiteAddress;
        TextView textView_ebSiteElectrificationSiteID;
        TextView textView_ebSiteElectrificationSiteSSA;
        LinearLayout linearLayout_container;
    }

    public EbSiteElectrificationTicketListAdapter(ArrayList<EbSiteElectrificationTransaction> data, Context context) {
        super(context, R.layout.item_eb_site_electrification_ticket_list, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        EbSiteElectrificationTransaction dataModel = (EbSiteElectrificationTransaction) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        EbSiteElectrificationTransaction dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_eb_site_electrification_ticket_list, parent, false);

            viewHolder.textView_ebSiteElectrificationTicketNo = (TextView) convertView.findViewById(R.id.textView_ebSiteElectrificationTicketNo);
            viewHolder.textView_ebSiteElectrificationSiteName = (TextView) convertView.findViewById(R.id.textView_ebSiteElectrificationSiteName);
            viewHolder.textView_ebSiteElectrificationTicketDate = (TextView) convertView.findViewById(R.id.textView_ebSiteElectrificationTicketDate);
            viewHolder.textView_ebSiteElectrificationSiteAddress = (TextView) convertView.findViewById(R.id.textView_ebSiteElectrificationSiteAddress);
            viewHolder.textView_ebSiteElectrificationSiteID = (TextView) convertView.findViewById(R.id.textView_ebSiteElectrificationSiteID);
            viewHolder.textView_ebSiteElectrificationSiteSSA = (TextView) convertView.findViewById(R.id.textView_ebSiteElectrificationSiteSSA);
            viewHolder.linearLayout_container = (LinearLayout) convertView.findViewById(R.id.linearLayout_container);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        if (dataModel != null) {
            viewHolder.textView_ebSiteElectrificationTicketNo.setText("Ticket No:" + dataModel.getEbSiteElectrificationTicketNo());
            viewHolder.textView_ebSiteElectrificationSiteName.setText("Site Name:" + dataModel.getSiteName());
            viewHolder.textView_ebSiteElectrificationTicketDate.setText("Date:" + dataModel.getEbSiteElectrificationTicketDate());
            viewHolder.textView_ebSiteElectrificationSiteAddress.setText("Site Address:" + dataModel.getSiteAddress());
            viewHolder.textView_ebSiteElectrificationSiteID.setText("Site ID:" + dataModel.getSiteId());
            viewHolder.textView_ebSiteElectrificationSiteSSA.setText("Site SSA:" + dataModel.getSsaName());
            //viewHolder.linearLayout_container.setTag(position);


            /*if (dataModel.getStatusId() == 0) {
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
            }

            if (dataModel.getStatusId() == 1) {
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));
            }

            if (dataModel.getStatusId() == 2) {
                viewHolder.linearLayout_container.setBackgroundColor(Color.parseColor("#ffcdd2"));//R.color.red
            }*/

        }
        return convertView;
    }
}