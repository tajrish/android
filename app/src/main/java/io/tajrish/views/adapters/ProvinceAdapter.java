package io.tajrish.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import io.tajrish.R;
import io.tajrish.models.ProvinceModel;
import io.tajrish.views.custom.FFTextView;

/**
 * Created by mehdiii on 12/18/15.
 */
public class ProvinceAdapter extends ArrayAdapter<ProvinceModel> {

    List<ProvinceModel> items;

    public ProvinceAdapter(Context context, int resource, int textViewResourceId, List<ProvinceModel> objects) {
        super(context, resource, textViewResourceId, objects);
        items = objects;
    }

    private void initViews(ProvinceModel province, ViewHolder holder) {
        holder.title.setText(province.getTitle());
        holder.stars.setImageResource(R.drawable.star);
        holder.icon.setImageResource(R.drawable.delete_button);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.province_in_grid_template, null);

            ViewHolder holder = new ViewHolder();
            holder.container = (LinearLayout) convertView.findViewById(R.id.container);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.stars = (ImageView) convertView.findViewById(R.id.stars);
            holder.title = (FFTextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        }

        initViews(items.get(position), (ViewHolder) convertView.getTag());

        return convertView;
    }

    protected class ViewHolder {
        private LinearLayout container;
        private FFTextView title;
        private ImageView stars;
        private ImageView icon;
    }
}
