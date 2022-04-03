package com.example.gopherbuddyapp.ui.findspace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindSpaceEmptyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FindSpaceEmptyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("The Find Space is currently empty. Please check back later.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}