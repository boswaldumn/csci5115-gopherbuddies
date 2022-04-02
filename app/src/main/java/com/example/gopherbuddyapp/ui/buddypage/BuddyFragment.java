package com.example.gopherbuddyapp.ui.buddypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.databinding.FragmentBuddyprofileBinding;

public class BuddyFragment extends Fragment {

    private FragmentBuddyprofileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BuddyViewModel buddyViewModel =
                new ViewModelProvider(this).get(BuddyViewModel.class);

        binding = FragmentBuddyprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView buddyNameText = binding.BuddyTextName;
        buddyViewModel.getBuddyNameText().observe(getViewLifecycleOwner(), buddyNameText::setText);

        final TextView buddyMajorText = binding.BuddyTextMajor;
        buddyViewModel.getBuddyMajorText().observe(getViewLifecycleOwner(), buddyMajorText::setText);

        final TextView buddyCollegeText = binding.BuddyTextCollege;
        buddyViewModel.getBuddyCollegeText().observe(getViewLifecycleOwner(), buddyCollegeText::setText);

        final TextView buddyStudyText = binding.BuddystudyHabits;
        buddyViewModel.getBuddyStudyText().observe(getViewLifecycleOwner(), buddyStudyText::setText);

        final TextView buddyCoursesText = binding.BuddyCoursesList;
        buddyViewModel.getBuddyCourseText().observe(getViewLifecycleOwner(), buddyCoursesText::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
