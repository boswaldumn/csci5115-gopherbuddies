package com.example.gopherbuddyapp.ui.myprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;
import com.example.gopherbuddyapp.databinding.FragmentProfileSettingsBinding;
import com.example.gopherbuddyapp.databinding.FragmentExternalPlatformBinding;
public class MyProfileFragment extends Fragment {

    private FragmentMyprofileBinding binding;
    private FragmentProfileSettingsBinding binding2;

    private ExternalPlatformFragment externalPlatformFragment;
    private static SettingsObject settingsObject;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (getActivity() instanceof MainActivity) {
            settingsObject = ((MainActivity) getActivity()).getSettings();
        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        binding = FragmentMyprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        final TextView nameText = binding.textName;
        nameText.setText(settingsObject.getName());

        final TextView majorText = binding.textMajor;
        majorText.setText(settingsObject.getMajor());

        final TextView collegeText = binding.textCollege;
        collegeText.setText(settingsObject.getCollege());

        final TextView studyHabits = binding.studyHabits;
        String[] likes = settingsObject.getLikes();
        String[] dislikes = settingsObject.getDislikes();
        String studyPreferences = "";
        if (likes.length != 0 && !likes[0].equals("")) {
            studyPreferences = "Likes:\n";
            for (int i = 0; i < likes.length; i++) {
                studyPreferences += "+ " + likes[i] + "\n";
            }
            studyPreferences += "\n";
        }
        if (dislikes.length != 0 && !dislikes[0].equals("")) {
            studyPreferences += "Dislikes:\n";
            for (int i = 0; i < dislikes.length; i++) {
                studyPreferences += "- " + dislikes[i] + "\n";
            }
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
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, profileSettingsFragment);
            fragmentTransaction.commit();
        });

        return root;
    }

    public static SettingsObject getSettingsObject() {
        return settingsObject;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}