package com.test.michael.nutritionproject.ui.news;

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
 * Date: 2016-02-21
 * Time: 17:13
 * Description:
 */
public class NewsFragment extends Fragment {

    private static NewsFragment instance;
    protected View parentView;
    protected ViewPager viewPager;
    protected PagerAdapter pagerAdapter;
    protected SmartTabLayout smartTabLayout;

    private String[] tabNames = new String[]{"每日推荐", "专家观点", "学科资讯",
            "高考热点", "中考热点", "政策解读", "改革热点", "其他资讯"};


    public static NewsFragment getInstance() {
        if (instance == null) {
            instance = new NewsFragment();
        }
        return instance;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(getChildFragmentManager().getFragments()!=null){
            getChildFragmentManager().getFragments().clear();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        pagerAdapter.notifyDataSetChanged();
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


    protected PagerAdapter initPagerAdapter() {
        pagerAdapter = new PagerAdapter(getChildFragmentManager(),tabNames) {
            @Override
            public Fragment getItem(int position) {
                NewsChildFragment fragment = new NewsChildFragment();
                Bundle bundle = new Bundle();
                bundle.putString("tag_news",tabNames[position]);
                fragment.setArguments(bundle);
                return fragment;
            }
        };
        return pagerAdapter;
    }
}