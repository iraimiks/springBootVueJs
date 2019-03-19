package lv.raimonds.webshopspring.repo;

import lv.raimonds.webshopspring.model.GoodItems;
import org.springframework.data.repository.CrudRepository;

public interface GoodItemsRepo extends CrudRepository<GoodItems,Long> {

}
