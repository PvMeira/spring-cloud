package com.kenai.br.hades.service;

import com.kenai.br.hades.model.Person;
import com.kenai.br.hades.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final PersonRepository repository;

    @Autowired
    public AppUserDetailsService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user = this.repository.findByEmail(username);
        Person person = user.orElseThrow(() -> new UsernameNotFoundException("Not Found any username with these Credentials."));
        return new User(person.getEmail(), person.getPassword(), getPermission(person));
    }

    private Collection<? extends GrantedAuthority> getPermission(Person person) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        person.getPermissions()
              .forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription()
                                                                        .toUpperCase())));
        return authorities;
    }

}
