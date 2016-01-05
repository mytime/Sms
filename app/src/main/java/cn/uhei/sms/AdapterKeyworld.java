package cn.uhei.sms;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 关键词 适配器
 */
public class AdapterKeyworld extends BaseAdapter {
    private Context context;
    private List<ContentBean> contents;

    //构造方法
    public AdapterKeyworld(Context context, List<ContentBean> contents) {
        this.context = context;
        this.contents = contents;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.phone_item_list,null);
            holder.tvKeyworld = (TextView) convertView.findViewById(R.id.tvPhone);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        ContentBean mContent = getItem(position);
        //获取 关键词
        holder.tvKeyworld.setText(mContent.getKeyworld());
        return convertView;
    }

    static class ViewHolder{
        TextView tvKeyworld;
    }

    @Override
    public ContentBean getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
