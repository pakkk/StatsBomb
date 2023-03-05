package es.iesjandula.statsbomb.threesixty_rest.stats.utils;

import es.iesjandula.statsbomb.models.matches.Match;
import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IThreeSixtyRepository extends JpaRepository<ThreeSixty,String>
{

    @Query("SELECT th from ThreeSixty th where th.matchId = :matchId")
    List<ThreeSixty> findAllByMatchId(
            @Param("matchId") Integer matchId
    );

}
