package com.callor.dample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/intro")
public class IntroController {

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {
		return "intro/home";
	}
}
