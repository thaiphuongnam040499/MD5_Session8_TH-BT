package rikkei.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Song;
@Repository
public interface ISongRepository extends CrudRepository<Song,Long> {
}
