package com.cassiomolin.security.api.resource;

import com.cassiomolin.security.api.AuthenticationTokenDetails;
import com.cassiomolin.security.api.TokenBasedSecurityContext;
import com.cassiomolin.security.api.model.AuthenticationToken;
import com.cassiomolin.security.api.model.UserCredentials;
import com.cassiomolin.security.service.AuthenticationTokenService;
import com.cassiomolin.security.service.UsernamePasswordValidator;
import com.cassiomolin.user.domain.User;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * JAX-RS resource class that provides operations for authentication.
 *
 * @author cassiomolin
 */
@RequestScoped
@Path("auth")
public class AuthenticationResource {

    @Context
    private SecurityContext securityContext;

    @Inject
    private UsernamePasswordValidator usernamePasswordValidator;

    @Inject
    private AuthenticationTokenService authenticationTokenService;

    /**
     * Validate user credentials and issue a token for the user.
     *
     * @param credentials
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response authenticate(UserCredentials credentials) {
    	
        User user = usernamePasswordValidator.validateCredentials(credentials.getUsername(), credentials.getPassword());
        
        String token = authenticationTokenService.issueToken(user.getUsername(), user.getAuthorities());

        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);
       System.out.println("Sent" + authenticationToken.getToken());
        return Response.ok(authenticationToken).build();
    }

    /**
     * Refresh the authentication token for the current user.
     *
     * @return
     */
    @POST
    @Path("refresh")
    @Produces(MediaType.APPLICATION_JSON)
    public Response refresh() {

        AuthenticationTokenDetails tokenDetails =
                ((TokenBasedSecurityContext) securityContext).getAuthenticationTokenDetails();
        String token = authenticationTokenService.refreshToken(tokenDetails);

        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);
        return Response.ok(authenticationToken).build();
    }
}
