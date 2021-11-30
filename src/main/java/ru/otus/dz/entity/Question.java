package ru.otus.dz.entity;

import lombok.Data;

import java.util.List;


@Data
public class Question {
	private String text;
	private String correctAnswer;
	private List<String> variants;
}
