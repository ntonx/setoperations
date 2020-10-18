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
				"<h1>Sets operations</h1>"+
				"    <div class=\"container container-padding50\">\r\n" + 
				"        <table>\r\n" + 
				"            <thead>\r\n" + 
				"              <tr><th scope=\"col\">SET</th>"+
									"<th scope=\"col\">A</th>"+	
									"<th scope=\"col\">B"+
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
				"    <div class=\"container container-padding60\">\r\n" + 
				"        <table>\r\n" + 
				"            <thead>\r\n" + 
				"              <tr><th scope=\"col\">Operation</th>"+
									"<th scope=\"col\">Result</th>"+	
								"</th>"+	
								"</tr>\r\n" +
							"      </thead>\r\n" + 
							"      <tbody>\r\n" ; 
				
	}
	
public String getEnd() {
		return 	""+"            </tbody>\r\n" + 
				"          </table>\r\n" + 
				"    </div>\r\n" +"</body>\r\n" + 
				"\r\n" + 
				"</html>\r\n" + 
				"";		
	}
}
