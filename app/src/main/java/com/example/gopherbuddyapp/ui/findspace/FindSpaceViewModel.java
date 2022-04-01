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

    private int index;
    private String[] nameList = {"Anne Droid", "Sam Sung", "Ed Vidia"};
    private String[] majorList = {"Computer Science Major", "Acting Major", "Apparel Design Major"};
    private String[] collegeList = {"College of Science and Engineering", "College of Liberal Arts", "College of Design"};
    private String[] studyHabitsList = {"Likes:\n + Small groups (2-3 people)\n\n"
                                        + "Dislikes:\n - Noisy environments\n",
                                        "Likes:\n + Medium groups (3-5 people)\n\n"
                                        + "Dislikes:\n - Noisy environments\n",
                                        "Likes:\n + Large groups (5+ people)\n\n"
                                        + "Dislikes:\n - Noisy environments\n"};
    private String[] coursesListList = {"PE 1015: Weight Training\nBIOL 1009: General Biology\n",
                                        "PE 1016: Weight Training\nBIOL 1010: General Biology\n",
                                        "PE 1017: Weight Training\nBIOL 1011: General Biology\n"};

    public FindSpaceViewModel() {
        // Initial values for demo
        index = 0;

        nameText = new MutableLiveData<>();
        nameText.setValue(nameList[index]);

        majorText = new MutableLiveData<>();
        majorText.setValue(majorList[index]);

        collegeText = new MutableLiveData<>();
        collegeText.setValue(collegeList[index]);

        studyHabitsText = new MutableLiveData<>();
        studyHabitsText.setValue(studyHabitsList[index]);

        coursesList = new MutableLiveData<>();
        coursesList.setValue(coursesListList[index]);

    }

    public void updateUserData() {
        index = index + 1;
        if(index > 2) {
            index = 0;
        }
        nameText.setValue(nameList[index]);
        majorText.setValue(majorList[index]);
        collegeText.setValue(collegeList[index]);
        studyHabitsText.setValue(studyHabitsList[index]);
        coursesList.setValue(coursesListList[index]);
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
