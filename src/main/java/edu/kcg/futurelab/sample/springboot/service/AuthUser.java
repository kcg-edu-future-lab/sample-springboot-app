package edu.kcg.futurelab.sample.springboot.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.kcg.futurelab.sample.springboot.service.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser implements UserDetails{
	public AuthUser(User user) {
		this.user = user;
		this.admin = user.getRole().equals(User.Role.ADMIN);
		this.authorities = Arrays.asList(
			new SimpleGrantedAuthority(user.getRole().name()));
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getDisplayName() {
		return user.getDisplayName();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private User user;
	private boolean admin;
	private Collection<? extends GrantedAuthority> authorities;
	private static final long serialVersionUID = -1751393648066281567L;
}
