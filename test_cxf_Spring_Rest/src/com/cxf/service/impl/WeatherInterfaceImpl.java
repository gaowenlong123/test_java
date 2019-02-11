package com.cxf.service.impl;

import com.cxf.service.WeatherInterface;

public class WeatherInterfaceImpl implements WeatherInterface {

    /**
     * 根据城市获取天气信息
     * @param cityName
     * @return
     */
    public String queryWeather(String cityName){

        if("广州".equals(cityName)){
            return cityName +": 天气晴，白天最高温度30度,未天三天都晴";
        }else{
            return cityName +": 天气雨，白天最高温度30度,未天三天都雨";
        }
    }


    /**
     * 根据省份获取城市
     * @param provinceName
     * @return
     */
    public String[] getCityNameByProvince(String provinceName){
        if("广东".equals(provinceName)){
            return new String[]{"广州","深圳","珠海","东莞"};
        }else{
            return new String[]{"未开通"};
        }
    }
}
