package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.dosya.marketapp.entity.Debtor;

import java.util.List;

public interface DebtorRepository extends JpaRepository<Debtor,Long> {


    @Query("select d from Debtor d where UPPER(d.firstName) like upper(concat('%',:name,'%'))")
    List<Debtor>search(String name);
}
