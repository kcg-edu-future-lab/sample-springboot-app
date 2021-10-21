package edu.kcg.futurelab.sample.springboot.service.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {
	public enum Role{
		USER, ADMIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String username;
	private String displayName;
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User(String username, String password, String displayName, Role role) {
		this.username = username;
		this.displayName = displayName;
		this.password = password;
		this.role = role;
	}
}
