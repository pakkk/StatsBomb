package es.iesjandula.statsbomb.models.repositories;

import es.iesjandula.statsbomb.models.matches.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompetitionRepository extends JpaRepository<Competition,Integer>
{
}
