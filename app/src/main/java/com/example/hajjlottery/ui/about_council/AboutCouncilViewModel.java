package com.example.hajjlottery.ui.about_council;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class AboutCouncilViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutCouncilViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}