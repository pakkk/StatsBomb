package es.iesjandula.statsbomb.competitions_rest.stats.utils;

import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.competition.CompetitionId;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICompetitionRepository extends JpaRepository<Competition, CompetitionId>
{

    @Query("SELECT c FROM Competition c WHERE c.competition_id = :competition_id")
    Competition findByCompetition_id(int competition_id);

    @Query("SELECT c FROM Competition c")
    List<Competition> findAll();

}
