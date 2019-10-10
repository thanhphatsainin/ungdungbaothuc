package com.example.ungdungbaothuc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class baothucAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private  List<baothuc> BTList;

    public baothucAdapter(Context context, int layout, List<baothuc> BTList) {
        this.context = context;
        this.layout = layout;
        this.BTList = BTList;
    }

    @Override
    public int getCount() {
        return BTList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtGio;
        TextView txtGhiChu;
        Switch Switchbaothuc;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder = new ViewHolder();
            holder.txtGio = convertView.findViewById(R.id.textViewGio);
            holder.txtGhiChu = convertView.findViewById(R.id.textViewGhichu);
            holder.Switchbaothuc = convertView.findViewById(R.id.switchbaothuc);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        baothuc bt = BTList.get(position);
        holder.txtGio.setText(bt.getGio());
        holder.txtGhiChu.setText(bt.getGhichu());
        /*
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"alo",Toast.LENGTH_SHORT).show();
            }
        });
        */
        return convertView;
    }
}
