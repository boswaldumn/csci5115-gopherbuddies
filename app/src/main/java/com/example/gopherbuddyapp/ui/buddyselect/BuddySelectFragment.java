package com.example.gopherbuddyapp.ui.buddyselect;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentBuddyselectBinding;
import com.example.gopherbuddyapp.ui.buddypage.BuddyFragment;

public class BuddySelectFragment extends Fragment {

    private FragmentBuddyselectBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        BuddySelectViewModel buddySelectViewModel =
                new ViewModelProvider(this).get(BuddySelectViewModel.class);

        binding = FragmentBuddyselectBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView buddyNameOne = binding.BuddyNameOneText;
        buddySelectViewModel.getBuddyNameOne().observe(getViewLifecycleOwner(), buddyNameOne::setText);

        final Button viewBuddyOne = binding.BuddyOneView;
        viewBuddyOne.setOnClickListener(view -> {
            BuddyFragment buddyFragment = new BuddyFragment();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, buddyFragment);
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
