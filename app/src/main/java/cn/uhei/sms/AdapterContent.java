package cn.uhei.sms;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public class AdapterContent extends BaseAdapter {
    private Context context;
    private List<ContentBean> contents;

    public AdapterContent(Context context, List<ContentBean> contents) {
        this.context = context;
        this.contents = contents;
    }

    @Override
    public int getCount() {
        return contents.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = View.inflate(context,R.layout.content_item_main,null);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ContentBean mContent = getItem(position);
        //获取号码
        viewHolder.tvPhone.setText(mContent.getNumber());
        viewHolder.tvContent.setText(mContent.getContent());
        viewHolder.tvTime.setText(mContent.getDate());

        return convertView;
    }

    @Override
    public ContentBean getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        TextView tvPhone;
        TextView tvTime;
        TextView tvContent;
    }

}
