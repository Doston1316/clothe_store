package uz.dosya.marketapp.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.entity.Debtor;
import uz.dosya.marketapp.service.Impl.DebtorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/debtor")
@AllArgsConstructor
public class DebtorController {

    private DebtorServiceImpl debtorService;

    @PostMapping
    public Debtor create(@RequestBody Debtor debtor){
        return debtorService.create(debtor);
    }

    @GetMapping
    public List<Debtor>findAll(){
        return debtorService.findAll();
    }

    @PutMapping("/{id}")
    public Debtor update(@PathVariable("id")Long id,
                         @RequestBody Debtor debtor){
        return debtorService.update(id,debtor);
    }

    @GetMapping("/{name}")
    public List<Debtor>search(@PathVariable String name){
        return debtorService.search(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id){
        debtorService.deleteById(id);
    }

}
