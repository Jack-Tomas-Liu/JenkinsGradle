package com.sj.jenkinsgradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.sj.multilayout.MutilAdapter;
import com.sj.ndk.SoWrapper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MutilAdapter<String> mMutiAdapter;
    private final int caption = 4<<3;
    private List<String> mDatas = new ArrayList<String>(caption);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mMutiAdapter = new MutilAdapter<>(this);
        for(int index=0;index<caption;index++){
            mDatas.add(index+"");
        }
        mMutiAdapter.setDatas(mDatas);
        mListView.setAdapter(mMutiAdapter);
        Toast.makeText(MainActivity.this,new SoWrapper().getString(),1000).show();
    }
}
