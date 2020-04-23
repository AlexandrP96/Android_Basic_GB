package com.weathergb;

import android.os.Parcel;
import android.os.Parcelable;

public class Middle implements Parcelable {

    // объект куда сохраняем город из SecondActivity
    private String cityP;


    public Middle (String city) {
        cityP = city;
    }

    // Читаем город из SecondActivity
    private Middle(Parcel in) {
        cityP = in.readString();
    }

    public static final Creator<Middle> CREATOR = new Creator<Middle>() {

        @Override
        public Middle createFromParcel(Parcel in) {
            return new Middle(in);
        }

        @Override
        public Middle[] newArray(int size) {
            return new Middle[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // Возвращаем сохранённый cityP
    String getCityP() {
        return cityP;
    }

    // Записываем город
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cityP);
    }
}
