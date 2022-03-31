package com.example.gopherbuddyapp.ui.findspace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindSpaceViewModel extends ViewModel {

    private final MutableLiveData<String> nameText;
    private final MutableLiveData<String> majorText;
    private final MutableLiveData<String> collegeText;
    private final MutableLiveData<String> studyHabitsText;
    private final MutableLiveData<String> coursesList;

    public FindSpaceViewModel() {
        nameText = new MutableLiveData<>();
        nameText.setValue("Anne Droid");

        majorText = new MutableLiveData<>();
        majorText.setValue("Computer Science Major");

        collegeText = new MutableLiveData<>();
        collegeText.setValue("College of Science and Engineering");

        studyHabitsText = new MutableLiveData<>();
        studyHabitsText.setValue("Likes:\n + Small groups (2-3 people)\n\n"
                                    + "Dislikes:\n - Noisy environments\n");

        coursesList = new MutableLiveData<>();
        coursesList.setValue("PE 1015: Weight Training\nBIOL 1009: General Biology\n");

    }

    public LiveData<String> getName() {
        return nameText;
    }

    public LiveData<String> getMajor() {
        return majorText;
    }

    public LiveData<String> getCollege() { return collegeText; }

    public LiveData<String> getStudyHabits() { return studyHabitsText; }

    public LiveData<String> getCourses() { return coursesList; }
}
