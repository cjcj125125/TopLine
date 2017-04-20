package com.head.pro.factory;

import android.support.v4.app.Fragment;

import com.head.pro.R;
import com.head.pro.ui.fragment.BaseFragment;
import com.head.pro.ui.fragment.CarFragment;
import com.head.pro.ui.fragment.MainFragment;
import com.head.pro.ui.fragment.MySelfFragment;
import com.head.pro.ui.fragment.StoreFragment;

/**
 * Created by Jie on 2017/2/15.
 */

public class FragmentFactory {
    private static FragmentFactory instance;
    private BaseFragment mainFragment;
    private BaseFragment storeFragment;
    private BaseFragment carFragment;
    private BaseFragment myselfFragment;


    public static FragmentFactory getInstance() {
        if (instance == null) {
            synchronized (FragmentFactory.class) {
                if (instance == null) {
                    instance = new FragmentFactory();
                }
            }
        }
        return instance;
    }
    public Fragment getFragmentById(int id){
        switch (id){
            case R.id.main:
                if(mainFragment==null){
                    mainFragment=new MainFragment();
                }
                return mainFragment;
            case R.id.type:
                if(storeFragment==null){
                    storeFragment= new StoreFragment();
                }
                return storeFragment;
            case R.id.car:
                if(carFragment==null){
                    carFragment=new CarFragment();
                }
                return  carFragment;
            case R.id.self:
                if (myselfFragment==null){
                    myselfFragment=new MySelfFragment();
                }
                    return myselfFragment;
        }
        return null;
    }
}
