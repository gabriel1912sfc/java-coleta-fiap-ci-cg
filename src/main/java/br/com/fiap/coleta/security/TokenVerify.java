package br.com.fiap.coleta.security;

import br.com.fiap.coleta.repository.UserRepository;
import br.com.fiap.coleta.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenVerify extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        String token = "";

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.replace("Bearer ", "").trim();

            String login = tokenService.tokenValidate(token);

            if (login != null) {
                UserDetails usuario = userRepository.findByEmail(login);

                if (usuario != null) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    usuario,
                                    null,
                                    usuario.getAuthorities()
                            );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        String path = request.getRequestURI();

// Define os endpoints públicos que não precisam de token
        if (path.equals("/api/coleta/coletas") ||
                path.equals("/api/coleta/health") ||
                path.equals("/api/coleta/idcoleta") ||
                path.equals("/auth/login") ||
                path.equals("/auth/register") ||
                (request.getMethod().equals("POST") && path.equals("/api/coleta/create")) ||
                (request.getMethod().equals("DELETE") && path.equals("/api/coleta/id"))
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        filterChain.doFilter(request, response);


    }
}
