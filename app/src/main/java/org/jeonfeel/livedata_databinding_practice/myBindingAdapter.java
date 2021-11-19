package org.jeonfeel.livedata_databinding_practice;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class myBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void loadImageUrl(ImageView imageView,String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

}
