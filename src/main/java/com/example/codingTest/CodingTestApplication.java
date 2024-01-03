package com.example.codingTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CodingTestApplication {

	public static void main(String[] args) {
		Day5 d = new Day5();
		System.out.println(d.day5_1("abc1abc1abc"));

	}
}