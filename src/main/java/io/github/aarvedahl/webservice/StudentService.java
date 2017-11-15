package io.github.aarvedahl.webservice;

import io.github.aarvedahl.dao.DaoCourse;
import io.github.aarvedahl.dao.DaoStudent;
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
    private List<DaoStudent> daoStudents;
    private List<DaoCourse> daoCourses;

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


    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_XML)
    public List<DaoStudent> students() {
        return getDaoStudents();
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_XML)
    public DaoStudent student() {
        DaoStudent daoStudent = new DaoStudent("Alex");
        return daoStudent;
    }

    @GET
    @Path("/course")
    @Produces(MediaType.APPLICATION_XML)
    public DaoCourse getCourse() {
        DaoCourse daoCourse = new DaoCourse("Introduction To Algorithms");
        return daoCourse;
    }


    public List<DaoStudent> getDaoStudents() {
        if(daoStudents == null) {
            daoStudents = new ArrayList<>();
            DaoStudent daoStudent;
            for(Student student: getStudents()){
                daoStudent = new DaoStudent(student.getFullname());
                DaoCourse daoCourse;
                for(Course course: student.getCourses()) {
                    daoCourse = new DaoCourse(course.getCoursename());
                    daoStudent.addCourse(daoCourse);
                }
                daoStudents.add(daoStudent);
            }
        }
        return daoStudents;
    }

    public List<Student> getStudents() {
        if(students == null) {
            students = studentEJB.findAll();
        }
        return students;
    }

    public List<DaoCourse> getDaoCourses() {
        return daoCourses;
    }

    public List<Course> getCourses() {
        if(courses == null) {
            courses = courseEJB.findAll();
        }
        return courses;
    }
}
