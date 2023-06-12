package com.project.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Column(length = 10, unique = true)
	private String mobile;
    private Integer age;
    private String password;
    
    
	public User() {
		
	}
	public User(Integer user_id,String mobile, String password) {
		super();
		this.user_id = user_id;
		
		this.mobile = mobile;
		this.age = 65;
		this.password = password;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", mobile=" + mobile + ", age=" + age
				+ ", password=" + password + "]";
	}
    
    
	

}