package com.example.smarthomespring.remote.repository;
import com.example.smarthomespring.remote.domain.Remote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RemoteRepository extends JpaRepository<Remote, Long>{

    @Override
    List<Remote> findAll();

    @Override
    Optional<Remote> findById(Long aLong);
}
