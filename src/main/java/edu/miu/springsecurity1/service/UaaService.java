package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.dto.request.LoginRequest;
import edu.miu.springsecurity1.entity.dto.response.LoginResponse;
import edu.miu.springsecurity1.entity.dto.request.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
