package org.jeonfeel.livedata_databinding_practice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {

    public MutableLiveData<UserProfile> liveData = new MutableLiveData<>();

}
