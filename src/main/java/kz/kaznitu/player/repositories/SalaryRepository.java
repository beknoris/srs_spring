package kz.kaznitu.player.repositories;

import kz.kaznitu.player.models.Salary;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SalaryRepository extends CrudRepository<Salary,Long>{
    @Override
    Optional<Salary> findById(Long aLong);
}
