package io.javabrains.springbootquickstart.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepo extends JpaRepository<people, Integer> {

}
