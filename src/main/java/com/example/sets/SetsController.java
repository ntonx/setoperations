package com.example.sets;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SetsController {
	
	 @Autowired
	 TokenizerService tokenService;
	 AnalyzerService analyzer;
	 
	@PostMapping(value="/",produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String statementSubmit(@ModelAttribute Statement mychar, Model model) {
		model.addAttribute("mystatement", mychar);
		
		
		String expresion2 ="estos,datos,1,2";// "1,2,3,4,5";//mychar.content2;
		String expresion1 = "estos son mis datos";//mychar.content1;
		
/*		if(expresion1.isEmpty()||expresion2.isEmpty()) {
			return "Write two sets....empty sets to validate!!!";
		}
*/		
		
		tokenService = new TokenizerService();
		analyzer = new AnalyzerService();
	
		
		
		
		List<String> resultOne = analyzer.analizeOne(tokenService.getOperands(expresion1));
		List<String> resultTwo = analyzer.analizeOne(tokenService.getOperands(expresion2));
	
		
//		System.out.println("set1:" + resultOne);
//		System.out.println("set2:" + resultTwo);
	
		
		List<String> datos = analyzer.analyzeBoth(tokenService.getOperands(expresion1),tokenService.getOperands(expresion2));//new ArrayList<String>();
		
		System.out.println("Operations:" + datos);
		
		
		
		
		
	  return expresion1+"////"+expresion2;
	}
	
	
	    
	@GetMapping("/")
	public String statementForm(Model model) {
		model.addAttribute("mystatement", new Statement());
		return "index";
	}
		
	
		
}
