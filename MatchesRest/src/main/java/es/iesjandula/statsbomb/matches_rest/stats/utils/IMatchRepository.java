package es.iesjandula.statsbomb.matches_rest.stats.utils;

import es.iesjandula.statsbomb.models.matches.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.net.Inet4Address;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 02/02/2023
 */
public interface IMatchRepository extends JpaRepository<Match, Integer>
{
    //@Query(value = "SELECT * FROM match_table WHERE season_season_id = :season AND competition_competition_id = :competition", nativeQuery = true)
    @Query("SELECT match from Match match WHERE match.season.season_id = :seasonId AND match.competition.competition_id = :competitionId")
    List<Match> findAllByCompetitionIdAndSeasonId(
            @Param("competitionId") Integer competitionId,
            @Param("seasonId") Integer seasonId
    );
}
