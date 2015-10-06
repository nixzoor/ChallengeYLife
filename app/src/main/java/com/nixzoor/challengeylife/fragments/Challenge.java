package com.nixzoor.challengeylife.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nixzoor.challengeylife.R;

/**
 * Created by dejan on 6.10.2015.
 */
public class Challenge extends MainFragment {

    public static Challenge newInstance(){
        Challenge fragment = new Challenge();
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.challenge_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
