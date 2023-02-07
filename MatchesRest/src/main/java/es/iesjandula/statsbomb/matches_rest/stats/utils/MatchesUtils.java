package es.iesjandula.statsbomb.matches_rest.stats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.Constants;

import es.iesjandula.statsbomb.models.competition.Competition;
import es.iesjandula.statsbomb.models.matches.Manager;
import es.iesjandula.statsbomb.models.matches.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joaquin Moreno
 */
@Service
public class MatchesUtils
{
    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IMatchesRepository matchesRepository;

    @Autowired
    private IAwayTeamRepository awayTeamRepository;

    @Autowired
    private ICompetitionRepository competitionRepository;

    @Autowired
    private ICompetitionStageRepository competitionStageRepository;

    @Autowired
    private ICountryRepository countryRepository;

    @Autowired
    private IHomeTeamRepository homeTeamRepository;

    @Autowired
    private IManagerRepository managerRepository;

    @Autowired
    private IMatchRepository matchRepository;

    @Autowired
    private IRefereeRepository refereeRepository;

    @Autowired
    private ISeasonRepository seasonRepository;

    @Autowired
    private IStadiumRepository stadiumRepository;



    /**
     * Search all Matches of a Competition and Season
     *
     * @param competitionId Identifier unique of Competition
     * @param seasonId      Identifier unique of Season
     * @return all Matches of competition and season
     * @throws StatsBombException
     */
    public List<Match> getMatches(int competitionId, int seasonId) throws StatsBombException
    {

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();
        String jsonMatches = jsonLoader.loadMatches(competitionId, seasonId);
        ObjectMapper mapper = Json.mapper();
        List<Match> matchesList;

        try
        {
            matchesList = mapper.readValue(jsonMatches, new TypeReference<List<Match>>(){});
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_JSON_TO_OBJECT, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_JSON_TO_OBJECT, "Error a la hora de parsear el Json", jsonProcessingException);
        }

