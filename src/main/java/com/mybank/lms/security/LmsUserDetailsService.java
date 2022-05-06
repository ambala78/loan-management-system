package com.mybank.lms.security;

import com.mybank.lms.domain.LmsUser;
import com.mybank.lms.repositories.LmsUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LmsUserDetailsService implements UserDetailsService {
    private LmsUserRepository lmsUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LmsUser> lmsUser = lmsUserRepository.findById(username);
        return new LmsUserDetails(lmsUser.get());
    }

    static final class LmsUserDetails extends LmsUser implements UserDetails {
//        private static final List<GrantedAuthority> ROLE_USER = Collections
//            .unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

        LmsUserDetails(LmsUser lmsUser) {
            super(lmsUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections
                .unmodifiableList(AuthorityUtils.createAuthorityList(getLmsUserrole()));
        }

        @Override
        public String getPassword() {
            return getLmsUserpass();
        }

        @Override
        public String getUsername() {
            return getLmsUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
