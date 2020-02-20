package et.com.smpp.services.security;

import com.cassiomolin.security.api.model.AuthenticationToken;
import com.cassiomolin.security.domain.Authority;
import com.cassiomolin.security.exception.AuthenticationException;
import com.cassiomolin.security.service.AuthenticationTokenService;
import com.cassiomolin.security.service.UsernamePasswordValidator;
import com.cassiomolin.user.domain.User;
import com.google.common.collect.Lists;
import et.com.smpp.OutDTOs.AllUsersLoginResponseDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;


@Stateless
public class TokenGeneratorService {

    @Inject
    private AuthenticationTokenService authenticationTokenService;

    @Inject
    private UsernamePasswordValidator usernamePasswordValidator;

    public AllUsersLoginResponseDTO authenticateUser(User user) {
        Iterator<Authority> authorityIterator = user.getAuthorities().iterator();
        ArrayList<Authority> authorities = Lists.newArrayList(authorityIterator);

        if (authorities.isEmpty()) {
            throw new AuthenticationException("The user is not authorized");
        }

        String role = authorities.get(0).toString();
        switch (role) {
            case "Admin":
            case "User":
                return issueToken(user, role);
        }
        throw new AuthenticationException("The user is not authorized");
    }

    private AllUsersLoginResponseDTO issueToken(User user, String role) {
        String token = authenticationTokenService.issueToken(user.getUsername(), user.getAuthorities());
        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);
        System.out.println("Sent----------------------------------------------" + authenticationToken.getToken());
        return new AllUsersLoginResponseDTO(token, role);
    }


}
