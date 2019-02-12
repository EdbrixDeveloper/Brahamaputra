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

import com.brahamaputra.mahindra.brahamaputra.Data.PreventiveMaintenanceAcSection;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;

public class AcPreventiveMaintenanceSectionListAdapter extends ArrayAdapter<PreventiveMaintenanceAcSection> implements View.OnClickListener{

    private ArrayList<PreventiveMaintenanceAcSection> dataSet;
    Context mContext;
    private int lastPosition = -1;

    public AcPreventiveMaintenanceSectionListAdapter(ArrayList<PreventiveMaintenanceAcSection> data, Context context) {
        super(context, R.layout.item_ac_preventive_maintenance_section, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        PreventiveMaintenanceAcSection dataModel=(PreventiveMaintenanceAcSection)object;
    }

    private static class ViewHolder {
        TextView txtPmAcNo;
        TextView txtPmAcName;
        ImageView imageViewStatus;
        LinearLayout linearLayout_container;
        public boolean readingStatus=false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PreventiveMaintenanceAcSection dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_ac_preventive_maintenance_section, parent, false);
            viewHolder.txtPmAcNo = (TextView) convertView.findViewById(R.id.acPreventiveMaintenanceSection_textView_no);
            viewHolder.txtPmAcName = (TextView) convertView.findViewById(R.id.acPreventiveMaintenanceSection_textView_name);
            viewHolder.imageViewStatus = (ImageView) convertView.findViewById(R.id.acPreventiveMaintenanceSection_imageView_status);
            viewHolder.linearLayout_container = (LinearLayout)convertView.findViewById(R.id.linearLayout_container);
            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        //Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        //result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtPmAcNo.setText(dataModel.getSecNo());
        viewHolder.txtPmAcName.setText(dataModel.getSecName());

        if(dataModel.getSecReadingStatus() == 0){
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWhite));
        }

        if(dataModel.getSecReadingStatus() == 1){
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.yellow));
        }

        if(dataModel.getSecReadingStatus() == 2){
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.limegreen));
        }
        return convertView;
    }
}