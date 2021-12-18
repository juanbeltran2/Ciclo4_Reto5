package Reto2.Reto2.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Reto2.Reto2.modelo.Cookware;
import Reto2.Reto2.repositorio.CookwareRepositorio;

@Service
public class CookwareService {
    @Autowired
    private CookwareRepositorio cookwareRepository;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

   public Optional<Cookware> getClothe(String reference) {
        return cookwareRepository.getClothe(reference);
    }

    public Cookware create(Cookware accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cookwareRepository.create(accesory);
        }
    }

    public Cookware update(Cookware accesory) {

        if (accesory.getReference() != null) {
            Optional<Cookware> accesoryDb = cookwareRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getMateriales() != null) {
                    accesoryDb.get().setMateriales(accesory.getMateriales());
                }

                if (accesory.getDimensiones() != null) {
                    accesoryDb.get().setDimensiones(accesory.getDimensiones());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cookwareRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            cookwareRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Cookware>getByPriceLessThanEqual(double price){
        return cookwareRepository.getByPriceLessThanEqual(price);
    }

    public List<Cookware>getByDescriptionContainingIgnoreCase(String description){
        return cookwareRepository.getByDescriptionContainingIgnoreCase(description);
    }
    
}
