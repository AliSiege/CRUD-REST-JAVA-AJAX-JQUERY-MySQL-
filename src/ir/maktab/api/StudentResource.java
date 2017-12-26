package ir.maktab.api;

import java.awt.List;
import java.util.ArrayList;

import javax.validation.constraints.Past;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ir.maktab.DAO.StudentDAO;
import ir.maktab.model.Student;

@Path("/students")
public class StudentResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addStudent(Student student) {
		StudentDAO s = new StudentDAO();
		s.add(student);

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateStudent(Student student) {
		StudentDAO s = new StudentDAO();
		s.update(student);
	}

	@DELETE
	  @Consumes(MediaType.APPLICATION_JSON)
	  public void deleteStudent(Student students[]) {
	    StudentDAO s = new StudentDAO();
	    for (Student student : students) {
	    	 s.delete(student.getId());
		}
	   
	  }

	@GET
	@Path("/getStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@QueryParam("id") String id) {
		StudentDAO s = new StudentDAO();
		return s.get(Integer.parseInt(id));

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList getAllStudents() {
		StudentDAO s = new StudentDAO();
		return s.getAll();
	}
}
