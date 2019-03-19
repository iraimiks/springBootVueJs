package lv.raimonds.webshopspring.controller;

import lv.raimonds.webshopspring.model.GoodItems;
import lv.raimonds.webshopspring.repo.GoodItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api   ")
public class GoodItemsController {
    @Autowired
    GoodItemsRepo goodItemsRepo;
    @GetMapping("goodItems")
    public List<GoodItems> getAllGoodItems(){
        System.out.println("Get All GoodItems");
        List<GoodItems> goodItems = new ArrayList<>();
        goodItemsRepo.findAll().forEach(goodItems::add);
        return goodItems;
    }
}
