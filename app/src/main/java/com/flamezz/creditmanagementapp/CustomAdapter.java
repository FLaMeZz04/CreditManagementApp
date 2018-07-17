package com.flamezz.creditmanagementapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter{

    List<String> detailList;
    CustomAdapter(List<String> detailList)
    {
        this.detailList=detailList;
    }

    @Override
    public int getCount() {
        return detailList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_view,viewGroup,false);
        TextView textName = mview.findViewById(R.id.textName);
        textName.setText(detailList.get(i));
        return mview;
    }
}
