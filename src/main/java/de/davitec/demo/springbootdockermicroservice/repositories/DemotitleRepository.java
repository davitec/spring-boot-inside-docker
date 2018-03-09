package de.davitec.demo.springbootdockermicroservice.repositories;

import de.davitec.demo.springbootdockermicroservice.models.DemoTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemotitleRepository extends JpaRepository<DemoTitle, Long> {

}
