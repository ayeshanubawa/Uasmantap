package com.ahl.uasmantap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MovieAdapter extends BaseAdapter {

    private ArrayList<MovieItems> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context context;


    public MovieAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<MovieItems> items) {
        mData = items;
        notifyDataSetChanged();
    }

    public void addItem(final MovieItems item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData.clear();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getCount() {
        //Check null if no value, return 0 no view
        if (mData == null) return 0;
        return mData.size();
    }

    @Override
    public MovieItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //holder is used to hold value
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.movie_row_list, null);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvCategory = (TextView) convertView.findViewById(R.id.tv_dateRelease);
            holder.imgMeal = (ImageView) convertView.findViewById(R.id.image);
            holder.tvArea = (TextView) convertView.findViewById(R.id.tv_date);
            holder.tvInstructions = (TextView) convertView.findViewById(R.id.tv_detail_overview);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        /*
        holder.tvTitle.setText(mData.get(position).getMovTitle());
        holder.tvOverview.setText(mData.get(position).getMovOverview().substring(0,40)+"...");

        String collectDate = mData.get(position).getMovDateRelease();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(collectDate);

            SimpleDateFormat new_dateFormat = new SimpleDateFormat("yyyy");
            SimpleDateFormat new_dateFormat2 = new SimpleDateFormat("EEEE, dd MMM yyyy");
            String date_of_release = new_dateFormat.format(date);
            String date_of_release2 = new_dateFormat2.format(date);
            holder.tvReleaseDate.setText(date_of_release);
            holder.tvDate.setText(date_of_release2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Picasso.get().load("http://image.tmdb.org/t/p/w185/" + mData.get(position).getMovImage()).
                placeholder(context.getResources().getDrawable(R.drawable.no_image)).
                error(context.getResources().getDrawable(R.drawable.no_image)).into(holder.imgMovie);
        */
        holder.tvName.setText(mData.get(position).getMealName());
        holder.tvCategory.setText(mData.get(position).getMealCategory());
        holder.tvArea.setText(mData.get(position).getMealArea());
        holder.tvInstructions.setText(mData.get(position).getMealInstructions().substring(0,40)+"...");

        Picasso.get().load(mData.get(position).getMealImage()).
                placeholder(context.getResources().getDrawable(R.drawable.no_image)).
                error(context.getResources().getDrawable(R.drawable.no_image)).into(holder.imgMeal);

        return convertView;

    }

    private static class ViewHolder {
        TextView tvName;
        TextView tvCategory;
        ImageView imgMeal;
        TextView tvArea;
        TextView tvInstructions;

        TextView tvTitle;
        TextView tvReleaseDate;
        ImageView imgMovie;
        TextView tvDate;
        TextView tvOverview;
    }
}