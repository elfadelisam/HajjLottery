package com.example.hajjlottery.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    MutableLiveData<String> mText = new MutableLiveData<>();

    public void getData(){
        String result = "Cong";
        mText.setValue(result);
    }
}