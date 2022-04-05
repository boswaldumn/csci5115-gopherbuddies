package com.example.gopherbuddyapp.ui.buddyselect;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentBuddyselectBinding;
import com.example.gopherbuddyapp.ui.buddypage.BuddyFragment;
import com.example.gopherbuddyapp.ui.buddypage.BuddyViewModel;

public class BuddySelectFragment extends Fragment {

    private FragmentBuddyselectBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        BuddySelectViewModel buddySelectViewModel =
                new ViewModelProvider(this).get(BuddySelectViewModel.class);

        binding = FragmentBuddyselectBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy List");
        buddySelectViewModel.updateUserData();
        // Buddy One
        final ImageView buddyOneProfilePicture = binding.buddyOneImageView;
        final TextView buddyNameOne = binding.BuddyNameOneText;
        final Button viewBuddyOne = binding.buddyOneView;
        final View dividerOne = binding.divider3;
        if (BuddyViewModel.getBuddyNameList().size() > 0) {
            //buddySelectViewModel.getBuddyOneProfilePic().observe(getViewLifecycleOwner(), buddyOneProfilePicture::setImageResource);
            buddySelectViewModel.getBuddyOneProfilePic().observe(getViewLifecycleOwner(),
                    new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        buddyOneProfilePicture.setImageResource(integer);
                    }
                }
            );
            buddySelectViewModel.getBuddyNameOne().observe(getViewLifecycleOwner(),
                    new Observer<String>() {
                        @Override
                        public void onChanged(String newName) {
                            buddyNameOne.setText(newName);
                        }
                    }
            );
            viewBuddyOne.setOnClickListener(view -> {
                BuddyViewModel.setIndex(0);
                BuddyFragment buddyFragment = new BuddyFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddyFragment);
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy Profile");
            });
        } else {
            dividerOne.setVisibility(View.INVISIBLE);
            buddyOneProfilePicture.setVisibility(View.INVISIBLE);
            buddyNameOne.setVisibility(View.INVISIBLE);
            viewBuddyOne.setVisibility(View.GONE);
        }

        // Buddy Two
        final ImageView buddyTwoProfilePicture = binding.buddyTwoImageView;
        final TextView buddyNameTwo = binding.BuddyNameTwoText;
        final Button viewBuddyTwo = binding.buddyTwoView;
        final View dividerTwo = binding.divider4;
        if (BuddyViewModel.getBuddyNameList().size() > 1) {
            buddySelectViewModel.getBuddyTwoProfilePic().observe(getViewLifecycleOwner(),
                    new Observer<Integer>() {
                        @Override
                        public void onChanged(Integer integer) {
                            System.out.println("test");
                            buddyTwoProfilePicture.setImageResource(integer);
                        }
                    }
            );
            buddySelectViewModel.getBuddyNameTwo().observe(getViewLifecycleOwner(),
                    new Observer<String>() {
                        @Override
                        public void onChanged(String newName) {
                            buddyNameTwo.setText(newName);
                        }
                    }
            );
            viewBuddyTwo.setOnClickListener(view -> {
                BuddyViewModel.setIndex(1);
                BuddyFragment buddyFragment = new BuddyFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddyFragment);
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy Profile");
            });
        } else {
            dividerTwo.setVisibility(View.INVISIBLE);
            buddyTwoProfilePicture.setVisibility(View.INVISIBLE);
            buddyNameTwo.setVisibility(View.INVISIBLE);
            viewBuddyTwo.setVisibility(View.GONE);
        }

        // Buddy Three
        final ImageView buddyThreeProfilePicture = binding.buddyThreeImageView;
        final TextView buddyNameThree = binding.BuddyNameThreeText;
        final Button viewBuddyThree = binding.buddyThreeView;
        final View dividerThree = binding.divider5;
        if (BuddyViewModel.getBuddyNameList().size() > 2) {
            buddySelectViewModel.getBuddyThreeProfilePic().observe(getViewLifecycleOwner(),
                    new Observer<Integer>() {
                        @Override
                        public void onChanged(Integer integer) {
                            buddyThreeProfilePicture.setImageResource(integer);
                        }
                    }
            );
            buddySelectViewModel.getBuddyNameThree().observe(getViewLifecycleOwner(),
                    new Observer<String>() {
                        @Override
                        public void onChanged(String newName) {
                            buddyNameThree.setText(newName);
                        }
                    }
            );
            viewBuddyThree.setOnClickListener(view -> {
                BuddyViewModel.setIndex(2);
                BuddyFragment buddyFragment = new BuddyFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddyFragment);
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy Profile");
            });
        } else {
            dividerThree.setVisibility(View.INVISIBLE);
            buddyThreeProfilePicture.setVisibility(View.INVISIBLE);
            buddyNameThree.setVisibility(View.INVISIBLE);
            viewBuddyThree.setVisibility(View.GONE);
        }

        // Buddy Four
        final ImageView buddyFourProfilePicture = binding.buddyFourImageView;
        final TextView buddyNameFour = binding.BuddyNameFourText;
        final Button viewBuddyFour = binding.buddyFourView;
        final View dividerFour = binding.divider6;
        if (BuddyViewModel.getBuddyNameList().size() > 3) {
            buddySelectViewModel.getBuddyFourProfilePic().observe(getViewLifecycleOwner(),
                    new Observer<Integer>() {
                        @Override
                        public void onChanged(Integer integer) {
                            buddyFourProfilePicture.setImageResource(integer);
                        }
                    }
            );
            buddySelectViewModel.getBuddyNameFour().observe(getViewLifecycleOwner(),
                    new Observer<String>() {
                        @Override
                        public void onChanged(String newName) {
                            buddyNameFour.setText(newName);
                        }
                    }
            );
            viewBuddyFour.setOnClickListener(view -> {
                BuddyViewModel.setIndex(3);
                BuddyFragment buddyFragment = new BuddyFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddyFragment);
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Buddy Profile");
            });
        } else {
            dividerFour.setVisibility(View.INVISIBLE);
            buddyFourProfilePicture.setVisibility(View.INVISIBLE);
            buddyNameFour.setVisibility(View.INVISIBLE);
            viewBuddyFour.setVisibility(View.GONE);
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
