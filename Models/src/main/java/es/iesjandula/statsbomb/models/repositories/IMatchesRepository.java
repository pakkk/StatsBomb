package es.iesjandula.statsbomb.models.repositories;

import es.iesjandula.statsbomb.models.matches.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatchesRepository extends JpaRepository<Match,Integer>
{
}
