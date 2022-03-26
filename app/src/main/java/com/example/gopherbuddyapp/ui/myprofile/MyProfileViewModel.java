package com.example.gopherbuddyapp.ui.myprofile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyProfileViewModel extends ViewModel {

    private final MutableLiveData<String> nameText;
    private final MutableLiveData<String> majorText;
    private final MutableLiveData<String> collegeText;

    public MyProfileViewModel() {
        nameText = new MutableLiveData<>();
        nameText.setValue("Mac Intosh");

        majorText = new MutableLiveData<>();
        majorText.setValue("Computer Science Major");

        collegeText = new MutableLiveData<>();
        collegeText.setValue("College of Science and Engineering");
    }

    public LiveData<String> getName() {
        return nameText;
    }

    public LiveData<String> getMajor() {
        return majorText;
    }

    public LiveData<String> getCollege() { return collegeText; }
}
