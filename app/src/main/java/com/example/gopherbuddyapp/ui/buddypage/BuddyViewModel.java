package com.example.gopherbuddyapp.ui.buddypage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuddyViewModel extends ViewModel {

    private final MutableLiveData<String> buddyNameText;
    private final MutableLiveData<String> buddyMajorText;
    private final MutableLiveData<String> buddyCollegeText;
    private final MutableLiveData<String> buddyStudyText;
    private final MutableLiveData<String> buddyCourseText;

    public BuddyViewModel() {
        buddyNameText = new MutableLiveData<>();
        buddyNameText.setValue("Goldy Gopher");

        buddyMajorText = new MutableLiveData<>();
        buddyMajorText.setValue("Mascot Major");

        buddyCollegeText = new MutableLiveData<>();
        buddyCollegeText.setValue("College of Liberal Arts");

        buddyStudyText = new MutableLiveData<>();
        buddyStudyText.setValue("Likes:\n + Large groups (200-300 people)\n + Stadiums, fields, and on-campus spaces\n\n"
                + "Dislikes:\n - Online group work\n - Quiet environments");

        buddyCourseText = new MutableLiveData<>();
        buddyCourseText.setValue("PE 1015: Weight Training\nPE 1012: Beginning Running\nPE 1031: Sabre Fencing\nPE 1205: Scuba and Skin Diving");
    }

    public LiveData<String> getBuddyNameText() { return buddyNameText; }
    public LiveData<String> getBuddyMajorText() { return buddyMajorText; }
    public LiveData<String> getBuddyCollegeText() { return buddyCollegeText; }
    public LiveData<String> getBuddyStudyText() { return buddyStudyText; }
    public LiveData<String> getBuddyCourseText() { return buddyCourseText; }



}
