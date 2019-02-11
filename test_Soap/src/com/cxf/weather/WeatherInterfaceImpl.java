package com.cxf.weather;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;


//@WebService
//下面的参数就是更改  该服务的wsdl.xml 中 属性的名字
@WebService(targetNamespace = "www.gyf666.com",serviceName = "weatherWS",portName = "weatherWSSoap")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)  //默认是soap 1.1 ，写上这个就是soap1.2
public class WeatherInterfaceImpl implements WeatherInterface{

    @WebMethod(operationName = "getWeatherInfo")
    @Override
    public @WebResult(name = "result") String queryWeather(@WebParam(name = "cityName") String cityName) {

        if("广州".equals(cityName)){
            return cityName +": 天气晴，白天最高温度30度,未天三天都晴";
        }else{
            return cityName +": 天气雨，白天最高温度30度,未天三天都雨";
        }
    }


}
