package et.com.smpp.rest;

import com.cassiomolin.user.domain.User;
import com.cassiomolin.user.service.UserService;

import et.com.smpp.InDTOs.passwordResetRequestDTO;
import et.com.smpp.services.security.PasswordResetService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Stateless
@Path("/resetPassword")
@Api(value = "resetPassword")
public class passwordResetEndPoint {
	@Context
	  private SecurityContext securityContext;
	@Inject
	private UserService userService;

	@Inject
	private PasswordResetService passwordResetService;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@PermitAll
	public passwordResetRequestDTO passwordReset(passwordResetRequestDTO passwordResetRequestDto) {
		Principal principal = securityContext.getUserPrincipal();
		User user = this.userService.findByUsernameOrEmail(principal.getName());
		return passwordResetService.passwordReset(user,passwordResetRequestDto);
		
	}
	



}
