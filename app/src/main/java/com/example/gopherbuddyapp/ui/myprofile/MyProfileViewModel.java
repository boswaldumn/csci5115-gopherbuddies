package com.example.gopherbuddyapp.ui.myprofile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyProfileViewModel extends ViewModel {

    private final MutableLiveData<String> nameText;
    private final MutableLiveData<String> majorText;
    private final MutableLiveData<String> collegeText;
    private final MutableLiveData<String> studyHabitsText;
    private final MutableLiveData<String> coursesList;

    public MyProfileViewModel() {
        nameText = new MutableLiveData<>();
        nameText.setValue("Mac Intosh");

        majorText = new MutableLiveData<>();
        majorText.setValue("Computer Science Major");

        collegeText = new MutableLiveData<>();
        collegeText.setValue("College of Science and Engineering");

        studyHabitsText = new MutableLiveData<>();
        studyHabitsText.setValue("Likes:\n + Small groups (2-3 people)\n + Libraries, coffee shops, and on-campus spaces\n\n"
                                    + "Dislikes:\n - Online group work\n - Noisy environments");

        coursesList = new MutableLiveData<>();
        coursesList.setValue("PE 1015: Weight Training\nBIOL 1009: General Biology\nCSCI 1133: Introduction to Computing\nPHYS 1301: Introductory Physics\n");

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
