package es.iesjandula.statsbomb.competitions_rest.stats.utils;

import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.competition.CompetitionId;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompetitionRepository extends JpaRepository<Competition, CompetitionId>
{
}
