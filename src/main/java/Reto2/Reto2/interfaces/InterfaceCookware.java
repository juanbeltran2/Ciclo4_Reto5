package Reto2.Reto2.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import Reto2.Reto2.modelo.Cookware;

public interface InterfaceCookware extends MongoRepository<Cookware, String> {
    
    public List<Cookware> findByPrice(double price);
    //public List<Cookware>findByPriceLessThanEqual(double price)
    public List<Cookware> findByDescriptionContainingIgnoreCase(String description);
}
