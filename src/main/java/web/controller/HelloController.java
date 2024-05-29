package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	//при переходе в браузере на страницу "/",
	// мы попадаем в метод (может быть много методов) printWelcome, который вернет страничку "index"

	// @GetMapping - мапинг (5 видов мапингов, в зависимости какой запрос get\post\put\delete\patch)
	// мапинги нужны для: говорит мы хотим обрабатывать в этом методе GET запросы от пользователя по вот такому то адресу "/"
	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("We are glad to see you at our's Auto Dealer webSite");
		messages.add("push bottom below for getting information about cars");
		model.addAttribute("messages", messages);
		return "index";
	}
	
}