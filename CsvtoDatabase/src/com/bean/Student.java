package com.bean;

public class Student {
	private String id;
	private String name;
	private String city;
	private String salary;
	private String designnation;
	
	public Student(String id, String name, String city, String salary, String designnation) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.designnation = designnation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDesignnation() {
		return designnation;
	}
	public void setDesignnation(String designnation) {
		this.designnation = designnation;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + ", designnation="
				+ designnation + "]";
	}

}
