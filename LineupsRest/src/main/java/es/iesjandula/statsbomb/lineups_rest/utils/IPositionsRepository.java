package es.iesjandula.statsbomb.lineups_rest.utils;

import es.iesjandula.statsbomb.models.lineups.Positions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionsRepository extends JpaRepository<Positions, Long>
{
}
