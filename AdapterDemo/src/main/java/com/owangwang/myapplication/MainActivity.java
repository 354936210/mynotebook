package com.owangwang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
List<Student> studentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.my_list);
        for (int i=0;i<20;i++){
            studentList.add(new Student("学生"+i+"号",R.mipmap.touxiang));
        }
        StudentAdapter studentAdapter=new StudentAdapter(this,studentList);
        listView.setAdapter(studentAdapter);
    }
}
