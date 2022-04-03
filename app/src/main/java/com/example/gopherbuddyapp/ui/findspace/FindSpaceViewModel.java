package com.example.gopherbuddyapp.ui.findspace;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class FindSpaceViewModel extends ViewModel {
    private static ArrayList<Integer> findSpaceProfilePicList = new ArrayList<Integer>();
    private static ArrayList<String> findSpaceNameList = new ArrayList<String>();
    private static ArrayList<String> findSpaceMajorList = new ArrayList<String>();
    private static ArrayList<String> findSpaceCollegeList = new ArrayList<String>();
    private static ArrayList<String> findSpaceHabitsList = new ArrayList<String>();
    private static ArrayList<String> findSpaceCoursesList = new ArrayList<String>();

    private final MutableLiveData<Integer> profilePic;
    private final MutableLiveData<String> nameText;
    private final MutableLiveData<String> majorText;
    private final MutableLiveData<String> collegeText;
    private final MutableLiveData<String> studyHabitsText;
    private final MutableLiveData<String> coursesList;

    private static int index;
    public FindSpaceViewModel() {
        // Initial values for demo
        index = 0;

        profilePic = new MutableLiveData<>();
        profilePic.setValue(findSpaceProfilePicList.get(index));

        nameText = new MutableLiveData<>();
        nameText.setValue(findSpaceNameList.get(index));

        majorText = new MutableLiveData<>();
        majorText.setValue(findSpaceMajorList.get(index));

        collegeText = new MutableLiveData<>();
        collegeText.setValue(findSpaceCollegeList.get(index));

        studyHabitsText = new MutableLiveData<>();
        studyHabitsText.setValue(findSpaceHabitsList.get(index));

        coursesList = new MutableLiveData<>();
        coursesList.setValue(findSpaceCoursesList.get(index));

    }

    public void updateUserData() {
        index = index + 1;
        if(index > findSpaceNameList.size() - 1) {
            index = 0;
        }
        profilePic.setValue(findSpaceProfilePicList.get(index));
        nameText.setValue(findSpaceNameList.get(index));
        majorText.setValue(findSpaceMajorList.get(index));
        collegeText.setValue(findSpaceCollegeList.get(index));
        studyHabitsText.setValue(findSpaceHabitsList.get(index));
        coursesList.setValue(findSpaceCoursesList.get(index));
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

    public LiveData<Integer> getProfilePic() { return profilePic; }

    public static int getIndex() { return index; }

    public static ArrayList<Integer> getFindSpaceProfilePicList() {
        return findSpaceProfilePicList;
    }

    public static ArrayList<String> getFindSpaceCollegeList() {
        return findSpaceCollegeList;
    }

    public static ArrayList<String> getFindSpaceCoursesList() {
        return findSpaceCoursesList;
    }

    public static ArrayList<String> getFindSpaceHabitsList() {
        return findSpaceHabitsList;
    }

    public static ArrayList<String> getFindSpaceMajorList() {
        return findSpaceMajorList;
    }

    public static ArrayList<String> getFindSpaceNameList() {
        return findSpaceNameList;
    }
}
