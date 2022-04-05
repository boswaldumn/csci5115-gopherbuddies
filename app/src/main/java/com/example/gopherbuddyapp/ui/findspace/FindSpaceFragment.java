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
import com.example.gopherbuddyapp.databinding.FragmentFindspaceemptyBinding;
import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;
import com.example.gopherbuddyapp.ui.buddypage.BuddyFragment;
import com.example.gopherbuddyapp.ui.buddypage.BuddyViewModel;
import com.example.gopherbuddyapp.ui.myprofile.SettingsObject;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FindSpaceFragment extends Fragment {

    private @NonNull FragmentFindspaceBinding binding;
    private @NonNull FragmentFindspaceemptyBinding emptyBinding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (FindSpaceViewModel.getFindSpaceCollegeList().size() > 0) {
            FindSpaceViewModel findSpaceViewModel =
                    new ViewModelProvider(this).get(FindSpaceViewModel.class);

            binding = FragmentFindspaceBinding.inflate(inflater, container, false);
            View root = binding.getRoot();
            findSpaceViewModel.updateUserData(); // Needed to allow empty page to show up when necessary
            final ImageView findSpaceProfilePicture = binding.findSpaceProfilePicture;
            findSpaceViewModel.getProfilePic().observe(getViewLifecycleOwner(), findSpaceProfilePicture::setImageResource);

            final TextView nameText = binding.textName;
            findSpaceViewModel.getName().observe(getViewLifecycleOwner(), nameText::setText);

            final TextView majorText = binding.textMajor;
            findSpaceViewModel.getMajor().observe(getViewLifecycleOwner(), majorText::setText);

            final TextView collegeText = binding.textCollege;
            findSpaceViewModel.getCollege().observe(getViewLifecycleOwner(), collegeText::setText);

            final TextView studyHeader = binding.findSpaceStudyHeader;
            findSpaceViewModel.getStudyHabitsHeader().observe(getViewLifecycleOwner(), studyHeader::setText);

            final TextView studyHabits = binding.studyHabits;
            findSpaceViewModel.getStudyHabits().observe(getViewLifecycleOwner(), studyHabits::setText);

            final TextView coursesHeader = binding.findViewCoursesHeader;
            findSpaceViewModel.getCoursesHeader().observe(getViewLifecycleOwner(), coursesHeader::setText);

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
                    findSpaceViewModel.getStudyHabitsHeader().observe(getViewLifecycleOwner(), studyHeader::setText);
                    findSpaceViewModel.getStudyHabits().observe(getViewLifecycleOwner(), studyHabits::setText);
                    findSpaceViewModel.getCoursesHeader().observe(getViewLifecycleOwner(), coursesHeader::setText);
                    findSpaceViewModel.getCourses().observe(getViewLifecycleOwner(), coursesList::setText);
                }
            });

            final FloatingActionButton followButton = binding.followButton;
            followButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = FindSpaceViewModel.getIndex();
                    BuddyViewModel.getBuddyProfilePicList().add(FindSpaceViewModel.getFindSpaceProfilePicList().remove(index));
                    BuddyViewModel.getBuddyNameList().add(FindSpaceViewModel.getFindSpaceNameList().remove(index));
                    BuddyViewModel.getBuddyMajorList().add(FindSpaceViewModel.getFindSpaceMajorList().remove(index));
                    BuddyViewModel.getBuddyCollegeList().add(FindSpaceViewModel.getFindSpaceCollegeList().remove(index));
                    BuddyViewModel.getBuddyLikesList().add(FindSpaceViewModel.getFindSpaceLikesList().remove(index));
                    BuddyViewModel.getBuddyDislikesList().add(FindSpaceViewModel.getFindSpaceDislikesList().remove(index));
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
            FindSpaceEmptyViewModel findSpaceErrorViewModel =
                    new ViewModelProvider(this).get(FindSpaceEmptyViewModel.class);

            emptyBinding = FragmentFindspaceemptyBinding.inflate(inflater, container, false);
            View root = emptyBinding.getRoot();
            FindSpaceEmptyFragment emptyFragment = new FindSpaceEmptyFragment();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, emptyFragment);
            fragmentTransaction.commit();
            return root;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}