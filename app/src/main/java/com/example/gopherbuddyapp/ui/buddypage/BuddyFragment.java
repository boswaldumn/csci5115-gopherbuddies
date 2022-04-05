package com.example.gopherbuddyapp.ui.buddypage;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentBuddyprofileBinding;
import com.example.gopherbuddyapp.ui.buddyselect.BuddySelectFragment;
import com.example.gopherbuddyapp.ui.findspace.FindSpaceViewModel;

public class BuddyFragment extends Fragment {

    private FragmentBuddyprofileBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BuddyViewModel buddyViewModel =
                new ViewModelProvider(this).get(BuddyViewModel.class);

        binding = FragmentBuddyprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy Profile");
        final ImageView buddyuserProfilePicture = binding.BuddyuserProfilePicture;
        buddyViewModel.getBuddyProfilePic().observe(getViewLifecycleOwner(), buddyuserProfilePicture::setImageResource);

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

        final Button messageButton = binding.buddypageMessageButton;
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri webpage = Uri.parse("http://discord.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);

            }

        });

        final Button unfollowButton = binding.buddypageFollowButton;
        unfollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = BuddyViewModel.getIndex();
                FindSpaceViewModel.getFindSpaceProfilePicList().add(BuddyViewModel.getBuddyProfilePicList().remove(index));
                FindSpaceViewModel.getFindSpaceNameList().add(BuddyViewModel.getBuddyNameList().remove(index));
                FindSpaceViewModel.getFindSpaceMajorList().add(BuddyViewModel.getBuddyMajorList().remove(index));
                FindSpaceViewModel.getFindSpaceCollegeList().add(BuddyViewModel.getBuddyCollegeList().remove(index));
                FindSpaceViewModel.getFindSpaceLikesList().add(BuddyViewModel.getBuddyLikesList().remove(index));
                FindSpaceViewModel.getFindSpaceDislikesList().add(BuddyViewModel.getBuddyDislikesList().remove(index));
                FindSpaceViewModel.getFindSpaceCoursesList().add(BuddyViewModel.getBuddyCoursesList().remove(index));
                BuddySelectFragment buddySelectFragment = new BuddySelectFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddySelectFragment);
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy List");
            }

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        super.onDestroy();
        binding = null;
    }
}
