package com.example.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {
	@GetMapping("/upload")
	public String fileUploader(){
		return "file-test";
	}
}
