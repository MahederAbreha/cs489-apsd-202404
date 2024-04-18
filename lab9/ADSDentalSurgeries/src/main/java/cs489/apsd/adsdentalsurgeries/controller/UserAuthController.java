package cs489.apsd.adsdentalsurgeries.controller;

import cs489.apsd.adsdentalsurgeries.dto.UserAuthRequest;
import cs489.apsd.adsdentalsurgeries.security.utils.JWTManagementUtilityService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/public/auth"})
public class UserAuthController {
    private final JWTManagementUtilityService jwtManagementUtilityService;
    private final AuthenticationManager authenticationManager;


    public UserAuthController(JWTManagementUtilityService jwtManagementUtilityService,
                              AuthenticationManager authenticationManager) {
        this.jwtManagementUtilityService = jwtManagementUtilityService;
        this.authenticationManager = authenticationManager;

    }
    @PostMapping("/login")
    public String authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(), userAuthRequest.getPassword()));
        }
        catch (Exception e) {
            throw new Exception("Invalid username or password");
        }
        return jwtManagementUtilityService.generateToken(userAuthRequest.getUsername());
    }
}
