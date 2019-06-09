package com.example.gregor.festhelp;// List of imgages for spontorji

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SlideAdapter2 extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    // List of imgages of sponzorji
    public int[] images2 = {

            R.drawable.sponzorji6,
            R.drawable.sponzorji2,
            R.drawable.sponzorji3,
            R.drawable.sponzorji4,
            R.drawable.sponzorji5,
            };


    public SlideAdapter2(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images2.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide2, container,false);
        LinearLayout layoutslide = view.findViewById(R.id.slideLinearLayout2);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg2);

        imgslide.setImageResource(images2[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object );
    }
}

