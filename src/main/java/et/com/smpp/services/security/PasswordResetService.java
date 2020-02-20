package et.com.smpp.services.security;

import com.cassiomolin.security.service.PasswordEncoder;
import com.cassiomolin.user.domain.User;
import com.cassiomolin.user.service.UserService;
import et.com.smpp.InDTOs.passwordResetRequestDTO;


import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class PasswordResetService {

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private UserService userService;

    public passwordResetRequestDTO passwordReset(User user, passwordResetRequestDTO passwordResetRequestDTO) {
        String oldPassword = passwordResetRequestDTO.getOldPassword();

        if (passwordEncoder.checkPassword(oldPassword, user.getPassword())) {
            String newPwd = passwordResetRequestDTO.getPassword();
            String newHashedPwd = passwordEncoder.hashPassword(newPwd);
            boolean resetPasswordStatus = userService.resetPassword(user.getUsername(), newHashedPwd);

            passwordResetRequestDTO.setPasswordResetStatus(resetPasswordStatus);
            passwordResetRequestDTO.setMessage(" Your password has been reset successfully ");
        } else {
            passwordResetRequestDTO.setMessage(" Your password has not been reset ");

        }
        return passwordResetRequestDTO;
    }
}
