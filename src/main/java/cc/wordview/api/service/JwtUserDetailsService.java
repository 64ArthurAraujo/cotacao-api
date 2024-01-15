package cc.wordview.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cc.wordview.api.database.entity.Usuario;
import cc.wordview.api.service.interf.UsuarioServiceInterface;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
        private UsuarioServiceInterface userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
                        Usuario user = userService.getByEmail(email);
		
                        if (user.getEmail().equals(email)) {
                                return new User(email, user.getSenha(),
                                                new ArrayList<>());
                        } else {
                                throw new UsernameNotFoundException("Nenhum usuario encontrado com email: " + email);
                        }
                } catch (Exception e) {
                        throw new UsernameNotFoundException(e.getMessage());
                }
	}
}