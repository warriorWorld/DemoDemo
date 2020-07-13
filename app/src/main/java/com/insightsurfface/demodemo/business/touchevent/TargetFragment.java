package com.insightsurfface.demodemo.business.touchevent;

import android.os.Bundle;

import com.insightsurfface.demodemo.business.fragmentlife.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TargetFragment extends BaseFragment {
    private TouchViewModel mTouchViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTouchViewModel = new ViewModelProvider(requireActivity(), new ViewModelProvider.Factory() {
            @NonNull
            @Override
            @SuppressWarnings("unchecked")
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new TouchViewModel();
            }
        }).get(TouchViewModel.class);
    }
}
