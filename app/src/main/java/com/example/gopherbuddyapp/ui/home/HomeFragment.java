package com.example.gopherbuddyapp.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;

import com.example.gopherbuddyapp.databinding.FragmentHomeBinding;
import com.example.gopherbuddyapp.ui.buddyselect.BuddySelectFragment;
import com.example.gopherbuddyapp.ui.myprofile.ExternalPlatformFragment;
import com.example.gopherbuddyapp.ui.myprofile.ProfileSettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        new CountDownTimer(3000, 100)  {
            public void onTick(long millisUnitlFinished) {

            }
            public void onFinish() {
                BuddySelectFragment buddySelectFragment = new BuddySelectFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddySelectFragment);
                fragmentTransaction.commit();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
                bottomNavigationView.setVisibility(View.VISIBLE);
                bottomNavigationView.setSelectedItemId(R.id.navigation_buddyprofile);
            }
        }.start();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}