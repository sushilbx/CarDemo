package com.sushil.cardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sushil.cardemo.databinding.ActivityAddCarBinding;

import java.util.List;

public class AddCarActivity extends AppCompatActivity {
    ActivityAddCarBinding b;
    SessionManger sessionManger;
    Intent intent;
    String name = "";
    String model = "";
    String type = "";
    String color = "";
    String price = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityAddCarBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);
        sessionManger = new SessionManger(this);
        Intent intent = getIntent();
        String model = intent.getStringExtra("model");
        b.mbSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (checkForm()) {
                    addCar();
                }
            }
        });

    }

    private void addCar() {
        List<CarModel>list = sessionManger.getCarList();
        list.add(new CarModel(System.currentTimeMillis(), name,type,model,price,color));
        sessionManger.setCarList(list);
        Intent intent = new Intent(AddCarActivity.this,CarListActivity.class);
        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }

    boolean checkForm() {
        name = b.tietName.getText().toString().trim();
        model = b.tietModel.getText().toString().trim();
        type = b.tietType.getText().toString().trim();
        color = b.tietColor.getText().toString().trim();
        price = b.tietPrice.getText().toString().trim();


        if (name.isEmpty()) {
            b.tietName.setError("Car Name is empty");
            b.tietName.requestFocus();
            return false;
        } else if (name.length() < 4) {
            b.tietName.setError("Name should be minimum 3 characters");
            b.tietName.requestFocus();
            return false;
        }
        if (model.isEmpty()) {
            Toast.makeText(this, "Enter Car Model", Toast.LENGTH_SHORT).show();
            b.tietModel.setFocusableInTouchMode(true);
            b.tietModel.requestFocus();
            return false;
        } else if (model.length() < 4) {
            Toast.makeText(this, "Model Name should be minimum 4 characters", Toast.LENGTH_SHORT).show();
            b.tietModel.setFocusableInTouchMode(true);
            b.tietModel.requestFocus();
            return false;
        }
        if (type.isEmpty()) {
            Toast.makeText(this, "Enter Type(Ac or Non Ac)", Toast.LENGTH_SHORT).show();
            b.tietType.setFocusableInTouchMode(true);
            b.tietType.requestFocus();
            return false;
        } else if (type.length() < 2) {
            Toast.makeText(this, "Type should be minimum 2 characters", Toast.LENGTH_SHORT).show();
            b.tietType.setFocusableInTouchMode(true);
            b.tietType.requestFocus();
            return false;
        }
        if (color.isEmpty()) {
            Toast.makeText(this, "Enter color", Toast.LENGTH_SHORT).show();
            b.tietColor.setFocusableInTouchMode(true);
            b.tietColor.requestFocus();
            return false;
        } else if (color.length() < 3) {
            Toast.makeText(this, "color should be minimum 3 characters", Toast.LENGTH_SHORT).show();
            b.tietColor.setFocusableInTouchMode(true);
            b.tietColor.requestFocus();
            return false;
        }
        if (price.isEmpty()) {
            Toast.makeText(this, "Enter Price", Toast.LENGTH_SHORT).show();
            b.tietPrice.setFocusableInTouchMode(true);
            b.tietPrice.requestFocus();
            return false;
        } else if (price.length() < 2) {
            Toast.makeText(this, "Price should be minimum 2 characters", Toast.LENGTH_SHORT).show();
            b.tietPrice.setFocusableInTouchMode(true);
            b.tietPrice.requestFocus();
            return false;
        }


        return true;
    }
}