package com.example.jorge.cambiarpaginas;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jorge on 12/nov/2015.
 */
public class MainPageAdapter extends PagerAdapter
{
    MainActivity mainActivity;
    private LinearLayout page1;
    private LinearLayout page2;
    private ListView page3;
    private LinearLayout page4;

    public MainPageAdapter(MainActivity mainActivity, LinearLayout page1, LinearLayout page2, ListView page3, LinearLayout page4) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        this.page4 = page4;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position)
    {
        View page = null;
        switch (position)
        {
            case 0:
                if (page1 == null)
                {
                    page1 = (LinearLayout) LayoutInflater.from(mainActivity).inflate(R.layout.page_one, null);
                }
                page = page1;
                break;
            case 1:
                if (page2 == null)
                {
                    page2 = (LinearLayout) LayoutInflater.from(mainActivity).inflate(R.layout.page_two, null);
                }
                page = page2;
                break;
            case 2:
                if (page3 == null)
                {
                    page3 = (ListView) LayoutInflater.from(mainActivity).inflate(R.layout.page_three, null);
                    initListView();
                }
                page = page3;
                break;
            default:
                if (page4 == null)
                {
                    page4 = (LinearLayout) LayoutInflater.from(mainActivity).inflate(R.layout.page_four, null);
                }
                page = page4;
                break;
        }

        ((ViewPager) collection).addView(page, 0);

        return page;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public void destroyItem(View collection, int position, Object view)
    {
        ((ViewPager) collection).removeView((View) view);
    }

    private void initListView()
    {
        ListView listView = (ListView) page3.findViewById(R.id.listView1);
        String[] items = new String[50];
        for (int i = 0; i < 50; i++)
        {
            items[i] = "Item " + i;
        }
        page3.setAdapter(new ArrayAdapter<String>(mainActivity, R.layout.textview, items));
        page3.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mainActivity, (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}