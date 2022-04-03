package com.example.gopherbuddyapp.ui.myprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;
import com.example.gopherbuddyapp.databinding.FragmentProfileSettingsBinding;
import com.example.gopherbuddyapp.databinding.FragmentExternalPlatformBinding;

public class ProfileSettingsFragment extends Fragment {

    private FragmentProfileSettingsBinding binding;
    private FragmentExternalPlatformBinding binding2;
    private String nameText;
    private String majorText;
    private String collegeText;
    private String[] likesArray;
    private String[] dislikesArray;
    private String[] coursesArray;


    public ProfileSettingsFragment(SettingsObject settings) {
        nameText = settings.getName();
        majorText = settings.getMajor();
        collegeText = settings.getCollege();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentProfileSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.editProfileName.setText(nameText);
        binding.editMajor.setText(majorText);
        binding.editCollege.setText(collegeText);

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final Button linkPlatformsButton = binding.linkPlatformsButton;
        linkPlatformsButton.setOnClickListener(view -> {
            Fragment fragment = new ExternalPlatformFragment();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment).addToBackStack(null);
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
