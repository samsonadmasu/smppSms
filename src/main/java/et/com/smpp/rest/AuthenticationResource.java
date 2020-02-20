package et.com.smpp.rest;

import com.cassiomolin.security.api.AuthenticationTokenDetails;
import com.cassiomolin.security.api.TokenBasedSecurityContext;
import com.cassiomolin.security.api.model.AuthenticationToken;
import com.cassiomolin.security.api.model.UserCredentials;
import com.cassiomolin.security.service.AuthenticationTokenService;
import com.cassiomolin.security.service.UsernamePasswordValidator;
import com.cassiomolin.user.domain.User;

import et.com.smpp.OutDTOs.AllUsersLoginResponseDTO;
import et.com.smpp.services.security.TokenGeneratorService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * JAX-RS resource class that provides operations for authentication.
 *
 * @author cassiomolin
 */
@Stateless
@Path("auth")
@PermitAll
@Api(value = "securityLogin")
public class AuthenticationResource {

    @Context
    private SecurityContext securityContext;

    @Inject
    private UsernamePasswordValidator usernamePasswordValidator;

    @Inject
    private AuthenticationTokenService authenticationTokenService;

    @Inject
    private TokenGeneratorService tokenGeneratorService;

    @Path("/Admin")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @PermitAll
    public AllUsersLoginResponseDTO authenticateSuperAdmin(UserCredentials credentials) {

        System.out.println("Got================== " + credentials.getUsername());

        User user = usernamePasswordValidator.validateCredentials(credentials.getUsername(), credentials.getPassword());
        return tokenGeneratorService.authenticateUser(user);
    }

    @POST
    @Path("refresh")
    @Produces("application/json")
    public Response refresh() {

        AuthenticationTokenDetails tokenDetails =
                ((TokenBasedSecurityContext) securityContext).getAuthenticationTokenDetails();
        String token = authenticationTokenService.refreshToken(tokenDetails);

        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);
        return Response.ok(authenticationToken).build();
    }
}
