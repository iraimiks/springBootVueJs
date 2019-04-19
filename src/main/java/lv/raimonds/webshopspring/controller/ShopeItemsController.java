package lv.raimonds.webshopspring.controller;

import lv.raimonds.webshopspring.model.ShopeItems;
import lv.raimonds.webshopspring.repo.ShopeItemsRepo;
import lv.raimonds.webshopspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ShopeItemsController {
    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.POST, value = "/user/save")
    public void save(@RequestHeader(value="ID-TOKEN") String idToken) throws Exception {
        service.saveUser(idToken);
    }
    @Autowired
    ShopeItemsRepo shopeItemsRepo;

    @GetMapping("/shopeItems")
    public List<ShopeItems> getAllShopeItems(){
        System.out.println("Get all Shope goods ... ");
        List<ShopeItems> shopeItems = new ArrayList<>();
        shopeItemsRepo.findAll().forEach(shopeItems::add);
        return shopeItems;
    }

    @PostMapping("/shopeItem")
    public ShopeItems postShopeItem(@RequestBody  ShopeItems shopeItems){
        ShopeItems _shopeItem = shopeItemsRepo.save(new ShopeItems(shopeItems.getProductCode(),
                                                                    shopeItems.getProductName(),
                                                                    shopeItems.getPrice(),
                                                                    shopeItems.getDescription(),
                                                                    shopeItems.getLongDescription()
                ));
        return _shopeItem;
    }
    @DeleteMapping("/shopeItem/{idShopItems}")
    public ResponseEntity<String> deleteShopeItem(@PathVariable("idShopItems") long idShopItems){
        System.out.println("Delete Shop product with idShopItems= "+ idShopItems + " ...");
        shopeItemsRepo.deleteById(idShopItems);
        return new ResponseEntity<>("Shop product has been delete", HttpStatus.OK);
    }
    @GetMapping("shopeItems/productCode/{productCode}")
    public List<ShopeItems> findByProductCode(@PathVariable String productCode){
        List<ShopeItems> shopeItems = shopeItemsRepo.findByProductCode(productCode);
        return  shopeItems;
    }
    @PutMapping("/shopeItem/{idShopItems}")
    public ResponseEntity<ShopeItems> updateShopProduct(@PathVariable("idShopItems") long idShopItems,
                                                         @RequestBody  ShopeItems shopeItems) {
        System.out.println("Update Shop product with ID = " + idShopItems + " ...");

        Optional<ShopeItems> shopeItemData = shopeItemsRepo.findById(idShopItems);
        if (shopeItemData.isPresent()) {
            ShopeItems _shopProduct = shopeItemData.get();
            _shopProduct.setProductCode(shopeItems.getProductCode());
            _shopProduct.setProductName(shopeItems.getProductName());
            _shopProduct.setPrice(shopeItems.getPrice());
            _shopProduct.setDescription(shopeItems.getDescription());
            _shopProduct.setLongDescription(shopeItems.getLongDescription());
            return new ResponseEntity<>(shopeItemsRepo.save(_shopProduct),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
