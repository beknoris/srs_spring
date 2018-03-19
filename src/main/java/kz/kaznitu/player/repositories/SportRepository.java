package kz.kaznitu.player.repositories;

import kz.kaznitu.player.models.Sport;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SportRepository  extends CrudRepository<Sport,Long>{
    @Override
    Optional<Sport> findById(Long aLong);
}
