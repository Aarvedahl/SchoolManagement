package io.github.aarvedahl.webservice;

import io.github.aarvedahl.DtoCourse;
import io.github.aarvedahl.DtoStudent;
import io.github.aarvedahl.entities.Course;
import io.github.aarvedahl.entities.Student;
import io.github.aarvedahl.facades.CourseFacade;
import io.github.aarvedahl.facades.StudentFacade;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/studentService")
public class StudentService {

    @EJB private StudentFacade studentEJB;
    @EJB private CourseFacade courseEJB;

    private List<Student> students;
    private List<Course> courses;
    private List<DtoStudent> dtoStudents;
    private List<DtoCourse> dtoCourses;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Hello World 2";
    }


    @GET
    @Path("/upperCase/{word}")
    @Produces(MediaType.TEXT_PLAIN)
    public String toUpperCase(@PathParam("word") String word) {
        return word.toUpperCase();
    }


    // TODO Bygg en ny frontend i ett eget projekt för att visa alla studenter
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_XML)
    public List<DtoStudent> students() {
        return getDtoStudents();
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_XML)
    public DtoStudent student() {
        DtoStudent dtoStudent = new DtoStudent("Alex");
        return dtoStudent;
    }

    @GET
    @Path("/course")
    @Produces(MediaType.APPLICATION_XML)
    public DtoCourse getCourse() {
        DtoCourse dtoCourse = new DtoCourse("Introduction To Algorithms");
        return dtoCourse;
    }


    public List<DtoStudent> getDtoStudents() {
        if(dtoStudents == null) {
            dtoStudents = new ArrayList<>();
            DtoStudent dtoStudent;
            for(Student student: getStudents()){
                dtoStudent = new DtoStudent(student.getFullname());
                DtoCourse dtoCourse;
                for(Course course: student.getCourses()) {
                    dtoCourse = new DtoCourse(course.getCoursename());
                    dtoStudent.addCourse(dtoCourse);
                }
                dtoStudents.add(dtoStudent);
            }
        }
        return dtoStudents;
    }

    public List<Student> getStudents() {
        if(students == null) {
            students = studentEJB.findAll();
        }
        return students;
    }

    public List<DtoCourse> getDtoCourses() {
        return dtoCourses;
    }

    public List<Course> getCourses() {
        if(courses == null) {
            courses = courseEJB.findAll();
        }
        return courses;
    }
}
