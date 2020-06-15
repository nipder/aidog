package com.sec.aidog.service;

import com.sec.aidog.pojo.DevPillRecView;

import java.util.List;

public interface DevPillRecService {

    List<DevPillRecView> GetPillBindRecList(String mid);
}
