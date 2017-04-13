package com.example.myservices;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haitai on 2017/4/13.
 */


public class Person implements Parcelable {

    private  int age;
    private String name;
    private  double height;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

        public Person(String name,int age,double height){
            this.name=name;
            this.age=age;
            this.height=height;

        }

    protected Person(Parcel in) {
        age= in.readInt();
        name=in.readString();
        height=in.readDouble();

    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeInt(age);
        dest.writeString(name);
        dest.writeDouble(height);
    }
}
