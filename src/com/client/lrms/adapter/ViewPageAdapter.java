
package com.client.lrms.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuYozone
 */
public class ViewPageAdapter extends PagerAdapter {

    public List<View> mListViews = new ArrayList<View>();

    public ViewPageAdapter() {
    }

    public void addAll(List<View> mListViews) {
        this.mListViews.addAll(mListViews);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mListViews.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(mListViews.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(mListViews.get(arg1), 0);
        return mListViews.get(arg1);
    }

}
