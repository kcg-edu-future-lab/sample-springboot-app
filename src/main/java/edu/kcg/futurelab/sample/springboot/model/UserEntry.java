package edu.kcg.futurelab.sample.springboot.model;

import lombok.Data;

@Data
public class UserEntry {
	private long id;
	private String username;
	private String displayName;
	private long registeredAt;
}
