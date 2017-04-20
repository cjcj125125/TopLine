package com.head.pro.iview;

import com.head.pro.entity.Advertisement;

import java.util.List;

/**
 * Created by Jie on 2017/2/16.
 */

public interface IMainFragmentView extends IBaseView {
    /***
     * 加载广告
     * */
    void loadAdvertisement(List<Advertisement> advertisementList);
}
