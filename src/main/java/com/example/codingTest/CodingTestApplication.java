package com.example.codingTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CodingTestApplication {
	public static void main(String[] args) {
		Day8 d = new Day8();
		System.out.println(d.day8_5("rermgorpsam",new int[][]{{2,3},{0,7},{5,9},{6,10}}));

	}
}