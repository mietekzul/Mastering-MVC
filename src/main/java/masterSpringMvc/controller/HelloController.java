package masterSpringMvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
//import org.springframework.social.twitter.api.SearchResults;
//import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	// @RequestMapping("/")
	//// @ResponseBody
	// public String hello(){
	// return "resultPage";
	// }

	// @RequestMapping("/")
	// public String hello(Model model){
	// model.addAttribute("message", "Hello from Controller this time");
	// return "resultPage";
	// }

	// @RequestMapping("/")
	// public String hello(@RequestParam(defaultValue="Twoja stara zapierdala")
	// String userName, Model model) {
	// model.addAttribute("message", "Hello " + userName);
	//
	// return "resultPage";
	// }

	
//	@Autowired
//	private Twitter twitter;
//	
//	@RequestMapping("/")
//	public String hello(@RequestParam(defaultValue = "masterSpringMVC4") String search, Model model) {
//
//		SearchResults searchResults = twitter.searchOperations().search(search);
//		String text = searchResults.getTweets().get(0).getText();
//		model.addAttribute("message", text);
//		
//		return "resultPage";
//	}
	
//	@RequestMapping("/")
//	public String hello(@RequestParam(defaultValue="masterSpringMVC4") String search, Model model){
//		SearchResults searchResults = twitter.searchOperations().search(search);
//		List<String> tweets = searchResults.getTweets()
//				.stream()
//				.map(Tweet::getText)
//				.collect(Collectors.toList());
//		model.addAttribute("tweets", tweets);
//		return "resultPage";
//	}
}
