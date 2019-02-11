package com.gao.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gao.model.User;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebService//写与不写都没关系
@Path("/user")
public class UserServlet{
    ObjectMapper mapper = new ObjectMapper();

    //获取所有的用户
    //List<Student> {"student":[{"username","gyf"},{"username","gyf2"}]}
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String list()throws Exception{
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"gyf","123"));
        list.add(new User(2,"cdd","123"));
        list.add(new User(3,"lkq","123"));
        //现在自己转json，不由jax-rs帮我转json
        return mapper.writeValueAsString(list);
    }

    //通过id查询用户
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userById(@PathParam("id") int id)throws Exception{
        User user = new User(id,"ggg","123");//->service-dao
        return mapper.writeValueAsString(user);
    }

    @POST
    @Path("/add/{json}")
    //请求参数是json
    @Consumes(MediaType.APPLICATION_JSON)
    //响应数据是json
    @Produces(MediaType.APPLICATION_JSON)
    public String add(String json) throws IOException {
        System.out.println(json);
        //json数据可以转成对象
        User user =  mapper.readValue(json,User.class);
        System.out.println(user);

        //调用service

        return "success";
    }
}
