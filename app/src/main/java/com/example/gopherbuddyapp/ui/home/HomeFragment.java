package com.example.gopherbuddyapp.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

<<<<<<< Updated upstream
=======


import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.R;
>>>>>>> Stashed changes
import com.example.gopherbuddyapp.databinding.FragmentHomeBinding;
import com.example.gopherbuddyapp.ui.buddyselect.BuddySelectFragment;
import com.example.gopherbuddyapp.ui.myprofile.ExternalPlatformFragment;
import com.example.gopherbuddyapp.ui.myprofile.ProfileSettingsFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

<<<<<<< Updated upstream
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
=======
        new CountDownTimer(3000, 100)  {
            public void onTick(long millisUnitlFinished) {

            }
            public void onFinish() {
                BuddySelectFragment buddySelectFragment = new BuddySelectFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddySelectFragment);
                fragmentTransaction.commit();
            }
        }.start();

>>>>>>> Stashed changes
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}