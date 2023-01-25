package es.iesjandula.statsbomb.competitions_rest.stats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;
import es.iesjandula.statsbomb.models.competition.Competition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionUtils
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ICompetitionRepository competitionRepository;

    /**
     * Return list with all competitions in json StatsBomb
     *
     * @return List of Competitions
     * @throws StatsBombException
     */
    public List<Competition> getListCompetitions() throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonCompetitions = jsonLoader.loadCompetitions();
        ObjectMapper mapper = Json.mapper();
        List<Competition> competitionList = new ArrayList<>();

        try
        {
            competitionList = mapper.readValue(jsonCompetitions, new TypeReference<List<Competition>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json", jsonProcessingException);
        }

        return competitionList;
    }

    public void insertCompetitionsInDataBase() throws StatsBombException
    {
        List<Competition> competitionList = this.getListCompetitions();
        this.competitionRepository.saveAllAndFlush(competitionList);

        List<Competition> competitionList2 =this.competitionRepository.findAll() ;
        System.out.println(competitionList2);

    }

}
