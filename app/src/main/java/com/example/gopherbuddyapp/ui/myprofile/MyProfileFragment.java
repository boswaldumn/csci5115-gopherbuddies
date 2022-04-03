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
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;

public class MyProfileFragment extends Fragment {

    private FragmentMyprofileBinding binding;
    private SettingsObject settingsObject;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (getActivity() instanceof MainActivity) {
            settingsObject = ((MainActivity) getActivity()).getSettings();
        }

        binding = FragmentMyprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView nameText = binding.textName;
        nameText.setText(settingsObject.getName());

        final TextView majorText = binding.textMajor;
        majorText.setText(settingsObject.getMajor());

        final TextView collegeText = binding.textCollege;
        collegeText.setText(settingsObject.getCollege());

        final TextView studyHabits = binding.studyHabits;
        String[] likes = settingsObject.getLikes();
        String[] dislikes = settingsObject.getDislikes();
        String studyPreferences = "Likes:\n";
        for (int i = 0; i < likes.length; i++) {
            studyPreferences += "+ " + likes[i] + "\n";
        }
        studyPreferences += "\nDislikes:\n";
        for (int i = 0; i < dislikes.length; i++) {
            studyPreferences += "- " + dislikes[i] + "\n";
        }
        studyHabits.setText(studyPreferences);

        final TextView coursesHeader = binding.profileCoursesHeader;
        final TextView coursesList = binding.coursesList;
        String[] coursesArray = settingsObject.getCourses();
        String coursesText = "";
        for (int i = 0; i < coursesArray.length; i++) {
            coursesText += coursesArray[i] + "\n";
        }
        coursesList.setText(coursesText);

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
            ProfileSettingsFragment profileSettingsFragment = new ProfileSettingsFragment(settingsObject);
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, profileSettingsFragment).addToBackStack(null);
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
