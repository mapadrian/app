package com.aduber.uber_stars;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    Integer [] img={R.drawable.uber_1,R.drawable.uber_2,R.drawable.uber_3,R.drawable.uber_4,R.drawable.uber_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        MYJnextCustomerPager mjc=new MYJnextCustomerPager();
        viewPager.setAdapter(mjc);
        Timer tm=new Timer();
        tm.scheduleAtFixedRate(new MyTimer(),5000,5000);

    }

    private MediaSessionCompat getWindow() {
    }

    public class MyTimer extends TimerTask
    {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0)
                    {
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem()==1)
                    {
                        viewPager.setCurrentItem(2);
                    }
                    else if(viewPager.getCurrentItem()==2)
                    {
                        viewPager.setCurrentItem(3);
                    }
                    else if(viewPager.getCurrentItem()==3)
                    {
                        viewPager.setCurrentItem(4);
                    }
                    else
                    {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }



    public class MYJnextCustomerPager extends PagerAdapter
    {

        @Override
        public int getCount() {

            return img.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater lf=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=lf.inflate(R.layout.custom_view_pager,null);
            ImageView im=(ImageView)v.findViewById(R.id.imag);
            im.setImageResource(img[position]);
            ViewPager vp=(ViewPager)container;
            vp.addView(v,0);


            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager vp=(ViewPager)container;
            View v=(View)object;
            vp.removeView(v);


        }
    }
}
