package at.fh.ima.swengs.recipebox.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sabine on 16.01.2018.
 */
@Service
public class Users implements UserDetailsService {

    private UserRepository repo;

    @Autowired
    public Users(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new NoSuchClientException("No customer found with email: " + email);
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (email.endsWith("admin@recipes.at")) {
            auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(email, password, auth);
    }
}