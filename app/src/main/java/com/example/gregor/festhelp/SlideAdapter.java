package com.example.gregor.festhelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    // List of imgages
    public int[] images = {

            R.drawable.main_slika1,
            R.drawable.main_slika2,
            R.drawable.main_slika3,
            R.drawable.main_slika4,
            R.drawable.main_slika5};


    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container,false);
        LinearLayout layoutslide = view.findViewById(R.id.slideLinearLayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);

        imgslide.setImageResource(images[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object );
    }
}
