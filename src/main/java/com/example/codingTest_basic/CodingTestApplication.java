package com.example.codingTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CodingTestApplication {
	public static void main(String[] args) {
//		Day15 d = new Day15();
//		System.out.println(d.day15_2(new int[]{2}));

		Day16 d = new Day16();
		System.out.println(d.day16_5("programmers", "p"));

	}
}