// IMyAidlInterface.aidl
package com.example.aidlservers;

import com.example.aidlservers.Student;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

     int add(int num1, int num2 );
     List<Student> addStudent(in Student student);//这里的in 一定需要的  或者out
}
