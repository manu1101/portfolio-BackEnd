package com.jmc.portfolioBack.controller;

import com.jmc.portfolioBack.payload.LoginRequest;
import com.jmc.portfolioBack.payload.MessageResponse;
import com.jmc.portfolioBack.payload.UserInfoResponse;
import com.jmc.portfolioBack.repository.UsuarioRepository;
import com.jmc.portfolioBack.security.JWT;
import com.jmc.portfolioBack.service.IUsuarioService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class UsuarioController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UsuarioRepository userRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JWT jWT;

  @PostMapping("/iniciar-sesion")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    IUsuarioService userDetails = (IUsuarioService) authentication.getPrincipal();

    ResponseCookie jwtCookie = jWT.generateJwtCookie(userDetails);

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(userDetails.getId(),
                                   userDetails.getUsername()));
  }

  @PostMapping("/cerrar-sesion")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jWT.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
}