package ru.otus.dz.dao;

import org.springframework.stereotype.Service;
import ru.otus.dz.entity.User;

import java.util.Scanner;

@Service
public class UserService {

	Scanner s = new Scanner(System.in);

	public User getUserData(){
		User user = new User();
		System.out.println("Enter your name: ");
		user.setFirstname(s.next());
		System.out.println("Enter your surname: ");
		user.setLastname(s.next());
		return user;
	}
}
