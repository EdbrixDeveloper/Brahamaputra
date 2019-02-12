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

import com.brahamaputra.mahindra.brahamaputra.Data.Notification;
import com.brahamaputra.mahindra.brahamaputra.R;
import com.brahamaputra.mahindra.brahamaputra.helper.DatabaseHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotificationListAdapter extends ArrayAdapter<Notification>
        implements View.OnClickListener {

    private ArrayList<Notification> dataSet;
    Context mContext;
    public static final int REQUEST_FOR_DELETE = 259;
    private DatabaseHelper databaseHelper;

    // View lookup cache
    private static class ViewHolder {
        TextView textView_title;
        TextView textView_message;
        TextView textView_messageDate;
        ImageView button_deleteMessage;
        LinearLayout linearLayout_item;
    }

    public NotificationListAdapter(ArrayList<Notification> data, Context context) {
        super(context, R.layout.item_notification_list, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Notification dataModel = (Notification) object;
    }

    //private int lastPosition = -1;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Notification dataModel = dataSet.get(position);//getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_notification_list, parent, false);

            viewHolder.textView_title = (TextView) convertView.findViewById(R.id.textView_title);
            viewHolder.textView_message = (TextView) convertView.findViewById(R.id.textView_message);
            viewHolder.textView_messageDate = (TextView) convertView.findViewById(R.id.textView_messageDate);
            viewHolder.button_deleteMessage = (ImageView) convertView.findViewById(R.id.button_deleteMessage);
            viewHolder.linearLayout_item = (LinearLayout) convertView.findViewById(R.id.linearLayout_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView_title.setText(dataModel.getTitle());
        viewHolder.textView_message.setText(dataModel.getMessage());
        viewHolder.textView_messageDate.setText(parseTime(dataModel.getTimestamp()));
        viewHolder.button_deleteMessage.setTag(position);
        //viewHolder.linearLayout_item.setTag(position);

        viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));
        if (dataModel.getIsRead() == 1) {
            viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
        }


        viewHolder.button_deleteMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) v.getTag();
                Notification lst = getItem(position);
                databaseHelper = new DatabaseHelper(getContext());
                databaseHelper.deleteNotification(lst);
                dataSet.remove(dataModel);
                notifyDataSetChanged();
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

    public String parseTime(String date2) {
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dateFormat.parse(date2);
            DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
            String dateStr = formatter.format(date);

            return dateStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}