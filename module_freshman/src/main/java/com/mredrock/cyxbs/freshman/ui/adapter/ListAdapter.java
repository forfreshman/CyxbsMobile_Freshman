package com.mredrock.cyxbs.freshman.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mredrock.cyxbs.freshman.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {
    private int resourceId;
    public ListAdapter(@NonNull Context context, int resource, List<String> strings) {
        super(context, resource, strings);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String s=getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textView =(TextView)view.findViewById(R.id.tv_fellow_list);
        textView.setText(s);
        return view;
    }
}
