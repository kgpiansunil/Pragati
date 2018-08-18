package com.example.sunil.pragati;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunil.pragati.care.cropcare;
import com.example.sunil.pragati.market.MarketActivity;
import com.example.sunil.pragati.planning.CropPlanning;

public class MainActivity extends AppCompatActivity  {

    private TextView mPlanningText;
    private TextView mCareText;
    private TextView mMarketText;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnPre, btnNext;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* mPlanningText = (TextView) findViewById(R.id.planning_text);
        mCareText = (TextView) findViewById(R.id.care_text);
        mMarketText = (TextView) findViewById(R.id.market_text);

        mPlanningText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent planning_intent = new Intent(MainActivity.this, CropPlanning.class);
                startActivity(planning_intent);


            }
        });

        mMarketText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent market_intent = new Intent(MainActivity.this, MarketActivity.class);
                startActivity(market_intent);
            }
        });

        mCareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent care_intent = new Intent(MainActivity.this, cropcare.class);
                startActivity(care_intent);
            }
        });
*/

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnPre = (Button) findViewById(R.id.btn_pre);
        btnNext = (Button) findViewById(R.id.btn_next);


        layouts = new int[]{
          R.layout.viewpager_crop_planning,
          R.layout.viewpager_crop_care,
          R.layout.viewpager_crop_market
        };

        addBottomDots(0);
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                addBottomDots(position);

                if (position == 0){
                    btnPre.setVisibility(View.GONE);
                }else {
                    btnPre.setVisibility(View.VISIBLE);
                }

                if (position == 2)
                {
                    btnNext.setVisibility(View.GONE);
                }else {
                    btnNext.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int current = getItem(+1);
                if (current<layouts.length){
                    viewPager.setCurrentItem(current);
                }

            }
        });


        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int current = getItem(-1);
                if (current > -1){
                    viewPager.setCurrentItem(current);
                }
            }
        });



    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+i;
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        private ImageView imageView;
        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            imageView = view.findViewById(R.id.img);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (viewPager.getCurrentItem()){

                        case 0:
                            Intent planning_intent = new Intent(MainActivity.this, CropPlanning.class);
                            startActivity(planning_intent);
                            break;
                        case 1:
                            Intent care_intent = new Intent(MainActivity.this, cropcare.class);
                            startActivity(care_intent);
                            break;

                        case 2:
                            Intent market_intent = new Intent(MainActivity.this, MarketActivity.class);
                            startActivity(market_intent);
                            break;

                        default:
                            break;
                    }

                }
            });
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }


    }

}
