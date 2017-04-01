package edu.auburn.page.entity;

public class Contact{
	public int id;
	public String name;
	public String email;
	public int tel;
	public Contact(){
		
	}
	public Contact(int id, String name, String email, int tel) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tel = tel;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", tel=" + tel + "]";
	}
}
