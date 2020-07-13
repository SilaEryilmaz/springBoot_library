package com.example.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.web.service.LoginService;
import com.example.web.service.LibraryService;

@Controller
@SessionAttributes("reader")
public class LibraryController {
	
	@Autowired
	LibraryService lservice;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public String getBooks(ModelMap model){
		String reader = (String) model.get("reader");
		model.put("books", lservice.showBooks(reader));
		return "books";
	}
	@RequestMapping(value="/addbooks", method = RequestMethod.GET)
	public String getAddBooks(ModelMap model){
		return "add-book";
	}

	@RequestMapping(value="/addbooks", method = RequestMethod.POST)
	public String addBooks(ModelMap model, @RequestParam String author,@RequestParam String bookName){
		model.put("Author", author);
		model.put("BookName", bookName);
		lservice.addBook((String) model.get("reader"),author,bookName,new Date() );
		
		return "redirect:/books";
	}
}