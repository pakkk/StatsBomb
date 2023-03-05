package es.iesjandula.statsbomb.models.repositories;

import es.iesjandula.statsbomb.models.lineups.Lineup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILineupsRepository extends JpaRepository<Lineup,Integer>
{
}
