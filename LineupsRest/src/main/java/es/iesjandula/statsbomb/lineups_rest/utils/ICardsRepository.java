package es.iesjandula.statsbomb.lineups_rest.utils;

import es.iesjandula.statsbomb.models.lineups.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardsRepository extends JpaRepository<Cards, Long>
{
}
