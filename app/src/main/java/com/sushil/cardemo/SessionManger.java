package com.sushil.cardemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SessionManger {
    public static final String KEY_USER_DETAILS = "user_details";
    public static final String KEY_CAR_LIST = "car_list";
    private static final String PREF_NAME = "userData";
    private static final String IS_LOGIN = "isLogin";
    private static final String KEY_FIRST_TIME = "first_time";
    private static final String KEY_AUTH_DETAILS = "auth_details";
    private static SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;


    public  SessionManger(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setCarList(List<CarModel> list) {
        Log.e("response", new Gson().toJson(list));
        editor.putString(KEY_CAR_LIST, new Gson().toJson(list));
        editor.commit();
    }


    public void clearSession() {
        editor.clear();
        editor.commit();

    }

 /*   public void logoutUser() {
        clearSession();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);

    }*/

    public List<CarModel> getCarList() {
        Type carListType = new TypeToken<List<CarModel>>() {}.getType();
        return new Gson().fromJson(pref.getString(KEY_CAR_LIST, "[]"), carListType);
    }

    public boolean isLoggedIn() {

        return pref.getBoolean(IS_LOGIN, false);
    }

    public Boolean getFirstTime() {
        return pref.getBoolean(KEY_FIRST_TIME, false);
    }

    public void setFirstTime(Boolean firstTime) {
        editor.putBoolean(KEY_FIRST_TIME, firstTime);
        editor.commit();
    }

    public boolean getFirstTimeLaunch() {
        return pref.getBoolean(KEY_FIRST_TIME, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(KEY_FIRST_TIME, isFirstTime);
        editor.commit();
    }

}
