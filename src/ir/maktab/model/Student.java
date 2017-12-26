package ir.maktab.model;

public class Student {
	private int id;
	private String name;
	private String dept;
	private int prof_id;
	
	public Student(int id, String name, String dept, int prof_id) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.prof_id = prof_id;
	}
	public int getprof_id() {
		return prof_id;
	}
	public void setprof_id(int prof_id) {
		this.prof_id = prof_id;
	}
	public String getDept() {
		return dept;
	}

	public Student() {
		super();
	}
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [ID=" + id + ", Name=" + name + ", Department=" + dept + ", Professor ID=" + prof_id + "]";
	}
	public Student(int id) {
		super();
		this.id = id;
	}
	
}
