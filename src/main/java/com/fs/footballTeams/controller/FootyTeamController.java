package com.fs.footballTeams.controller;


import com.fs.footballTeams.model.FootyTeam;
import com.fs.footballTeams.model.FootyTeamStub;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FootyTeamController {

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<FootyTeam> findAllTeams() {
        return (new FootyTeamStub().findAllTeams());
    }

    @RequestMapping(value = "/teams-sorted/{sortByCapacity}", method = RequestMethod.GET)
    public List<FootyTeam> findTeamsSortedByCapacity(@PathVariable String sortByCapacity) {
        return new FootyTeamStub().findTeamsSortedByCapacity(sortByCapacity);
    }

    @RequestMapping(value = "/team-by-name/{byName}", method = RequestMethod.GET)
    public FootyTeam findTeamByName(@PathVariable String byName) {
        return new FootyTeamStub().findTeamByName(byName);
    }

}
