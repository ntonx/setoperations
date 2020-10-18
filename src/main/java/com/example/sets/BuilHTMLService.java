package com.example.sets;

import org.springframework.stereotype.Service;

@Service
public class BuilHTMLService {

	public BuilHTMLService() {}
	
	public String getHead() {
		return "<!DOCTYPE HTML>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
				"    <link rel=\"stylesheet\" href=\"css/mystyle.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"css/main2.css\">\r\n" + 
				"	<title>Computational Mathematics</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"<h1 class=\"h1\">Sets operations</h1>"+
				"    <div class=\"container container-padding50\">\r\n" + 
				"        <table>\r\n" + 
				"            <thead >\r\n" + 
				"              <tr><th style=\"color: white;background-color: #2F4F4F\" scope=\"col\">Property \\ Set</th>"+
									"<th style=\"color: white;background-color: #2F4F4F\"scope=\"col\">A</th>"+	
									"<th style=\"color: white;background-color: #2F4F4F\"scope=\"col\">B"+
								"</th>"+	
								"</tr>\r\n" +
							"      </thead>\r\n" + 
							"      <tbody>\r\n" ; 
	}
	
	
	
	public String getMiddle() {
	
		
		return "\r\n" + 
				"              \r\n" + 
				"            </tbody>\r\n" + 
				"          </table>\r\n" + 
				"    </div>\r\n" +
				"<br>"+
				"    <div class=\"container container-padding60\">\r\n" + 
				"        <table>\r\n" + 
				"            <thead>\r\n" + 
				"              <tr><th style=\"color: white;background-color: #2F4F4F\"scope=\"col\">Operation</th>"+
									"<th style=\"color: white;background-color: #2F4F4F\" scope=\"col\">Result</th>"+	
								"</th>"+	
								"</tr>\r\n" +
							"      </thead>\r\n" + 
							"      <tbody>\r\n" ; 
				
	}
	
public String getEnd() {
		return 	""+"            </tbody>\r\n" + 
				"          </table>\r\n" + 
				"    </div>\r\n" 
				+
				" <style>\r\n" + 
				".footer {\r\n" + 
				"  left: 0;\r\n" + 
				"border-top-width: .6px;\r\n" + 
				"border-top-style: solid;\r\n" + 
				"border-bottom-style: solid;\r\n" + 
				"border-bottom-width: 1px;\r\n" + 
				"margin-top: 6px;"+
				"  bottom: 0;\r\n" + 
				"  width: 100%;\r\n" + 
				"  background-color: #2F4F4F;\r\n" + 
				"  color: white;\r\n" + 
				"  text-align: center;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"<div class=\"footer\">\r\n" + 
				"  <p>By Antonio Nicolas Plata. CINVESTAV 2020</p>\r\n" + 
				"</div> "+
				"\r\n" + 
				
				"</html>\r\n" + 
				"";		
	}
}
