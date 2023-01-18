package es.iesjandula.statsbomb.models.repositories;

import es.iesjandula.statsbomb.models.three_sixty.ThreeSixty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThreeSixtyRepository extends JpaRepository<ThreeSixty,String>
{
}
