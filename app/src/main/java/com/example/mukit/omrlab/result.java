package com.example.mukit.omrlab;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class result extends ListActivity {

    public static final String RESULT = "result";
    public String subject[] = {"Physics", "Chemistry", "Math"};

    private TextView SubCode;
    private TextView SubName;
    ListView idListView;
    List<String> fruits_list;
    ArrayAdapter<String> arrayAdapterID;
    ArrayList<String> resultArray;
    LayoutInflater inflater;
    private static final String TAG = "AndroidCameraApi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SubCode= (TextView) findViewById(R.id.showSubCode);
        SubName = (TextView) findViewById(R.id.showSubName);

        Intent intent = getIntent();
        if (intent != null) {
            resultArray = intent.getStringArrayListExtra(RESULT);
        } else
            resultArray = new ArrayList<>();

        inflater = getLayoutInflater();

        // Get reference of widgets from XML layout
//        idListView = (ListView) findViewById(R.id.list);
        ResultAdapter adapter = new ResultAdapter(resultArray);
        getListView().setAdapter(adapter);



    }

    private class ResultAdapter extends BaseAdapter {

        private ArrayList items;

        ResultAdapter(ArrayList<String> items) {
            super();
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ResultHolder holder;
            if (convertView == null) {
                holder = new ResultHolder();
                convertView = inflater.inflate(R.layout.rowlayout, null);
                holder.tv_id = (TextView) convertView.findViewById(R.id.tv_id);
                holder.tv_marks = (TextView) convertView.findViewById(R.id.tv_marks);
                convertView.setTag(holder);
            } else {
                holder = (ResultHolder) convertView.getTag();
            }

            String[] item = ((String) getItem(position)).split("//");
            //for sub and subcode/////
            SubCode.setText(item[0]);
            switch (item[0]) {
                case "111":
                    SubName.setText(subject[0]);
                    break;
                case "112":
                    SubName.setText(subject[1]);
                    break;
                case "113":
                    SubName.setText(subject[2]);
                    break;
                default:
                    SubName.setText("Not found");
            }
            //////////////////////////////
            holder.tv_id.setText(item[1]);
            holder.tv_marks.setText(item[2]);

            return convertView;
        }

        private class ResultHolder {
            TextView tv_id;
            TextView tv_marks;
        }

    }

    public void showToast(String str) {
        Toast.makeText(result.this, str, Toast.LENGTH_SHORT).show();
    }

}
