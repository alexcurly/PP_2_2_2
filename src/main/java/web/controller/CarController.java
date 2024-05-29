package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class CarController {
    CarDealer carDealer = new CarDealer();
    @GetMapping(value = "/cars")
    public String loadCars(@RequestParam (value = "count", required = false, defaultValue = "5")
                            Integer count, Model model) {

        model.addAttribute("cars", carDealer.getCarsFromDealer(count));
        return "cars";
    }
}