package es.iesjandula.statsbomb.lineups_rest.utils;

import es.iesjandula.statsbomb.models.lineups.Cards;
import es.iesjandula.statsbomb.models.lineups.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Integer>
{
}
