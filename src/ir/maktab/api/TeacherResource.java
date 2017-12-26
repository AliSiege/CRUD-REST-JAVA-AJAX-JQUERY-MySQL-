package ir.maktab.api;

import java.awt.List;
import java.util.ArrayList;

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

import ir.maktab.DAO.TeacherDAO;
import ir.maktab.model.Teacher;

@Path("/teachers")
public class TeacherResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTeacher(Teacher Teacher) {
		TeacherDAO t = new TeacherDAO();
		t.add(Teacher);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTeacher(Teacher teacher) {
		TeacherDAO t = new TeacherDAO();
		t.update(teacher);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteTeacher(Teacher teachers[]) {
		TeacherDAO t = new TeacherDAO();
		for (Teacher teacher : teachers) {
			t.delete(teacher.getId());
		}
		
	}

	@GET
	@Path("/getTeacher")
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher getTeacher(@QueryParam("id") String id) {
		TeacherDAO t = new TeacherDAO();
		return t.get(Integer.parseInt(id));

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList getAllTeachers() {
		TeacherDAO t = new TeacherDAO();
		return t.getAll();
	}
}
