package com.test.michael.nutritionproject.ui.support;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.test.michael.nutritionproject.R;
import com.test.michael.nutritionproject.database.ICache;
import com.yalantis.phoenix.PullToRefreshView;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-02-21
 * Time: 17:14
 * Description:
 */
public abstract class BaseListFragment extends Fragment {
    protected View parentView;
    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected PullToRefreshView refreshView;

    protected RelativeLayout placeHolder;
    protected ProgressBar progressBar;
    protected RecyclerView.Adapter adapter;
    protected ICache cache;
    protected int mLayout = 0;
    protected boolean withHeaderTab = true;
    protected boolean withRefreshView = true;
    protected boolean needCache = true;


    protected abstract void onCreateCache();

    protected abstract RecyclerView.Adapter bindAdapter();

    protected abstract void loadFromNet();

    protected abstract void loadFromCache();

    protected abstract boolean hasData();

    protected abstract void getArgs();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayout();
        needCache = setCache();
        getArgs();
        parentView = inflater.inflate(mLayout, container, false);
        withHeaderTab = setHeaderTab();
        withRefreshView = setRefreshView();
        initView();
        return super.onCreateView(inflater, container, savedInstanceState);

    }
    protected void initView(){
        progressBar = (ProgressBar) parentView.findViewById(R.id.progressbar);
        recyclerView = (RecyclerView) parentView.findViewById(R.id.recycler_view);
        placeHolder = (RelativeLayout) parentView.findViewById(R.id.load_data_failed_layout);
        onCreateCache();

        adapter = bindAdapter();
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        refreshView = (PullToRefreshView) parentView.findViewById(R.id.pull_to_refresh);

        View view = getActivity().findViewById(R.id.tab_layout);
        if (withHeaderTab) {
            view.setVisibility(View.VISIBLE);
        } else {
            if (view != null) {
                view.setVisibility(View.GONE);
            }
        }

    }
    protected void setLayout(){
        mLayout = R.layout.layout_common_list;
    }
    protected boolean setCache() {
        return true;
    }
    protected boolean setHeaderTab() {
        return true;
    }

    protected boolean setRefreshView() {
        return true;
    }
}