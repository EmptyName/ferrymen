package com.fm.service;

import com.fm.dto.GiftObject;
import com.fm.dto.ResultJson;
import com.fm.pojo.user.FmUser;

/**
 * Created by aiyi on 2017/5/7.
 */
public interface FlowerService {

    ResultJson getAllSeed();

    ResultJson choose(Long id, FmUser user);

    ResultJson getAllProps();

    ResultJson useProps(Long id, FmUser user);

    ResultJson gift(GiftObject giftObject, FmUser user);

    ResultJson getFlowerById(Long id);

    ResultJson getFlowerDictById(Long id);

    ResultJson getAllFlower(Long uid);

    ResultJson getPropsNum(Long uid);
}
