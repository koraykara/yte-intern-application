package yte.intern.application.repository;

import yte.intern.application.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.application.model.Success;

import java.util.List;

public interface AlertRepository  extends JpaRepository<Alert, Long> {
    void deleteById(Long id);
    Alert findByName(String name);
    List<Success> getById(Long id);

}
