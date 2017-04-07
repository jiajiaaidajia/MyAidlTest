package com.example.aidlservers;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by guojiajia on 2017/4/6.
 */

public class Student implements Parcelable{
    private String name;
    private int age;
    private long number;

    public Student(String name, int age, long number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }
    public Student() {
    }
    public Student(Parcel source) {//注意：这里的name  age  number 的读取顺序和下面writeToParcel()方法里面的顺序要一致，否则出错
        this.name = source.readString();
        this.age = source.readInt();
        this.number = source.readLong();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeLong(number);
    }
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        name = dest.readString();
        age = dest.readInt();
        number = dest.readLong();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[0];
        }
    };
}
