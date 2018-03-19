package kz.kaznitu.player.repositories;

import kz.kaznitu.player.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player,Long>{
    @Override
    Optional<Player> findById(Long id);
}
