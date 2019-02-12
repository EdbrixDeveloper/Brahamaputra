package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.DiselFillingTransactionList;
import com.brahamaputra.mahindra.brahamaputra.R;
import java.util.ArrayList;

public class DieselTrasactionAdapter extends ArrayAdapter<DiselFillingTransactionList>
        implements View.OnClickListener {

    private ArrayList<DiselFillingTransactionList> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView textView_ticketNo;
        TextView textView_SiteName;
        TextView textView_DateOfFilling;
        TextView textView_SiteAddress;
        TextView textView_fillingQty;


    }

    public DieselTrasactionAdapter(ArrayList<DiselFillingTransactionList> data, Context context) {
        super(context, R.layout.item_diesel_trasaction_list, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        DiselFillingTransactionList dataModel = (DiselFillingTransactionList) object;

        switch (v.getId()) {
           /* case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;*/
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DiselFillingTransactionList dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_diesel_trasaction_list, parent, false);

            viewHolder.textView_ticketNo = (TextView) convertView.findViewById(R.id.textView_ticketNo);
            viewHolder.textView_SiteName = (TextView) convertView.findViewById(R.id.textView_SiteName);
            viewHolder.textView_DateOfFilling = (TextView) convertView.findViewById(R.id.textView_DateOfFilling);
            viewHolder.textView_SiteAddress = (TextView) convertView.findViewById(R.id.textView_SiteAddress);
            viewHolder.textView_fillingQty = (TextView) convertView.findViewById(R.id.textView_fillingQty);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        viewHolder.textView_ticketNo.setText("Request No:" + dataModel.getDiselFillingtTicketNo());
        viewHolder.textView_SiteName.setText("Site Name:" + dataModel.getSiteName());
        viewHolder.textView_DateOfFilling.setText("Filling Date:" + dataModel.getDateOfFilling());
        viewHolder.textView_SiteAddress.setText("Site Address:" + dataModel.getSiteAddress());
        viewHolder.textView_fillingQty.setText("Diesel Filling Qty:" + dataModel.getFillingQty());

        /*if (dataModel.getStatusId() == 0) {
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
        }

        if (dataModel.getStatusId() == 1) {
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.yellow));
        }

        if (dataModel.getStatusId() == 2) {
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.red));
        }*/

        // Return the completed view to render on screen
        return convertView;
    }
}