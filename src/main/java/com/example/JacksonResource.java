package com.example;

import com.example.model.SamplingOrder;
import com.example.model.SamplingOrderDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JacksonResource {

    @Inject
    SamplingOrderDAO dao;


    @GET
    public String list() {
        List<SamplingOrder> result = dao.listAll();
        return "ok  " + result.size() ;
    }

    @GET
    @Path("withoutTx")
    public String listWithoutTx() {
        List<SamplingOrder> result = dao.listAllWithoutTx();
        return "ok  " + result.size() ;
    }

}
