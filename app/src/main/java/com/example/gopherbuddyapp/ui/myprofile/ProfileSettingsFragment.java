package com.example.gopherbuddyapp.ui.myprofile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.databinding.FragmentProfileSettingsBinding;

public class ProfileSettingsFragment extends Fragment {

    private FragmentProfileSettingsBinding binding;
    private String nameText;
    private String majorText;
    private String collegeText;
    private SettingsObject currentSettings;

    public ProfileSettingsFragment(SettingsObject settings) {
        nameText = settings.getName();
        majorText = settings.getMajor();
        collegeText = settings.getCollege();
        currentSettings = settings;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentProfileSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.editProfileName.setText(nameText);
        binding.editProfileName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nameText = editable.toString();
                updateSettings();
            }
        });

        binding.editMajor.setText(majorText);
        binding.editMajor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                majorText = editable.toString();
                updateSettings();
            }
        });

        binding.editCollege.setText(collegeText);
        binding.editCollege.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                collegeText = editable.toString();
                updateSettings();
            }
        });

        String[] likes = currentSettings.getLikes();
        String likesString = "";
        for (int i = 0; i < likes.length; i++) {
            likesString += likes[i];
            if (i + 1 <= likes.length) {
                likesString += "\n";
            }
        }
        binding.editLikes.setText(likesString);
        binding.editLikes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String[] updatedLikes = editable.toString().split("\n");
                currentSettings.setLikes(updatedLikes);
                updateSettings();
            }
        });

        String[] dislikes = currentSettings.getDislikes();
        String dislikesString = "";
        for (int i = 0; i < dislikes.length; i++) {
            dislikesString += dislikes[i];
            if (i + 1 <= dislikes.length) {
                dislikesString += "\n";
            }
        }
        binding.editDislikes.setText(dislikesString);
        binding.editDislikes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String[] updatedDislikes = editable.toString().split("\n");
                currentSettings.setDislikes(updatedDislikes);
                updateSettings();
            }
        });
        String[] courses = currentSettings.getCourses();
        String coursesString = "";
        for (int i = 0; i < courses.length; i++) {
            coursesString += courses[i];
            if (i + 1 <= courses.length) {
                coursesString += "\n";
            }
        }

        binding.editCourses.setText(coursesString);
        binding.editCourses.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String[] updatedCourses = editable.toString().split("\n");
                currentSettings.setCourses(updatedCourses);
                updateSettings();
            }
        });

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        return root;
    }

    public void updateSettings() {
        currentSettings.setName(nameText);
        currentSettings.setMajor(majorText);
        currentSettings.setCollege(collegeText);
        ((MainActivity) getActivity()).updateSettings(currentSettings);
    }

}