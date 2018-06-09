package com.fs.footballTeams.model;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FootyTeamStub {

    public static final String CAPACITY = "capacity";
    private List<FootyTeam> footyTeamList = new ArrayList<>();
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private Log logger = LogFactory.getFactory().getInstance(FootyTeamStub.class);

    public FootyTeamStub() {
        footyTeamList.add(new FootyTeam("White shirts", "White house", 301, "Hard",
                11, getDateFromString("28/01/2000")));
        footyTeamList.add(new FootyTeam("Blue shirts", "Blue house", 201, "Hard",
                11, getDateFromString("28/01/2000")));
        footyTeamList.add(new FootyTeam("Red shirts", "Red house", 401, "Hard",
                11, getDateFromString("28/01/2000")));
    }

    public List<FootyTeam> findAllTeams() {
        return footyTeamList;
    }

    public FootyTeam findTeamByName(String name) {
        Optional<FootyTeam> result = footyTeamList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
        if (result.isPresent()) {
            logger.info("Found team with name " + name);
            return result.get();
        }
        logger.error("Error fetching team details with team name " + name);
        return null;
    }

    private Date getDateFromString(String inDate) {
        Date outDate = null;
        try {
            outDate = dateFormat.parse(inDate);
        } catch (ParseException e) {
            logger.error("Error parsing date " + inDate);
        }
        return outDate;
    }

    public List<FootyTeam> findTeamsSortedByCapacity(String sortByCapacity) {
        List tempList = new ArrayList();
        tempList.addAll(footyTeamList);
        if (sortByCapacity.equalsIgnoreCase(CAPACITY)) {
            tempList.sort(Comparator.comparing(FootyTeam::getStadiumCapacity).thenComparing(FootyTeam::getStadiumCapacity));
        }
        return tempList;
    }
}
