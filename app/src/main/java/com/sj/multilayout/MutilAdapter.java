package com.sj.multilayout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sj.jenkinsgradle.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by liuxinxian on 2017/3/23.
 */

public class MutilAdapter<T> extends BaseAdapter {

    private Context mContext;

    private List<T> datas = new ArrayList<>();

    public List<T> getDatas() {
        return datas;
    }

    CheckStatus checkStatus = new CheckStatus(false);


    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public MutilAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            switch (getItemViewType(position)){
                case 0:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_item1,null);
                    viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);
                    break;
                case 1:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_item2,null);
                    viewHolder.btnEvent = (Button)convertView.findViewById(R.id.btnEvent);
                    break;
                case 2:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_item3,null);
                    viewHolder.btnEvent = (Button)convertView.findViewById(R.id.btnEvent);
                    break;
            }
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.tvName.setText(position+"");
        if(getItemViewType(position)!=0){
            viewHolder.btnEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"current pos "+position,1000).show();
                }
            });
        }else {
            viewHolder.checkBox.setTag(checkStatus);
            viewHolder.checkBox.setChecked(checkStatus.isChecked(position));
            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkStatus = (CheckStatus)viewHolder.checkBox.getTag();
                    checkStatus.setSelectStatus(!checkStatus.isChecked(position),position);
                    viewHolder.checkBox.setChecked(checkStatus.isChecked(position));
                }
            });
        }
        return convertView;
    }

    private class CheckStatus{
        private boolean isChecked;
        private int pos;
        private Map<Integer,Boolean> checkedMap = new HashMap<>();

        public void setSelectStatus(boolean isChecked, int pos){
            checkedMap.put(pos,isChecked);
        }

        public CheckStatus(boolean isChecked) {
            this.isChecked = isChecked;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public boolean isChecked(int pos) {
            if(checkedMap==null){
                return false;
            }else {
                if(checkedMap.keySet().contains(pos)){
                    return checkedMap.get(pos).booleanValue();
                }else {
                    return false;
                }
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position%3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    private class ViewHolder{
        private TextView tvName;
        private Button btnEvent;
        private CheckBox checkBox;
    }
}
