package com.mredrock.cyxbs.freshman.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.freshman.R;
import org.jetbrains.annotations.NotNull;

public class AcademyFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.freshman_fragment_academy, container, false);
    }


    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
    }
}
