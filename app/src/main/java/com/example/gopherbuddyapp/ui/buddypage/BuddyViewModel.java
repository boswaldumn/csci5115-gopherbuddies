package com.example.gopherbuddyapp.ui.buddypage;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class BuddyViewModel extends ViewModel {

    private final MutableLiveData<Integer> buddyProfilePic;
    private final MutableLiveData<String> buddyNameText;
    private final MutableLiveData<String> buddyMajorText;
    private final MutableLiveData<String> buddyCollegeText;
    private final MutableLiveData<String> buddyStudyText;
    private final MutableLiveData<String> buddyCourseText;

    private static int index;
    private static ArrayList<Integer> buddyProfilePicList = new ArrayList<Integer>();
    private static ArrayList<String> buddyNameList = new ArrayList<String>();
    private static ArrayList<String> buddyMajorList = new ArrayList<String>();
    private static ArrayList<String> buddyCollegeList = new ArrayList<String>();
    private static ArrayList<String[]> buddyLikesList = new ArrayList<String[]>();
    private static ArrayList<String[]> buddyDislikesList = new ArrayList<String[]>();
    private static ArrayList<String[]> buddyCoursesList = new ArrayList<String[]>();

    public BuddyViewModel() {
        buddyProfilePic= new MutableLiveData<>();
        buddyProfilePic.setValue(buddyProfilePicList.get(index));

        buddyNameText = new MutableLiveData<>();
        buddyNameText.setValue(buddyNameList.get(index));

        buddyMajorText = new MutableLiveData<>();
        buddyMajorText.setValue(buddyMajorList.get(index));

        buddyCollegeText = new MutableLiveData<>();
        buddyCollegeText.setValue(buddyCollegeList.get(index));

        buddyStudyText = new MutableLiveData<>();
        String[] likes = getBuddyLikesList().get(index);
        String[] dislikes = getBuddyDislikesList().get(index);
        String studyPreferences = "Likes:\n";
        for (int i = 0; i < likes.length; i++) {
            studyPreferences += "+ " + likes[i] + "\n";
        }
        studyPreferences += "\nDislikes:\n";
        for (int i = 0; i < dislikes.length; i++) {
            studyPreferences += "- " + dislikes[i] + "\n";
        }
        buddyStudyText.setValue(studyPreferences);

        buddyCourseText = new MutableLiveData<>();
        String[] courses = getBuddyCoursesList().get(index);
        String coursesString = "";
        for (int i = 0; i < courses.length; i++) {
            coursesString += courses[i];
            if (i + 1 <= courses.length) {
                coursesString += "\n";
            }
        }
        buddyCourseText.setValue(coursesString);
    }

    public LiveData<Integer> getBuddyProfilePic() { return buddyProfilePic; }
    public LiveData<String> getBuddyNameText() { return buddyNameText; }
    public LiveData<String> getBuddyMajorText() { return buddyMajorText; }
    public LiveData<String> getBuddyCollegeText() { return buddyCollegeText; }
    public LiveData<String> getBuddyStudyText() { return buddyStudyText; }
    public LiveData<String> getBuddyCourseText() { return buddyCourseText; }

    public static ArrayList<Integer> getBuddyProfilePicList() { return buddyProfilePicList; }
    public static ArrayList<String> getBuddyNameList() { return buddyNameList; }
    public static ArrayList<String> getBuddyMajorList() { return buddyMajorList; }
    public static ArrayList<String> getBuddyCollegeList() { return buddyCollegeList; }
    public static ArrayList<String[]> getBuddyLikesList() { return buddyLikesList; }
    public static ArrayList<String[]> getBuddyDislikesList() { return buddyDislikesList; }
    public static ArrayList<String[]> getBuddyCoursesList() { return buddyCoursesList; }
    public static int getIndex() { return index; }
    public static void setIndex(int x) { index = x; }



}
