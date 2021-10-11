package uz.dosya.marketapp.service;

import uz.dosya.marketapp.entity.Debtor;

import java.util.List;

public interface DebtorService {

    List<Debtor>findAll();
    Debtor create(Debtor debtor);
    Debtor update(Long id,Debtor debtor);
    List<Debtor>search(String name);
    Debtor findById(Long id);
    void deleteById(Long id);
}
