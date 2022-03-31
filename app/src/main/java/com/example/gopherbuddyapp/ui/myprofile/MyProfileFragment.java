package com.example.gopherbuddyapp.ui.myprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.R;
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

        final TextView studyHabits = binding.studyHabits;
        myProfileViewModel.getStudyHabits().observe(getViewLifecycleOwner(), studyHabits::setText);

        final TextView coursesHeader = binding.profileCoursesHeader;
        final TextView coursesList = binding.coursesList;
        myProfileViewModel.getCourses().observe(getViewLifecycleOwner(), coursesList::setText);

        final ImageView profileSchedule = binding.profileSchedule;
        profileSchedule.setVisibility(View.GONE);

        final Button coursesButton = binding.buttonCourses;
        coursesButton.setOnClickListener(view -> {
            coursesList.setVisibility(View.VISIBLE);
            coursesHeader.setVisibility(View.VISIBLE);
            profileSchedule.setVisibility(View.GONE);
        });

        final Button scheduleButton = binding.buttonSchedule;
        scheduleButton.setOnClickListener(view -> {
            coursesList.setVisibility(View.GONE);
            coursesHeader.setVisibility(View.GONE);
            profileSchedule.setVisibility(View.VISIBLE);
        });

        final Button editButton = binding.editButton;
        editButton.setOnClickListener(view -> {
            ProfileSettingsFragment profileSettingsFragment = new ProfileSettingsFragment();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, profileSettingsFragment);
            fragmentTransaction.commit();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
