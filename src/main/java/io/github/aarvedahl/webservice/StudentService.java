package io.github.aarvedahl.webservice;

import io.github.aarvedahl.dao.DaoStudent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/studentService")
public class StudentService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Hello World 2";
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_XML)
    public DaoStudent getStudent() {
        DaoStudent pojoStudent = new DaoStudent(1, "Alex", "kg");
        return pojoStudent;
    }

    @GET
    @Path("/upperCase/{word}")
    @Produces(MediaType.TEXT_PLAIN)
    public String toUpperCase(@PathParam("word") String word) {
        return word.toUpperCase();
    }


    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getString() {
        return "";


    }
}
