package ru.otus.dz.services;

import org.springframework.stereotype.Service;
import ru.otus.dz.entity.Question;
import ru.otus.dz.entity.User;

import java.util.List;
import java.util.Scanner;

@Service
public class TestService {

	public void doTest(User user, List<Question> questions){
		Scanner s = new Scanner(System.in );
		int count=0;
		for (Question q : questions) {
			System.out.println(q.getText());
			int i=0;
			for (String v: q.getVariants())
				System.out.println(++i + ") " + v);
			System.out.println("Enter answer number:" +count);
			String answer = s.next();
			if (q.getCorrectAnswer().equals(answer))
				count++;
		}
		System.out.println(user.getFirstname() + " " + user.getLastname() + " your have " +
				((count > questions.size()/2)?"PASSED":"FAILED") + " the test");
	}

}
