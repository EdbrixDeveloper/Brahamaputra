package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Activities.ACDB_DCDB;
import com.brahamaputra.mahindra.brahamaputra.Activities.ActiveequipmentDetails;
import com.brahamaputra.mahindra.brahamaputra.Activities.Air_Conditioners;
import com.brahamaputra.mahindra.brahamaputra.Activities.Battery_Set;
import com.brahamaputra.mahindra.brahamaputra.Activities.DetailsOfUnusedMaterials;
import com.brahamaputra.mahindra.brahamaputra.Activities.Earth_Resistance_Equipment;
import com.brahamaputra.mahindra.brahamaputra.Activities.Earth_Resistance_Tower;
import com.brahamaputra.mahindra.brahamaputra.Activities.Electric_Connection;
import com.brahamaputra.mahindra.brahamaputra.Activities.ExternalTenantsPersonaldetails;
import com.brahamaputra.mahindra.brahamaputra.Activities.GeneralAndSafetyMeasures;
import com.brahamaputra.mahindra.brahamaputra.Activities.HotoSectionsListActivity;
import com.brahamaputra.mahindra.brahamaputra.Activities.Land_Details;
import com.brahamaputra.mahindra.brahamaputra.Activities.Media;
import com.brahamaputra.mahindra.brahamaputra.Activities.PowerManagementSystem;
import com.brahamaputra.mahindra.brahamaputra.Activities.PowerPlantDetailsActivity;
import com.brahamaputra.mahindra.brahamaputra.Activities.Power_Backups_DG;
import com.brahamaputra.mahindra.brahamaputra.Activities.ServoStabilizer;
import com.brahamaputra.mahindra.brahamaputra.Activities.Shelter;
import com.brahamaputra.mahindra.brahamaputra.Activities.Solar_Power_System;
import com.brahamaputra.mahindra.brahamaputra.Activities.Total_DC_Load_site;
import com.brahamaputra.mahindra.brahamaputra.Activities.Tower_Detail;
import com.brahamaputra.mahindra.brahamaputra.Data.HotoSection;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;

public class HotoSectionListAdapter extends ArrayAdapter<HotoSection> implements View.OnClickListener{

    private ArrayList<HotoSection> dataSet;
    Context mContext;
    private int lastPosition = -1;

    public HotoSectionListAdapter(ArrayList<HotoSection> data, Context context) {
        super(context, R.layout.item_hoto_section, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        HotoSection dataModel=(HotoSection)object;

    }

    private static class ViewHolder {
        TextView txtHotoNo;
        TextView txtHotoName;
        ImageView imageViewStatus;
        LinearLayout linearLayout_container;
        public boolean readingStatus=false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        HotoSection dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_hoto_section, parent, false);
            viewHolder.txtHotoNo = (TextView) convertView.findViewById(R.id.hotoSection_textView_no);
            viewHolder.txtHotoName = (TextView) convertView.findViewById(R.id.hotoSection_textView_name);
            viewHolder.imageViewStatus = (ImageView) convertView.findViewById(R.id.hotoSection_imageView_status);
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

        viewHolder.txtHotoNo.setText(dataModel.getSecNo());
        viewHolder.txtHotoName.setText(dataModel.getSecName());
        if(dataModel.getSecReadingStatus()){
            //viewHolder.imageViewStatus.setImageResource(R.drawable.ic_done_green_24dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.yellow));
        }else {
            //viewHolder.imageViewStatus.setImageResource(R.drawable.baseline_done_white_18dp);
            viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWhite));
        }

        return convertView;
    }



}
