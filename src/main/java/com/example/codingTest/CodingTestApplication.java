package com.example.codingTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CodingTestApplication {
	public static void main(String[] args) {
		Day10 d = new Day10();
		System.out.println(d.day10_3("Progra21Sremm3", 6,12));
	}
}