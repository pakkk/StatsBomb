package es.iesjandula.statsbomb.webportal.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Joaquin Moreno
 *
 */
@Controller
public class WebPortalController
{
    /**
     * This endPoint return the index page of the web portal.
     *
     * @return index page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String showIndex ()
    {

        return "index.html";

    }


    /**
     * This endPoint return the Who We Are page of the web portal.
     *
     * @return who_we_are page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/who_we_are")
    public String showWhoWeAre ()
    {

        return "who_we_are.html";

    }

    /**
     * This endPoint return the What We Do page of the web portal.
     *
     * @return what_we_do page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/what_we_do")
    public String showWhatWeDo ()
    {

        return "what_we_do.html";

    }

    /**
     * This endPoint return the index page of the web portal.
     *
     * @return statistics page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/statistics")
    public String showStatistics ()
    {

        return "statistics.html";

    }
}
