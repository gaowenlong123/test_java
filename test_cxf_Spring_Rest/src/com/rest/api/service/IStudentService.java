package com.rest.api.service;

import com.rest.api.model.Student;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * JAX-WS:webservice,一般说的是soap
 * JAX-RS：Rest service
 */
@WebService
@Path("student")

public interface IStudentService {

    //根据id查找学生
    @GET //get请求
    @Path("/query/{id}") //访问路径 。 在路径传的值，就是传给下面的方法
    @Produces(MediaType.APPLICATION_JSON)//返回给客户的数据格式
    public Student query(@PathParam("id") long id);

    //根据名字查询所有学生(张)
    @GET
    @Path("/queryList/{name}") //访问路径
//    @Produces(MediaType.APPLICATION_XML)//返回给客户的数据格式
    public List<Student> queryList(@PathParam("name") String name);
}
