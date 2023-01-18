package es.iesjandula.statsbomb.models.repositories;

import es.iesjandula.statsbomb.models.lineups.Lineups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILineupsRepository extends JpaRepository<Lineups,Integer>
{
}
