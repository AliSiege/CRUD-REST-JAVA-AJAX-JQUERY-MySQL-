package ir.maktab.model;

public class Teacher {

	private int id;
	private String name;
	private String dept;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Teacher() {

	}

	public Teacher(String name) {
		this.name = name;
	}

	public Teacher(int id) {
		this.id = id;
	}
	

	public Teacher(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Teacher(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}

	public Teacher(int id, String name, String dept, String address) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.address = address;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", dept=" + dept + ", address=" + address + "]";
	}

	

}
