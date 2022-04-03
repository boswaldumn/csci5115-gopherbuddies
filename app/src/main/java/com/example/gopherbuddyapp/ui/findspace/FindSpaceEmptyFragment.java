package com.example.gopherbuddyapp.ui.findspace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.databinding.FragmentFindspaceemptyBinding;

public class FindSpaceEmptyFragment extends Fragment {

    private FragmentFindspaceemptyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FindSpaceEmptyViewModel emptyViewModel =
                new ViewModelProvider(this).get(FindSpaceEmptyViewModel.class);

        binding = FragmentFindspaceemptyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFindspaceempty;
        emptyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}