package com.example.demo.service;

import com.example.demo.model.ParametroEntradaContraseñaOlvidar;
import com.example.demo.model.ParametroEntradaPass;
import com.example.demo.model.ParametrosdeEntradaLogin;
import com.example.demo.model.User;

public interface UserService {

	Boolean createUser(User user);
	
	User logIn(ParametrosdeEntradaLogin login);
	
	Boolean fpasswd(ParametroEntradaContraseñaOlvidar pforget);
	
	Boolean cpasswd(ParametroEntradaPass cpass, String email);
	
}
