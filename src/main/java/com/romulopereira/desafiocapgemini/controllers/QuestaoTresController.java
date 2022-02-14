package com.romulopereira.desafiocapgemini.controllers;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/questao3")
public class QuestaoTresController {

	@GetMapping("/{input}")
	public ResponseEntity<String> findAnagrams(@PathVariable String input) {
		char[] array = input.toCharArray();
		Arrays.sort(array);
		return ResponseEntity.ok().body("Ola");
	}
}
