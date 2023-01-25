package es.iesjandula.statsbomb.matches_rest.stats.utils;

import es.iesjandula.statsbomb.models.matches.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatchesRepository extends JpaRepository<Match,Integer>
{
}
