package com.example.lenovo.fangjingdong.model;

import android.support.v4.app.Fragment;


import com.example.lenovo.fangjingdong.fragment.FragmentFive;
import com.example.lenovo.fangjingdong.fragment.FragmentFour;
import com.example.lenovo.fangjingdong.fragment.FragmentOne;
import com.example.lenovo.fangjingdong.fragment.FragmentThree;
import com.example.lenovo.fangjingdong.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;


public class MainVpModel implements IMainVpModel{


    @Override
    public void setFragment(BackVP backVP) {
        List<Fragment> list=new ArrayList<>();
        list.add(new FragmentOne());
        list.add(new FragmentTwo());
        list.add(new FragmentThree());
        list.add(new FragmentFour());
        list.add(new FragmentFive());
        backVP.getRgVp(list);
    }
}
