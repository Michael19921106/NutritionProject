package com.test.michael.nutritionproject.ui.support;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.test.michael.nutritionproject.R;
import com.test.michael.nutritionproject.support.adapter.PagerAdapter;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-02-22
 * Time: 13:55
 * Description:
 */
public abstract class AbsTopNavigationFragment extends Fragment {

    protected View parentView;
    protected ViewPager viewPager;
    protected PagerAdapter pagerAdapter;
    protected SmartTabLayout smartTabLayout;
    protected abstract  PagerAdapter initPagerAdapter();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        pagerAdapter = initPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        smartTabLayout.setViewPager(viewPager);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = View.inflate(getContext(), R.layout.layout_top_navigation, null);
        viewPager= (ViewPager) parentView.findViewById(R.id.inner_viewpager);
        smartTabLayout = (SmartTabLayout) getActivity().findViewById(R.id.tab_layout);
        smartTabLayout.setVisibility(View.VISIBLE);
        pagerAdapter = initPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        smartTabLayout.setViewPager(viewPager);
        return parentView;

    }
}