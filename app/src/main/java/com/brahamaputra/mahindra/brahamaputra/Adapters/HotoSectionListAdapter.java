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

import com.brahamaputra.mahindra.brahamaputra.Data.HotoSection;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;

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

        if(Constants.hototicket_sourceOfPower.equals("Non EB"))
        {
            if(dataModel.getSecName().equals("Electric Connection"))
            {
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.lightgrey));
            }
        }/*else if(!(Constants.hototicket_sourceOfPower.equals("Non EB"))){
            if(dataModel.getSecName().equals("Electric Connection"))
            {
                viewHolder.linearLayout_container.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWhite));
            }
        }*/

        return convertView;
    }



}
