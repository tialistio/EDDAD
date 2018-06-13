package com.example.com_pc.depression;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ResultListAdapter extends BaseAdapter {

    private Context context;
    private List<Result> resultList;

    public ResultListAdapter(Context context, List<Result> resultList){
        this.context = context;
        this.resultList = resultList;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.result_info,null);
        TextView resultID1 = (TextView)v.findViewById(R.id.tt1);
        TextView resultID2 = (TextView)v.findViewById(R.id.tt2);

        resultID1.setText(resultList.get(position).getTt1());
        resultID2.setText(resultList.get(position).getTt2());

        v.setTag(resultList.get(position).getTt1());
        return v;
    }
}
