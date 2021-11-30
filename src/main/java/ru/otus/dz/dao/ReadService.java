package ru.otus.dz.dao;

import ru.otus.dz.entity.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Service
public class ReadService {

	@Value("${file}")
	String filename;

	public List<Question> getData() throws URISyntaxException, IOException {
		List<Question> result = new LinkedList<>();
		Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
		Files.lines(path).forEach(
				l-> {
					String[] strArray = l.split(";");
					if (strArray.length > 2) {
						Question q = new Question();
						q.setText(strArray[0]);
						q.setCorrectAnswer(strArray[1]);
						List<String> variants = new LinkedList<>();
						for (int i = 2; i < strArray.length; i++)
							variants.add(strArray[i]);
						q.setVariants(variants);
						result.add(q);
					}
				}
		);
		return result;
	}
}
