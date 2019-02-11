package com.cxf.service;

import javax.jws.WebService;

@WebService
public interface WeatherInterface {

    /**
     * 根据城市获取天气信息
     * @param cityName
     * @return
     */
    public String queryWeather(String cityName);

    /**
     * 根据省份获取城市
     * @param provinceName
     * @return
     */
    public String[] getCityNameByProvince(String provinceName);
}
