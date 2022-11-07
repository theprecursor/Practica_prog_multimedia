package com.example.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ParametroEntradaContraseñaOlvidar;
import com.example.demo.model.ParametroEntradaPass;
import com.example.demo.model.ParametrosdeEntradaLogin;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SendEmail;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private SendEmail sendEmail;
	
	@Override
	@Transactional
	public Boolean createUser(User user) {
		try {
			this.userrepository.save(user);
			return true;
		}catch(Exception e){
			System.out.println("Error creando el usuario " + e.getMessage());
			return false;
		}
	}

	@Override
	@Transactional
	public User logIn(ParametrosdeEntradaLogin login) {
		User us = null;
		try {
		us = this.userrepository.finUser(login.getEmail());
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return us;
	}

	@Override
	@Transactional
	public Boolean fpasswd(ParametroEntradaContraseñaOlvidar pforget) {
		boolean b = false;
		User us = null;
		try {
			us = this.userrepository.finUser(pforget.getEmail());
			if(us != null || (us.getEmail() != null && !us.getEmail().isEmpty())) {
				boolean envio = sendEmail.sendEmail(us.getEmail(), "FUNCIO OK", "FUNCIONA OK");
				if(envio) {
					b = true;
				}else {
					b = false;
				}
			}else {
				b = false;
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return b;
	}

	@Override
	public Boolean cpasswd(ParametroEntradaPass cpass, String email) {
		boolean b = false;
		try {
			User us = this.userrepository.finUser(email);
			us.setPasssword(cpass.getPass());
			this.userrepository.save(us);
			b = true;
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		return b;
	}
}
