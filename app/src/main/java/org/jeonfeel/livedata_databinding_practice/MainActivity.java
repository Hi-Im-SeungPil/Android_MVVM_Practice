package org.jeonfeel.livedata_databinding_practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.jeonfeel.livedata_databinding_practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private UserProfile userProfile;
    private ActivityResultLauncher<Intent> resultLauncher;
    private UserProfileViewModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(UserProfileViewModel.class);

        model.liveData.observe(this, new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile userProfile) {
                binding.setUserProfile(userProfile);
            }
        });

        if(model.liveData.getValue() == null){
            fetchUserProfile();
        }

        resultLauncher_();
        binding.btnEdit.setOnClickListener(this);
    }

    private void fetchUserProfile(){

        userProfile = new UserProfile("홍길동","02-222","서울 강남구",0,
                "https://raw.githubusercontent.com/Hi-Im-SeungPil/moeuibitImg/main/coinlogo2/1INCH.png");
        //        binding.setUserProfile(userProfile);
        model.liveData.setValue(userProfile);
    }

    private void resultLauncher_(){

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent intent = result.getData();
                            int CallType = intent.getIntExtra("CallType",0);
                            if(CallType == 0){
                                UserProfile userProfile = model.liveData.getValue();
                                userProfile.setPhone(intent.getStringExtra("phone"));
                                userProfile.setAddress(intent.getStringExtra("address"));
                                model.liveData.setValue(userProfile);
                            }
                        }

                    }
                });
    }

    @Override
    public void onClick(View view) {
        UserProfile userProfile = model.liveData.getValue();
        Intent intent = new Intent(this,EditUserProfileActivity.class);
        intent.putExtra("CallType", 0);
        intent.putExtra("phone",userProfile.getPhone());
        intent.putExtra("address",userProfile.getAddress());
        resultLauncher.launch(intent);
    }
}
