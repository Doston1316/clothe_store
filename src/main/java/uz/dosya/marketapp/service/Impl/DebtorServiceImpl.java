package uz.dosya.marketapp.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dosya.marketapp.entity.Debtor;
import uz.dosya.marketapp.repository.DebtorRepository;
import uz.dosya.marketapp.service.DebtorService;

import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Service
public class DebtorServiceImpl implements DebtorService {

    private final DebtorRepository debtorRepository;

    @Override
    public List<Debtor> findAll() {
        return debtorRepository.findAll();
    }

    @Override
    public Debtor create(Debtor debtor) {
        Debtor newDebtor=new Debtor();
        newDebtor.setFirstName(debtor.getFirstName());
        newDebtor.setLastName(debtor.getLastName());
        newDebtor.setDescription(debtor.getDescription());
        newDebtor.setProductName(debtor.getProductName());
        newDebtor.setDate(debtor.getDate());
        newDebtor.setPhone(debtor.getPhone());
        debtor.setDate(new Date());
        return debtorRepository.save(debtor);
    }

    @Override
    public Debtor update(Long id, Debtor debtor) {
        Debtor newDebtor=debtorRepository.getById(id);
        newDebtor.setFirstName(debtor.getFirstName());
        newDebtor.setLastName(debtor.getLastName());
        newDebtor.setDescription(debtor.getDescription());
        newDebtor.setProductName(debtor.getProductName());
        newDebtor.setDate(debtor.getDate());
        newDebtor.setPhone(debtor.getPhone());
        return debtorRepository.save(newDebtor);
    }

    @Override
    public List<Debtor> search(String name) {
        return debtorRepository.search(name);
    }

    @Override
    public Debtor findById(Long id) {
        return debtorRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        debtorRepository.deleteById(id);
    }
}
