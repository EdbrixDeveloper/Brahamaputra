package com.brahamaputra.mahindra.brahamaputra.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.Activities.ElectricBillProcessList;
import com.brahamaputra.mahindra.brahamaputra.Activities.UploadEBPaymentDetailsActivity;
import com.brahamaputra.mahindra.brahamaputra.Activities.UploadEBReceiptActivity;
import com.brahamaputra.mahindra.brahamaputra.Data.EbPaymentRequestList;
import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.eb_billing_process_flag;

public class EbProcessTrasactionAdapter extends ArrayAdapter<EbPaymentRequestList>
        implements View.OnClickListener {

    private ArrayList<EbPaymentRequestList> dataSet;
    Context mContext;
    String getStatus;
    String request_id;
    String ticket_no;
    String site_id;
    String site_name;
    String StatusId;
    public static final int RESULT_EB_REC_SUBMIT = 259;

    // View lookup cache
    private static class ViewHolder {

        TextView textView_ticketNo;
        TextView textView_SiteName;
        TextView textView_DateOfRequest;
        TextView textView_BillIssueDate;
        TextView textView_BillDueDate;
        TextView textView_ModeOfPayment;
        TextView textView_BillGrossAmt;
        TextView textView_status;
        LinearLayout linearLayout_item;

        TextView textView_details;
        ImageView imageView_details;
        ImageView imageView_status;
    }

    public EbProcessTrasactionAdapter(ArrayList<EbPaymentRequestList> data, Context context) {
        super(context, R.layout.item_ebprocessl_trasaction_list, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        EbPaymentRequestList dataModel = (EbPaymentRequestList) object;

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
        EbPaymentRequestList dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_ebprocessl_trasaction_list, parent, false);

            viewHolder.textView_ticketNo = (TextView) convertView.findViewById(R.id.textView_ticketNo);
            viewHolder.textView_SiteName = (TextView) convertView.findViewById(R.id.textView_SiteName);
            viewHolder.textView_DateOfRequest = (TextView) convertView.findViewById(R.id.textView_DateOfRequest);
            viewHolder.textView_BillIssueDate = (TextView) convertView.findViewById(R.id.textView_BillIssueDate);
            viewHolder.textView_BillDueDate = (TextView) convertView.findViewById(R.id.textView_BillDueDate);
            viewHolder.textView_ModeOfPayment = (TextView) convertView.findViewById(R.id.textView_ModeOfPayment);
            viewHolder.textView_BillGrossAmt = (TextView) convertView.findViewById(R.id.textView_BillGrossAmt);
            viewHolder.textView_status = (TextView) convertView.findViewById(R.id.textView_status);
            viewHolder.linearLayout_item = (LinearLayout) convertView.findViewById(R.id.linearLayout_item);

            viewHolder.textView_details = (TextView) convertView.findViewById(R.id.textView_details);
            viewHolder.imageView_details = (ImageView) convertView.findViewById(R.id.imageView_details);
            viewHolder.imageView_status = (ImageView) convertView.findViewById(R.id.imageView_status);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.textView_ticketNo.setText("Ticket No: " + dataModel.getRequestTicketeNo());
        viewHolder.textView_SiteName.setText("Site Name: " + dataModel.getSiteName());
        /*viewHolder.textView_DateOfRequest.setText(dataModel.getDateOfRequest());*/
        viewHolder.textView_DateOfRequest.setText("Request Date: " + dataModel.getDateOfRequest());
        viewHolder.textView_BillIssueDate.setText("Bill Issue Date: " + dataModel.getBillIssueDate());
        viewHolder.textView_BillDueDate.setText("Bill Due Date: " + dataModel.getBillDueDate());
        viewHolder.textView_ModeOfPayment.setText("Mode Of Payment: " + dataModel.getModeOfPayment());
        viewHolder.textView_BillGrossAmt.setText("Gross Amt: " + dataModel.getGrossAmount());

        if (dataModel.getStatusId().equals("1")) { ///////// 1
            viewHolder.textView_status.setText("Approved");
            viewHolder.textView_status.setTextColor(Color.BLACK);
            viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

            viewHolder.textView_details.setText("Details");
            viewHolder.textView_details.setTextColor(Color.BLACK);
            viewHolder.textView_details.setVisibility(View.GONE);

            viewHolder.imageView_details.setVisibility(View.GONE);
            viewHolder.imageView_status.setVisibility(View.GONE);

        } else if (dataModel.getStatusId().equals("2")) { ///////// 2
            viewHolder.textView_status.setText("Approved");
            viewHolder.textView_status.setTextColor(Color.BLACK);
            viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

            viewHolder.textView_details.setText("Details");
            viewHolder.textView_details.setTextColor(Color.BLACK);
            viewHolder.textView_details.setVisibility(View.GONE);//change on 19032019 by 008

            viewHolder.imageView_details.setVisibility(View.GONE);//change on 19032019 by 008
            viewHolder.imageView_status.setVisibility(View.VISIBLE);//change on 19032019 by 008

        } else if (dataModel.getStatusId().equals("3")) { ///////// 3
            if (dataModel.getStatusId().equals("3") && dataModel.getModeOfPayment().equals("Cash")) {

                viewHolder.textView_status.setText("Approved");
                viewHolder.textView_status.setTextColor(Color.BLACK);
                viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

                viewHolder.textView_details.setText("");
                viewHolder.textView_details.setTextColor(Color.BLACK);
                viewHolder.textView_details.setVisibility(View.GONE);

                viewHolder.imageView_details.setVisibility(View.GONE);
                viewHolder.imageView_status.setVisibility(View.VISIBLE);
            } else {
                viewHolder.textView_status.setText("Approved");
                viewHolder.textView_status.setTextColor(Color.BLACK);
                viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

                viewHolder.textView_details.setText("Details");
                viewHolder.textView_details.setTextColor(Color.BLACK);
                viewHolder.textView_details.setVisibility(View.VISIBLE);

                viewHolder.imageView_details.setVisibility(View.VISIBLE);
                viewHolder.imageView_status.setVisibility(View.VISIBLE);
            }
        } else if (dataModel.getStatusId().equals("4")) { ///////// 4
            if (dataModel.getStatusId().equals("4") && dataModel.getModeOfPayment().equals("NEFT")) {
                viewHolder.textView_status.setText("Approved");
                viewHolder.textView_status.setTextColor(Color.BLACK);
                viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

                viewHolder.textView_details.setText("Details");
                viewHolder.textView_details.setTextColor(Color.BLACK);
                viewHolder.textView_details.setVisibility(View.GONE);

                viewHolder.imageView_details.setVisibility(View.GONE);
                viewHolder.imageView_status.setVisibility(View.GONE);
            } else if (dataModel.getStatusId().equals("4") && dataModel.getModeOfPayment().equals("Cash")) {

                viewHolder.textView_status.setText("Approved");
                viewHolder.textView_status.setTextColor(Color.BLACK);
                viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

                viewHolder.textView_details.setText("");
                viewHolder.textView_details.setTextColor(Color.BLACK);
                viewHolder.textView_details.setVisibility(View.GONE);

                viewHolder.imageView_details.setVisibility(View.GONE);
                viewHolder.imageView_status.setVisibility(View.VISIBLE);
            } else {
                ////////////////////////////
                viewHolder.textView_status.setText("Approved");
                viewHolder.textView_status.setTextColor(Color.BLACK);
                viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.limegreen));

                viewHolder.textView_details.setText("Details");
                viewHolder.textView_details.setTextColor(Color.BLACK);
                viewHolder.textView_details.setVisibility(View.VISIBLE);

                viewHolder.imageView_details.setVisibility(View.VISIBLE);
                viewHolder.imageView_status.setVisibility(View.VISIBLE);
            }

        } else if (dataModel.getStatusId().equals("0")) {
            viewHolder.textView_status.setText("Waiting for Approve");
            viewHolder.textView_status.setTextColor(Color.RED);
            viewHolder.linearLayout_item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));

            viewHolder.textView_details.setText("");
            viewHolder.textView_status.setTextColor(Color.BLACK);
            viewHolder.textView_details.setVisibility(View.GONE);

            viewHolder.imageView_details.setVisibility(View.GONE);
            viewHolder.imageView_status.setVisibility(View.GONE);
        }

        getStatus = dataModel.getStatusId();
        request_id = dataModel.getId();
        ticket_no = dataModel.getRequestTicketeNo();
        site_id = dataModel.getSiteId();
        site_name = dataModel.getSiteName();
        StatusId = dataModel.getStatus();
        viewHolder.imageView_status.setTag(position);
        viewHolder.imageView_details.setTag(position);


        viewHolder.imageView_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) v.getTag();
                EbPaymentRequestList lst = getItem(position);
                Context c = getContext();
                //if (lst.getStatusId().equals("1")) {
                if (eb_billing_process_flag.equals("1")) {
                    Intent intent = new Intent(getContext(), UploadEBPaymentDetailsActivity.class);
                    intent.putExtra("request_id", lst.getId());
                    intent.putExtra("ticket_no", lst.getRequestTicketeNo());
                    intent.putExtra("site_id", lst.getSiteId());
                    intent.putExtra("site_name", lst.getSiteName());
                    intent.putExtra("ModeOfPayment", lst.getModeOfPayment());
                    intent.putExtra("StatusId", lst.getStatusId());
                    intent.putExtra("EbPaymentAmt", lst.getGrossAmount());
                    // c.startActivity(intent);
                    ((ElectricBillProcessList) mContext).startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                    //mContext.st startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                    // }
                } else if (eb_billing_process_flag.equals("2")) {
                    Intent intent = new Intent(getContext(), UploadEBReceiptActivity.class);
                    intent.putExtra("request_id", lst.getId());
                    intent.putExtra("ticket_no", lst.getRequestTicketeNo());
                    intent.putExtra("site_id", lst.getSiteId());
                    intent.putExtra("site_name", lst.getSiteName());
                    intent.putExtra("ModeOfPayment", lst.getModeOfPayment());
                    intent.putExtra("StatusId", lst.getStatusId());
                    intent.putExtra("EbPaymentAmt", lst.getGrossAmount());
                    // c.startActivity(intent);
                    ((ElectricBillProcessList) mContext).startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                    //mContext.st startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                    // }
                }
                /*Intent intent = new Intent(getContext(), UploadEBReceiptActivity.class);
                intent.putExtra("request_id", lst.getId());
                intent.putExtra("ticket_no", lst.getRequestTicketeNo());
                intent.putExtra("site_id", lst.getSiteId());
                intent.putExtra("site_name", lst.getSiteName());
                intent.putExtra("ModeOfPayment", lst.getModeOfPayment());
                intent.putExtra("StatusId", lst.getStatusId());
                intent.putExtra("EbPaymentAmt", lst.getGrossAmount());
                // c.startActivity(intent);
                ((ElectricBillProcessList) mContext).startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                //mContext.st startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                // }*/
            }
        });


        viewHolder.imageView_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) v.getTag();
                EbPaymentRequestList lst = getItem(position);
                Context c = getContext();
                //if (lst.getStatusId().equals("1")) {
                Intent intent = new Intent(getContext(), UploadEBPaymentDetailsActivity.class);
                intent.putExtra("request_id", lst.getId());
                intent.putExtra("ticket_no", lst.getRequestTicketeNo());
                intent.putExtra("site_id", lst.getSiteId());
                intent.putExtra("site_name", lst.getSiteName());
                intent.putExtra("ModeOfPayment", lst.getModeOfPayment());
                intent.putExtra("StatusId", lst.getStatusId());
                intent.putExtra("EbPaymentAmt", lst.getGrossAmount());
                // c.startActivity(intent);
                ((ElectricBillProcessList) mContext).startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                //mContext.st startActivityForResult(intent, RESULT_EB_REC_SUBMIT);
                // }
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}