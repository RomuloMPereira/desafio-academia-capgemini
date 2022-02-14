package com.romulopereira.desafiocapgemini.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/questao1")
public class QuestaoUmController {

	@GetMapping("/{nValue}")
	public ResponseEntity<String> buildHalfPyramid(@PathVariable int nValue) {
		
		String picture = "";
		for (int i = 1; i <= nValue; i++) {
			for (int w = 1; w <= nValue - i; w++) {
				picture = picture.concat("&nbsp;&nbsp;");
			}
			for (int j = 1; j <= i; j++) {
				picture = picture.concat("*");
			}
			picture = picture.concat("<br/>");
		}
		
		return ResponseEntity.ok().body(picture);
	}
}
