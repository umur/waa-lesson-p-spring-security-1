package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.security.JwtHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/uaa")
public class UaaController {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtHelper jwtHelper;

    public UaaController(AuthenticationManager authenticationManager,
                         UserDetailsService userDetailsService,
                         JwtHelper jwtHelper) {

        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtHelper = jwtHelper;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(),
                            request.getPassword())
            );
        } catch (BadCredentialsException e) {
            System.out.println("Bad Credentials");
            return ResponseEntity.badRequest().body("check username or password");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(request.getEmail());

        final String token = jwtHelper.generateToken(request.getEmail());
        return ResponseEntity.ok().body(token);
    }

}
