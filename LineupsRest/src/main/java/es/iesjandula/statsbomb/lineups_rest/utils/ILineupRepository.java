package es.iesjandula.statsbomb.lineups_rest.utils;

import es.iesjandula.statsbomb.models.lineups.Lineup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILineupRepository extends JpaRepository<Lineup, Integer>
{
}
