package com.romulopereira.desafiocapgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.romulopereira.desafiocapgemini.models.User;
import com.romulopereira.desafiocapgemini.services.QuestaoDoisService;

@RestController
@RequestMapping(value = "/questao2")
public class QuestaoDoisController {

	@Autowired
	QuestaoDoisService service;
	
	@PostMapping
	public ResponseEntity<Integer> informMissingCharacters(@RequestBody User user){
		
		Integer missingChar = service.informMissingCharacters(user.password);
		
		return ResponseEntity.ok().body(missingChar);
	}
}
