
package com.client.lrms.adapter;

import com.client.lrms.R;
import com.client.lrms.activity.QuickPreordainActicity;

import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import java.util.List;

public class QuickPreordainAdapter extends BaseAdapter {
    private int maxFree;

    private List<String> hours;

    SparseBooleanArray checkMap = new SparseBooleanArray();

    public QuickPreordainAdapter(List<String> hours, int maxFree) {
        this.maxFree = maxFree;
        this.hours = hours;

        for (int i = 0; i < hours.size(); i++) {
            checkMap.put(i, false);

        }
    }

    @Override
    public int getCount() {
        return hours.size();
    }

    @Override
    public String getItem(int arg0) {
        return hours.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.layout_hours, null);
        final CheckBox btn = (CheckBox) view.findViewById(R.id.btn_hours);
        btn.setText(getItem(position));

        // 大于maxFree不能选择
        btn.setEnabled((position + 1) <= maxFree);

        final QuickPreordainActicity activity = (QuickPreordainActicity) parent.getContext();
        // 默认没选中
        btn.setChecked(checkMap.get(position));
        btn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkMap.put(position, isChecked);
                if (isChecked) {
                    // 保存唯一，互斥
                    checkOther(position);
                    btn.setTextColor(parent.getContext().getResources().getColor(R.color.white));
                    activity.doQuickBookReq();
                }
            }
        });
        if (btn.isEnabled()) {
            btn.setTextColor(parent.getContext().getResources().getColor(R.color.text_color));
        } else {
            btn.setTextColor(Color.rgb(223, 225, 222));
        }

        return view;
    }

    private void checkOther(int current) {
        for (int i = 0; i < hours.size(); i++) {
            if (current != i) {
                checkMap.put(i, false);
            }

        }
        notifyDataSetChanged();
    }

    public String getHour() {
        for (int i = 0; i < hours.size(); i++) {
            if (checkMap.get(i)) {
                return String.valueOf(i + 1);
            }
        }
        return "0";
    }

}
