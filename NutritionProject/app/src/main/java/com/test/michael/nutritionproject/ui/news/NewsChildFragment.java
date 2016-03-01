package com.test.michael.nutritionproject.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.michael.nutritionproject.R;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-02-22
 * Time: 14:19
 * Description:
 */
public class NewsChildFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_loading_failed_kk, null);
        return inflate;
    }
}