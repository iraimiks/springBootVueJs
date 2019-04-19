package lv.raimonds.webshopspring.repo;

import lv.raimonds.webshopspring.model.ShopeItems;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopeItemsRepo extends CrudRepository<ShopeItems, Long> {
    List<ShopeItems> findByProductCode(String productCode);
}
