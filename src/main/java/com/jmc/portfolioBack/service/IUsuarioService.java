package com.jmc.portfolioBack.service;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmc.portfolioBack.model.Usuario;

public class IUsuarioService implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;


  @JsonIgnore
  private String password;

  public IUsuarioService(Long id, String username, String email) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public static IUsuarioService build(Usuario user) {

    return new IUsuarioService(
        user.getId(), 
        user.getUsername(),
        user.getPassword());
  }

  public Long getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }
  
  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    IUsuarioService user = (IUsuarioService) o;
    return Objects.equals(id, user.id);
  }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}