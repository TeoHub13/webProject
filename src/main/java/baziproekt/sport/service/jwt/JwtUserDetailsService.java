package baziproekt.sport.service.jwt;
import java.util.ArrayList;
import java.util.Arrays;

import baziproekt.sport.enums.Role;
import baziproekt.sport.model.Korisnik;
import baziproekt.sport.repository.KorisnikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final KorisnikRepository korisnikRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String kName) throws UsernameNotFoundException {
        if (korisnikRepository.findByKorisnickoIme(kName)!=null) {

            Korisnik korisnik=korisnikRepository.findByKorisnickoIme(kName);
            String pass=bcryptEncoder.encode(korisnik.getLozinka());
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(korisnik.getUloga().toString());
            return new User(korisnik.getKorisnickoIme(), pass,
                    Arrays.asList(simpleGrantedAuthority));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + kName);
        }
    }
}