        return matchesList;
    }

    public void insertMatchesInDataBase() throws StatsBombException, JsonProcessingException
    {

        List<Competition> competitionList = getCompetition();

        List<Match> matchList;

        for (Competition competition : competitionList)
        {

            System.out.println(competition.getCompetition_id());
            System.out.println(competition.getSeason_id());
            matchList = this.getMatches(competition.getCompetition_id(), competition.getSeason_id());

            for (Match match: matchList)
            {
                // REFEREE COMPLETO
                if (match.getReferee() != null)
                {
                    if (match.getReferee().getCountry() != null)
                    {
                        if (!this.countryRepository.existsCountryByName(match.getReferee().getCountry().getName()))
                        {
                            this.countryRepository.saveAndFlush(match.getReferee().getCountry());
                        }
                    }
                }

                if(match.getReferee() != null)
                {
                    if(!this.refereeRepository.existsById(match.getReferee().getId()))
                    {
                        this.refereeRepository.saveAndFlush(match.getReferee());
                    }
                }

                // REFEREE COMPLETO FIN

                LOGGER.info("FIN INSERT ARBITRO CHECK");

                // STADIUM COMPLETO

                if (match.getStadium() != null)
                {
                    if (match.getStadium().getCountry() != null)
                    {
                        if (!this.countryRepository.existsCountryByName(match.getStadium().getCountry().getName()))
                        {
                            this.countryRepository.saveAndFlush(match.getStadium().getCountry());
                        }
                    }
                }

                if(match.getStadium() != null)
                {
                    if(!this.stadiumRepository.existsById(match.getStadium().getId()))
                    {
                        this.stadiumRepository.saveAndFlush(match.getStadium());
                    }
                }

                // STADIUM COMPLETO FIN

                LOGGER.info("FIN INSERT STADIUM CHECK");

                // SEASON INICIO

                this.seasonRepository.saveAndFlush(match.getSeason());

                // SEASON FIN

                LOGGER.info("FIN INSERT SEASON CHECK");


                // COMPETITION INICIO


                this.competitionRepository.saveAndFlush(match.getCompetition());

                // COMPETITION FIN

                LOGGER.info("FIN INSERT COMPETITION CHECK");

                // COMPETITION STAGE INICIO

                this.competitionStageRepository.saveAndFlush(match.getCompetition_stage());

                // COMPETITION STAGE FIN

                LOGGER.info("FIN INSERT COMPETITION STAGE CHECK");



                // COUNTRY Y ENTRENADOR DE HOME TEAM INICIO

                if(match.getHome_team() != null)
                {
                    List<Manager> managerList = match.getHome_team().getManagers();
                    if(match.getHome_team().getCountry()!=null)
                    {
                        if(match.getHome_team().getManagers()!=null)
                        {
                            for(Manager manager : managerList)
                            {
                                if(manager.getCountry()!=null)
                                {
                                    if (!this.countryRepository.existsCountryByName(manager.getCountry().getName()))
                                    {
                                        this.countryRepository.saveAndFlush(manager.getCountry());
                                    }
                                }
                            }
                        }
                    }

                    if(match.getHome_team().getManagers()!=null)
                    {
                        for(Manager manager : managerList)
                        {
                            if(!this.managerRepository.existsById(manager.getId()))
                            {
                                this.managerRepository.saveAndFlush(manager);

                            }
                        }
                    }
                }
                // COUNTRY Y ENTRENADOR DE HOME TEAM FIN

                LOGGER.info("FIN INSERT COUNTRY DEL ENTRADOR Y ENTRENADOR HOME TEAM CHECK");

                // COUNTRY Y ENTRENADOR DE AWAY TEAM INICIO

                if (match.getAway_team() != null)
                {
                    List<Manager> managerList = match.getAway_team().getManagers();
                    if(match.getAway_team().getCountry()!=null)
                    {
                        if(match.getAway_team().getManagers()!=null)
                        {
                            for(Manager manager : managerList)
                            {
                                if(manager.getCountry()!=null)
                                {
                                    if (!this.countryRepository.existsCountryByName(manager.getCountry().getName()))
                                    {
                                        this.countryRepository.saveAndFlush(manager.getCountry());
                                    }
                                }
                            }
                        }
                    }

                    if(match.getAway_team().getManagers()!=null)
                    {
                        for(Manager manager : managerList)
                        {
                            if(!this.managerRepository.existsById(manager.getId()))
                            {
                                this.managerRepository.saveAndFlush(manager);
                            }
                        }
                    }
                }


                // COUNTRY Y ENTRENADOR DE AWAY TEAM FIN

                LOGGER.info("FIN INSERT COUNTRY DEL ENTRENADOR Y ENTRENADOR DE AWAY TEAM CHECK");

                // COUNTRY HOME TEAM INICIO

                if(match.getHome_team() != null)
                {
                    if(match.getHome_team().getCountry() != null)
                    {
                        if(!this.countryRepository.existsCountryByName(match.getHome_team().getCountry().getName()))
                        {
                            this.countryRepository.saveAndFlush(match.getHome_team().getCountry());
                        }
                    }
                }

                // COUNTRY HOME TEAM FIN

                LOGGER.info("FIN INSERT COUNTRY DE HOME TEAM CHECK");

                // COUNTRY AWAY TEAM INICIO

                if (match.getAway_team() != null)
                {
                    if(match.getAway_team().getCountry() != null)
                    {
                        if(!this.countryRepository.existsCountryByName(match.getAway_team().getCountry().getName()))
                        {
                            this.countryRepository.saveAndFlush(match.getAway_team().getCountry());
                        }
                    }
                }

                // COUNTRY AWAY TEAM FIN

                LOGGER.info("FIN INSERT COUNTRY DE AWAY TEAM CHECK");

                // HOME TEAM INICIO

                if (match.getHome_team() != null)
                {


                }

                // HOME TEAM FIN


                LOGGER.info("FIN INSERT HOME TEAM CHECK");

                // AWAY TEAM INICIO

                if (match.getAway_team() != null)
                {

                }


                // AWAY TEAM FIN

                LOGGER.info("FIN INSERT AWAY TEAM CHECK");

                // INSERT MATCH

                this.matchesRepository.saveAndFlush(match);

                // INSERT MATCH FIN

                LOGGER.info("FIN INSERT MATCH CHECK");

                LOGGER.info("CHECKKKKKKKKKKKKKKKKKISS MUAK");


            }
        }

        System.out.println("He termiando");


    }

    public List<Competition> getCompetition() throws StatsBombException, JsonProcessingException
    {
        IJsonLoader jsonLoader = new JsonLoaderImpl();

        ObjectMapper mapper = Json.mapper();

        return mapper.readValue(jsonLoader.loadCompetitions(), new TypeReference<List<Competition>>(){});
    }
}
