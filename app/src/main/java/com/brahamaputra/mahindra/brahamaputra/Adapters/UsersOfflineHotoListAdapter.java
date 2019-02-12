package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;
import java.util.ArrayList;

public class UsersOfflineHotoListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> data;
    private static LayoutInflater inflater=null;

    public UsersOfflineHotoListAdapter(Activity activity, ArrayList<String> data) {
        this.activity = activity;
        this.data = data;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.item_user_offline_hoto_list, null);

        TextView textViewTicketNo = (TextView)vi.findViewById(R.id.textViewTicketNo); // title

        /*HashMap&lt;String, String&gt; song = new HashMap&lt;String, String&gt;();
        song = data.get(position);
*/
        // Setting all values in listview
        textViewTicketNo.setText(data.get(position));
        return vi;
    }
}
