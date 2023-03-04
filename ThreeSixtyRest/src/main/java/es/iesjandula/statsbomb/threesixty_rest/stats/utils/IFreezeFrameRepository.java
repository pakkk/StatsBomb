package es.iesjandula.statsbomb.threesixty_rest.stats.utils;

import es.iesjandula.statsbomb.models.three_sixty.FreezeFrame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFreezeFrameRepository extends JpaRepository<FreezeFrame,String>
{
}
