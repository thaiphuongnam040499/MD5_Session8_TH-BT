package rikkei.academy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void remove(Long id);
    Page<User> findAll(Pageable pageable);
}
