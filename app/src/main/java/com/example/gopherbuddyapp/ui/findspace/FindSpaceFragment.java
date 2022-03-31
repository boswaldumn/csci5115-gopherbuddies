package com.example.gopherbuddyapp.ui.findspace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gopherbuddyapp.databinding.FragmentFindspaceBinding;
import com.example.gopherbuddyapp.databinding.FragmentMyprofileBinding;


public class FindSpaceFragment extends Fragment {

    private @NonNull FragmentFindspaceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FindSpaceViewModel findSpaceViewModel =
                new ViewModelProvider(this).get(FindSpaceViewModel.class);

        binding = FragmentFindspaceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
