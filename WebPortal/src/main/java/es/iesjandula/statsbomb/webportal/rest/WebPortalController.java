package es.iesjandula.statsbomb.webportal.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebPortalController
{
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String showIndex ()
    {

        return "index.html";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/who_we_are")
    public String showWhoWeAre ()
    {

        return "who_we_are.html";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/what_we_do")
    public String showWhatWeDo ()
    {

        return "what_we_do.html";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics")
    public String showStatistics ()
    {

        return "statistics.html";

    }
}
