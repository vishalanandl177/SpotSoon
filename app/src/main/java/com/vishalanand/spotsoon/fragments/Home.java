package com.vishalanand.spotsoon.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import com.vishalanand.spotsoon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {
    SliderLayout sliderLayout;

    HashMap<String, String> HashMapForURL;

    HashMap<String, Integer> HashMapForLocalRes;

    public Home() {
        // Required empty public constructor
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.FragmentTransaction fragmenttransection =
                    getActivity().getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmenttransection.replace(R.id.content, new VideosFragment());
                    fragmenttransection.commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmenttransection.replace(R.id.content, new ImagesBlankFragment());
                    fragmenttransection.commit();
                    return true;
                case R.id.navigation_notifications:
                    fragmenttransection.replace(R.id.content, new MilestoneFragment());
                    fragmenttransection.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        sliderLayout = (SliderLayout) view.findViewById(R.id.slider);

        //Call this method if you want to add images from URL .
        AddImagesUrlOnline();

        //Call this method to add images from local drawable folder .
        //AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(getActivity());

            textSliderView
                    .description(name)
                    .image(HashMapForURL.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderLayout.setCustomAnimation(new DescriptionAnimation());

        sliderLayout.setDuration(3000);

        sliderLayout.addOnPageChangeListener(this);

        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        android.support.v4.app.FragmentTransaction fragmenttransection =
                getActivity().getSupportFragmentManager().beginTransaction();
        fragmenttransection.replace(R.id.content, new VideosFragment());
        fragmenttransection.commit();
        return view;
    }

    @Override
    public void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImagesUrlOnline() {

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("CupCake", "http://androidblog.esy.es/images/cupcake-1.png");
        HashMapForURL.put("Donut", "http://androidblog.esy.es/images/donut-2.png");
        HashMapForURL.put("Eclair", "http://androidblog.esy.es/images/eclair-3.png");
        HashMapForURL.put("Froyo", "http://androidblog.esy.es/images/froyo-4.png");
        HashMapForURL.put("GingerBread", "http://androidblog.esy.es/images/gingerbread-5.png");
    }
/*
    public void AddImageUrlFormLocalRes() {

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("CupCake", R.drawable.cupcake);
        HashMapForLocalRes.put("Donut", R.drawable.donut);
        HashMapForLocalRes.put("Eclair", R.drawable.eclair);
        HashMapForLocalRes.put("Froyo", R.drawable.froyo);
        HashMapForLocalRes.put("GingerBread", R.drawable.gingerbread);

    }*/
}
