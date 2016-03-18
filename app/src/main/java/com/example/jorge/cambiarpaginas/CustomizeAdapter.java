package com.example.jorge.cambiarpaginas;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Jorge on 12/nov/2015.
 */
public class CustomizeAdapter extends PagerAdapter
{
    MainActivity mainActivity;
    private LinearLayout page;
    private TextView text4;
    private int numVistas = 0;
    public CustomizeAdapter(MainActivity mainActivity) {
        this.numVistas = 7;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount(){
        return this.numVistas;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position){
        this.page = (LinearLayout) LayoutInflater.from(mainActivity).inflate(R.layout.page_four, null);
        initListView(position);

        ((ViewPager) collection).addView(page, 0);

        return page;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public void destroyItem(View collection, int position, Object view)
    {
        ((ViewPager) collection).removeView((View) view);
    }

    private void initListView(int pos){
        text4 = (TextView)page.findViewById(R.id.numero_page);
        text4.setText("nuevo texto: "+pos);
    }
    public int generateNumber(){
        Random randomGenerator = new Random();
        int randomInt = 0;
        for (int idx = 1; idx <= 10; ++idx){
            randomInt = randomGenerator.nextInt(10);

        }
        System.out.println("Generated : " + randomInt);
        return randomInt;
    }
}