package com.example.gopherbuddyapp.ui.buddyselect;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gopherbuddyapp.ui.buddypage.BuddyViewModel;

public class BuddySelectViewModel extends ViewModel {

    private static MutableLiveData<String> buddyNameOne = new MutableLiveData<>();
    private static MutableLiveData<Integer> buddyOneProfilePic = new MutableLiveData<>();

    private static MutableLiveData<String> buddyNameTwo = new MutableLiveData<>();
    private static MutableLiveData<Integer> buddyTwoProfilePic = new MutableLiveData<>();

    private static MutableLiveData<String> buddyNameThree = new MutableLiveData<>();
    private static MutableLiveData<Integer> buddyThreeProfilePic = new MutableLiveData<>();

    private static MutableLiveData<String> buddyNameFour = new MutableLiveData<>();
    private static MutableLiveData<Integer> buddyFourProfilePic = new MutableLiveData<>();
    public BuddySelectViewModel() {
        // Buddy One
        if(BuddyViewModel.getBuddyNameList().size() > 0) {
            buddyOneProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(0));
            buddyNameOne.setValue(BuddyViewModel.getBuddyNameList().get(0));
        }

        // Buddy Two
        if(BuddyViewModel.getBuddyNameList().size() > 1) {
            buddyTwoProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(1));
            buddyNameTwo.setValue(BuddyViewModel.getBuddyNameList().get(1));
        }

        // Buddy Three
        if(BuddyViewModel.getBuddyNameList().size() > 2) {
            buddyThreeProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(2));
            buddyNameThree.setValue(BuddyViewModel.getBuddyNameList().get(2));
        }

        // Buddy Four
        if(BuddyViewModel.getBuddyNameList().size() > 3) {
            buddyFourProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(3));
            buddyNameFour.setValue(BuddyViewModel.getBuddyNameList().get(3));
        }
    }

    public LiveData<String> getBuddyNameOne() { return buddyNameOne; }
    public LiveData<Integer> getBuddyOneProfilePic() { return buddyOneProfilePic; }

    public LiveData<String> getBuddyNameTwo() { return buddyNameTwo; }
    public LiveData<Integer> getBuddyTwoProfilePic() { return buddyTwoProfilePic; }

    public LiveData<String> getBuddyNameThree() { return buddyNameThree; }
    public LiveData<Integer> getBuddyThreeProfilePic() { return buddyThreeProfilePic; }

    public LiveData<String> getBuddyNameFour() { return buddyNameFour; }
    public LiveData<Integer> getBuddyFourProfilePic() { return buddyFourProfilePic; }

    public void updateUserData() {
        if(BuddyViewModel.getBuddyNameList().size() > 0) {
            buddyOneProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(0));
            buddyNameOne.setValue(BuddyViewModel.getBuddyNameList().get(0));
        }

        // Buddy Two
        if(BuddyViewModel.getBuddyNameList().size() > 1) {
            buddyTwoProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(1));
            buddyNameTwo.setValue(BuddyViewModel.getBuddyNameList().get(1));
        }

        // Buddy Three
        if(BuddyViewModel.getBuddyNameList().size() > 2) {
            buddyThreeProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(2));
            buddyNameThree.setValue(BuddyViewModel.getBuddyNameList().get(2));
        }

        // Buddy Four
        if(BuddyViewModel.getBuddyNameList().size() > 3) {
            buddyFourProfilePic.setValue(BuddyViewModel.getBuddyProfilePicList().get(3));
            buddyNameFour.setValue(BuddyViewModel.getBuddyNameList().get(3));
        }
    }
}
