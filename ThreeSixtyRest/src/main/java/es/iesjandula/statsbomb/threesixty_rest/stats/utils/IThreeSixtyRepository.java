package es.iesjandula.statsbomb.threesixty_rest.stats.utils;

import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThreeSixtyRepository extends JpaRepository<ThreeSixty,String>
{
}
