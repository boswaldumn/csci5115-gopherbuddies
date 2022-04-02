package com.example.gopherbuddyapp.ui.buddypage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuddyViewModel extends ViewModel {

    private final MutableLiveData<String> buddyText;

    public BuddyViewModel() {
        buddyText = new MutableLiveData<>();
        buddyText.setValue("This is a buddy fragment");
    }

    public LiveData<String> getBuddyText() { return buddyText; }

}
