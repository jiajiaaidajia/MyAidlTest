package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.aidlservers.Student;
import com.example.aidlservers.IMyAidlInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojiajia on 2017/4/6.
 */

public class IRemoteService extends Service {
    private ArrayList<Student> students;
    @Override
    public IBinder onBind(Intent intent) {
        students = new ArrayList<>();
        return mBinder;
    }

    private IBinder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }

        @Override
        public List<Student> addStudent(Student student) throws RemoteException {
            students.add(student);
            return students;
        }
    };
    }
