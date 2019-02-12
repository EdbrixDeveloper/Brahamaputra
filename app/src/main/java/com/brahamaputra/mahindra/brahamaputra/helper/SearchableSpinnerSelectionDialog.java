package com.brahamaputra.mahindra.brahamaputra.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shashank on 18/04/2018.
 **/

public class SearchableSpinnerSelectionDialog {


    Activity context;
    String dTitle, closeText, doneText, selectedStrings;
    //String[] selectedStrings;
    ArrayList<String> itemsString;
    OnSpinnerMultiSelectionItemClick onSpinerMultiSelectionItemClick;
    String itemTextColorCode;

    AlertDialog alertDialog;
    int pos;
    int style;


    public SearchableSpinnerSelectionDialog(Activity activity, ArrayList<String> itemsString, String dialogTitle, String closeText, String itemTextColorCode, String doneText, String selectedStrings) {
        this.itemsString = itemsString;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.closeText = closeText;
        this.itemTextColorCode = itemTextColorCode;
        this.doneText = doneText;
        this.selectedStrings = selectedStrings;
//        this.style=style;
    }

    public void bindOnSpinerListener(OnSpinnerMultiSelectionItemClick onSpinerMultiSelectionItemClick1) {
        this.onSpinerMultiSelectionItemClick = onSpinerMultiSelectionItemClick1;
    }


