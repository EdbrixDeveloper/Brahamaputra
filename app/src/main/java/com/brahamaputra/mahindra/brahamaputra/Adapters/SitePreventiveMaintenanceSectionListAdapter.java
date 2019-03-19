package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Data.SitePreventiveMaintenanceSection;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;

import java.util.ArrayList;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmNoOfAcAvailableAtSite;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmServoStabilizerWorkingStatus;

public class SitePreventiveMaintenanceSectionListAdapter extends ArrayAdapter<SitePreventiveMaintenanceSection> implements View.OnClickListener {

    private ArrayList<SitePreventiveMaintenanceSection> dataSet;
    Context mContext;
    private int lastPosition = -1;

    public SitePreventiveMaintenanceSectionListAdapter(ArrayList<SitePreventiveMaintenanceSection> data, Context context) {
        super(context, R.layout.item_site_preventive_maintenance_section, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        SitePreventiveMaintenanceSection dataModel = (SitePreventiveMaintenanceSection) object;

    }

    private static class ViewHolder {
        TextView txtPmSiteNo;
        TextView txtPmSiteName;
        ImageView imageViewStatus;
        LinearLayout linearLayout_container;
        public boolean readingStatus = false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SitePreventiveMaintenanceSection dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_site_preventive_maintenance_section, parent, false);
            viewHolder.txtPmSiteNo = (TextView) convertView.findViewById(R.id.sitePreventiveMaintenanceSection_textView_no);
            viewHolder.txtPmSiteName = (TextView) convertView.findViewById(R.id.sitePreventiveMaintenanceSection_textView_name);
            viewHolder.imageViewStatus = (ImageView) convertView.findViewById(R.id.sitePreventiveMaintenanceSection_imageView_status);
            viewHolder.linearLayout_container = (LinearLayout) convertView.findViewById(R.id.linearLayout_container);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        //result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtPmSiteNo.setText(dataModel.getSecNo());
        viewHolder.txtPmSiteName.setText(dataModel.getSecName());

        if (dataModel.getSecReadingStatus() == 0) {
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
        }

        if (dataModel.getSecReadingStatus() == 1) {
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.yellow));
        }

        if (dataModel.getSecReadingStatus() == 2) {
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));
        }

        if(hototicket_sourceOfPower.equals("Non DG")){
            if(dataModel.getSecName().equals("DG Check Points") || dataModel.getSecName().equals("DG Battery Check Points"))
            {
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.lightgrey));
            }
        }

        if(hototicket_Selected_SiteType.equals("Outdoor")){
            if(dataModel.getSecName().equals("Shelter Check Points")){
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.lightgrey));
            }
        }

        if(sitePmNoOfAcAvailableAtSite.equals("0")){
            if(dataModel.getSecName().equals("AC Check Points")){
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.lightgrey));
            }
        }

        if(sitePmServoStabilizerWorkingStatus.equals("Not Available")){
            if(dataModel.getSecName().equals("Servo Check Points")){
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.lightgrey));
            }
        }

        return convertView;
    }


}
