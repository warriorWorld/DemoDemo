package com.insightsurfface.demodemo.business.fragmentlife;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    public String getFragmentTag() {
        return getClass().getSimpleName();
    }
}
