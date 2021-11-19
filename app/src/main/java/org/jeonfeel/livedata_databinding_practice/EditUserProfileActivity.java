package org.jeonfeel.livedata_databinding_practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jeonfeel.livedata_databinding_practice.databinding.EditUserProfileActivityBinding;

public class EditUserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditUserProfileActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EditUserProfileActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent intent = getIntent();
        binding.etPhone.setText(intent.getStringExtra("phone"));
        binding.etAddress.setText(intent.getStringExtra("address"));
        binding.btnSave.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnSave){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("phone",binding.etPhone.getText().toString());
            intent.putExtra("address",binding.etAddress.getText().toString());
            setResult(Activity.RESULT_OK,intent);
        }
        finish();
    }
}
