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