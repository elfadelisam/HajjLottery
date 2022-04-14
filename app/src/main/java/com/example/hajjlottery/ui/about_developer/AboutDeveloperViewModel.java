package com.example.hajjlottery.ui.about_developer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutDeveloperViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutDeveloperViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is about developer fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}