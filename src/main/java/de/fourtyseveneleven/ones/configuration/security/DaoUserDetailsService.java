package de.fourtyseveneleven.ones.configuration.security;

import de.fourtyseveneleven.ones.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DaoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DaoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final var user = userRepository.findOneByEmailAddress(username).orElseThrow(() -> new IllegalArgumentException("Unknown user."));
        return new DatabaseUserDetails(user);
    }
}
