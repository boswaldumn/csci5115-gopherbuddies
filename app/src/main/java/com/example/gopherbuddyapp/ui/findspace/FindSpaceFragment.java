package com.example.gopherbuddyapp.ui.findspace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentFindspaceBinding;
import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;
import com.example.gopherbuddyapp.ui.buddypage.BuddyFragment;
import com.example.gopherbuddyapp.ui.buddypage.BuddyViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FindSpaceFragment extends Fragment {

    private @NonNull FragmentFindspaceBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (FindSpaceViewModel.getFindSpaceCollegeList().size() > 0) {
            FindSpaceViewModel findSpaceViewModel =
                    new ViewModelProvider(this).get(FindSpaceViewModel.class);

            binding = FragmentFindspaceBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            findSpaceViewModel.updateUserData();
            final ImageView findSpaceProfilePicture = binding.findSpaceProfilePicture;
            findSpaceViewModel.getProfilePic().observe(getViewLifecycleOwner(), findSpaceProfilePicture::setImageResource);

            final TextView nameText = binding.textName;
            findSpaceViewModel.getName().observe(getViewLifecycleOwner(), nameText::setText);

            final TextView majorText = binding.textMajor;
            findSpaceViewModel.getMajor().observe(getViewLifecycleOwner(), majorText::setText);

            final TextView collegeText = binding.textCollege;
            findSpaceViewModel.getCollege().observe(getViewLifecycleOwner(), collegeText::setText);

            final TextView studyHabits = binding.studyHabits;
            findSpaceViewModel.getStudyHabits().observe(getViewLifecycleOwner(), studyHabits::setText);

            final TextView coursesList = binding.coursesList;
            findSpaceViewModel.getCourses().observe(getViewLifecycleOwner(), coursesList::setText);

            final Button messageButton = binding.messageButton;
            messageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Uri webpage = Uri.parse("http://discord.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(intent);

                }

            });

            final FloatingActionButton skipUserButton = binding.skipUserButton;
            skipUserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findSpaceViewModel.updateUserData();
                    findSpaceViewModel.getProfilePic().observe(getViewLifecycleOwner(), findSpaceProfilePicture::setImageResource);
                    findSpaceViewModel.getName().observe(getViewLifecycleOwner(), nameText::setText);
                    findSpaceViewModel.getMajor().observe(getViewLifecycleOwner(), majorText::setText);
                    findSpaceViewModel.getCollege().observe(getViewLifecycleOwner(), collegeText::setText);
                    findSpaceViewModel.getStudyHabits().observe(getViewLifecycleOwner(), studyHabits::setText);
                    findSpaceViewModel.getCourses().observe(getViewLifecycleOwner(), coursesList::setText);
                }
            });

            final Button followButton = binding.followButton;
            followButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = FindSpaceViewModel.getIndex();
                    BuddyViewModel.getBuddyProfilePicList().add(FindSpaceViewModel.getFindSpaceProfilePicList().remove(index));
                    BuddyViewModel.getBuddyNameList().add(FindSpaceViewModel.getFindSpaceNameList().remove(index));
                    BuddyViewModel.getBuddyMajorList().add(FindSpaceViewModel.getFindSpaceMajorList().remove(index));
                    BuddyViewModel.getBuddyCollegeList().add(FindSpaceViewModel.getFindSpaceCollegeList().remove(index));
                    BuddyViewModel.getBuddyHabitsList().add(FindSpaceViewModel.getFindSpaceHabitsList().remove(index));
                    BuddyViewModel.getBuddyCoursesList().add(FindSpaceViewModel.getFindSpaceCoursesList().remove(index));
                    if (FindSpaceViewModel.getFindSpaceCollegeList().size() > 0) {
                        findSpaceViewModel.updateUserData();
                    } else {
                        FindSpaceEmptyFragment emptyFragment = new FindSpaceEmptyFragment();
                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, emptyFragment);
                        fragmentTransaction.commit();
                    }
                }
            });
            return root;
        } else {
            FindSpaceEmptyFragment emptyFragment = new FindSpaceEmptyFragment();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, emptyFragment);
            fragmentTransaction.commit();
            return null;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
