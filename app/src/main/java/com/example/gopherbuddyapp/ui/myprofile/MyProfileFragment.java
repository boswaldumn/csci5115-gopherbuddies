package com.example.gopherbuddyapp.ui.myprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;


public class MyProfileFragment extends Fragment {

    private FragmentMyprofileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyProfileViewModel myProfileViewModel =
                new ViewModelProvider(this).get(MyProfileViewModel.class);

        binding = FragmentMyprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView nameText = binding.textName;
        myProfileViewModel.getName().observe(getViewLifecycleOwner(), nameText::setText);

        final TextView majorText = binding.textMajor;
        myProfileViewModel.getMajor().observe(getViewLifecycleOwner(), majorText::setText);

        final TextView collegeText = binding.textCollege;
        myProfileViewModel.getCollege().observe(getViewLifecycleOwner(), collegeText::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
