package com.owangwang.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangchao on 2017/11/24.
 */

public class StudentAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Student> list;

    public StudentAdapter(Context context, List<Student> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.list_item,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.iv);
            viewHolder.textView=convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(list.get(position).getName());
        viewHolder.imageView.setBackgroundResource(list.get(position).getImage());
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
