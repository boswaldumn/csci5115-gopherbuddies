package com.example.gopherbuddyapp.ui.buddyselect;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuddySelectViewModel extends ViewModel {

    private final MutableLiveData<String> buddyNameOne;

    public BuddySelectViewModel() {
        buddyNameOne = new MutableLiveData<>();
        buddyNameOne.setValue("Goldy Gopher");
    }

    public LiveData<String> getBuddyNameOne() { return buddyNameOne; }
}
