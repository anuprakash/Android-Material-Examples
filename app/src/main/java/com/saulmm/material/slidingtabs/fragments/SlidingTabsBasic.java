/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saulmm.material.slidingtabs.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saulmm.material.R;
import com.saulmm.material.slidingtabs.views.SlidingTabLayout;


public class SlidingTabsBasic extends Fragment {

    static final String LOG_TAG = "SlidingTabsBasicFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sliding, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

    }

    class SamplePagerAdapter extends PagerAdapter {
        final String [] TITLES = {"CATEGORIES", "HOME", "TOP SELLING", "TOP GAMES", "TOP GROSSING"};

        @Override
        public int getCount() {
            return 5;
        }


        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.item_sliding_pager,
                    container, false);

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }

    }
}
