package es.iesjandula.statsbomb.lineups_rest.utils;

import es.iesjandula.statsbomb.models.lineups.Lineups;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ILineUpsRepository extends JpaRepository<Lineups, Lineups>
{

}