    public void showSearchableSpinnerDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        View v = context.getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView rippleViewClose = (TextView) v.findViewById(R.id.close);
        TextView rippleViewDone = (TextView) v.findViewById(R.id.done);
        rippleViewDone.setVisibility(View.VISIBLE);
        TextView title = (TextView) v.findViewById(R.id.spinerTitle);
        TextView doneTextView = (TextView) v.findViewById(R.id.done);
        doneTextView.setVisibility(View.VISIBLE);
        TextView closeTextView = (TextView) v.findViewById(R.id.close);
        title.setText(dTitle);
        closeTextView.setText(closeText);
        doneTextView.setText(doneText);
        final ListView listView = (ListView) v.findViewById(R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//00008
        final EditText searchBox = (EditText) v.findViewById(R.id.searchBox);
        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.items_view, itemsString);
        //listView.setAdapter(adapter);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_multiple_choice, itemsString);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        if (!selectedStrings.isEmpty() && selectedStrings != null) {
            List<String> items = Arrays.asList(selectedStrings.split("\\s*,\\s*"));
            for (String ss : items) {
                int i = itemsString.indexOf(ss);
                listView.setItemChecked(i, true);
            }
        }

        adb.setView(v);
        alertDialog = adb.create();
        alertDialog.getWindow().getAttributes().windowAnimations = style;//R.style.DialogAnimations_SmileWindow;
        alertDialog.setCancelable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                try {
                    SparseBooleanArray checked = listView.getCheckedItemPositions();
                    //ArrayList<String> selectedItems = new ArrayList<String>();
                    //String arraySelectedString = "", arraySelectedStringIds = "";

                    selectedStrings = "";
                    for (int m = 0; m < checked.size(); m++) {
                        // Item position in adapter
                        int position = checked.keyAt(m);
                        // Add sport if it is checked i.e.) == TRUE!
                        if (checked.valueAt(m)) {
                            //selectedItems.add(adapter.getItem(position));
                            selectedStrings += adapter.getItem(position).toString() + ",";
                            //arraySelectedStringIds += position + ",";
                        }
                    }
                    selectedStrings = selectedStrings.substring(0, selectedStrings.length() - 1);

                    //////////////////////////

                    String txt = searchBox.getText().toString().trim();

                    if (!selectedStrings.isEmpty() && selectedStrings != null) {

                        ArrayList<String> selectedItems = new ArrayList<String>();

                        for (String ss : itemsString) {
                            if (ss.toLowerCase().contains(txt.toLowerCase())) {
                                selectedItems.add(ss);
                            }
                        }

                        for (int k = 0; k < selectedItems.size(); k++) {
                            listView.setItemChecked(k, false);
                        }


                        if (!selectedStrings.isEmpty() && selectedStrings != null) {
                            List<String> items = Arrays.asList(selectedStrings.split("\\s*,\\s*"));
                            for (String ss : items) {
                                int j = selectedItems.indexOf(ss);
                                listView.setItemChecked(j, true);
                            }
                        }

                    }
                } catch (Exception ex) {
                    Log.d("MultiSelction", "onItemClick: " + ex.getMessage().toString());
                }
                ////////////////////


            }
        });

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(searchBox.getText().toString().trim());

                SparseBooleanArray checked = listView.getCheckedItemPositions();
                //ArrayList<String> selectedItems = new ArrayList<String>();
                //String arraySelectedString = "", arraySelectedStringIds = "";

                selectedStrings = "";
                for (int m = 0; m < checked.size(); m++) {
                    // Item position in adapter
                    int position = checked.keyAt(m);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(m)) {
                        //selectedItems.add(adapter.getItem(position));
                        selectedStrings += adapter.getItem(position).toString() + ",";
                        //arraySelectedStringIds += position + ",";
                    }
                }
                selectedStrings = selectedStrings.substring(0, selectedStrings.length() - 1);


                String txt = searchBox.getText().toString().trim();

                if (!selectedStrings.isEmpty() && selectedStrings != null) {

                    ArrayList<String> selectedItems = new ArrayList<String>();

                    for (String ss : itemsString) {
                        if (ss.toLowerCase().contains(txt.toLowerCase())) {
                            selectedItems.add(ss);
                        }
                    }

                    /*List<String> items = Arrays.asList(selectedStrings.split("\\s*,\\s*"));
                    ArrayList<Integer> intIndex = new ArrayList<Integer>();
                    for (String ss : items) {
                        int i = selectedItems.indexOf(ss);
                        intIndex.add(i);
                    }
*/
                    for (int k = 0; k < selectedItems.size(); k++) {
                        listView.setItemChecked(k, false);
                    }
                    /*for (int j = 0; j < intIndex.size(); j++) {
                        listView.setItemChecked(intIndex.get(j), true);
                    }*/

                    if (!selectedStrings.isEmpty() && selectedStrings != null) {
                        List<String> items = Arrays.asList(selectedStrings.split("\\s*,\\s*"));
                        for (String ss : items) {
                            int i = selectedItems.indexOf(ss);
                            listView.setItemChecked(i, true);
                        }
                    }

                }
            }
        });

        rippleViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        rippleViewDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    SparseBooleanArray checked = listView.getCheckedItemPositions();
                    ArrayList<String> selectedItems = new ArrayList<String>();
                    String arraySelectedString = "", arraySelectedStringIds = "";

                    for (int i = 0; i < checked.size(); i++) {
                        // Item position in adapter
                        int position = checked.keyAt(i);
                        // Add sport if it is checked i.e.) == TRUE!
                        if (checked.valueAt(i)) {
                            //selectedItems.add(adapter.getItem(position));
                            arraySelectedString += adapter.getItem(position).toString() + ",";
                            arraySelectedStringIds += position + ",";
                        }
                    }
                    arraySelectedString = arraySelectedString.substring(0, arraySelectedString.length() - 1);
                    arraySelectedStringIds = arraySelectedStringIds.substring(0, arraySelectedStringIds.length() - 1);

                /*String[] outputStrArr = new String[selectedItems.size()];

                for (int i = 0; i < selectedItems.size(); i++) {
                    outputStrArr[i] = selectedItems.get(i);
                }*/


                    onSpinerMultiSelectionItemClick.onClick(arraySelectedString, arraySelectedStringIds);
                    //onSpinerMultiSelectionItemClick.onClick(outputStrArr, arraySelectedStringIds);
                    alertDialog.dismiss();
                } catch (Exception ex) {
                    Log.d("MultiSelction", "onItemClick: " + ex.getMessage().toString());
                }
            }
        });
        alertDialog.show();
    }
}
