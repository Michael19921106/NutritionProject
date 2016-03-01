package com.test.michael.nutritionproject.ui.material;

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
 * Time: 09:57
 * Description:
 */
public class MaterialFragment extends Fragment {

    private static MaterialFragment instance;

    protected View parentView;
    protected ViewPager viewPager;
    protected PagerAdapter pagerAdapter;
    protected SmartTabLayout smartTabLayout;

    private String[] tabNames = new String[]{"每日推荐", "课件", "教案", "试卷", "学案", "素材", "视频", "备课"};

    public static MaterialFragment getInstance() {
        if (instance == null) {
            instance = new MaterialFragment();
        }
        return instance;
    }


    protected PagerAdapter initPagerAdapter() {
        pagerAdapter = new PagerAdapter(getChildFragmentManager(),tabNames) {
            @Override
            public Fragment getItem(int position) {
                MaterialChildFragment fragment = new MaterialChildFragment();
                Bundle bundle = new Bundle();
                bundle.putString("tag_material",tabNames[position]);
                fragment.setArguments(bundle);
                return fragment;
            }
        };
        return pagerAdapter;
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


    @Override
    public void onDetach() {
        super.onDetach();
        if(getChildFragmentManager().getFragments()!=null){
            getChildFragmentManager().getFragments().clear();
        }
    }
}