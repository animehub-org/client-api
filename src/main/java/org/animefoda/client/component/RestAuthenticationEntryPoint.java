package org.animefoda.client.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import response.ApiResponse;

import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    // Injeta o ObjectMapper já configurado pelo Spring
    public RestAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException {
        // Do NOT reset response, as it clears CORS headers
        // response.reset();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // Remove WWW-Authenticate header manually if needed
        response.setHeader("WWW-Authenticate", "");

        // Extract error message from exception
        String errorMessage = "Não autorizado. Por favor, faça login para acessar este recurso.";
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        if (authException instanceof InvalidBearerTokenException) {
            errorMessage = "Token inválido ou expirado: " + authException.getMessage();
            errorCode = ErrorCode.INVALID_TOKEN;
        } else if (authException.getMessage() != null) {
            errorMessage = authException.getMessage();
        }

        ApiResponse<?> apiResponse = ApiResponse.error(errorMessage, errorCode);
        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
    }
}
