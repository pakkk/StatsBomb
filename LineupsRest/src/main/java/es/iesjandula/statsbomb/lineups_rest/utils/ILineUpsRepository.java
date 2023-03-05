package es.iesjandula.statsbomb.lineups_rest.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.statsbomb.models.lineups.Lineups;


public interface ILineUpsRepository extends JpaRepository<Lineups, Long>
{

}
