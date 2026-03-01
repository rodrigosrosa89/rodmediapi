package rodmed.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rodmed.voll.api.model.entity.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
