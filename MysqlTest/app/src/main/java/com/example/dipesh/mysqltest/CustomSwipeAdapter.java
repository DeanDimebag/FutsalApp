package com.example.dipesh.mysqltest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSwipeAdapter extends PagerAdapter
{
    private int[] image_resources = {R.drawable.light, R.drawable.ground, R.drawable.shower};
    private Context cont;
    private LayoutInflater layoutInflater;


    public CustomSwipeAdapter(Context cont)
    {
        this.cont = cont;
    }



    @Override
    public int getCount()
    {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
    {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        layoutInflater = (LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.slider,container,false);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.slide_image);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);
        return item_view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((LinearLayout) object);
    }
}
