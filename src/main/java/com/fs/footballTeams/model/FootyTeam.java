package com.fs.footballTeams.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FootyTeam {

    private String name;
    private String Owner;
    private Integer stadiumCapacity;
    private String Competition;
    private Integer noOfPlayers;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfCreation;

    public FootyTeam(String name, String owner, Integer stadiumCapacity, String competition, Integer noOfPlayers, Date dateOfCreation) {
        this.name = name;
        Owner = owner;
        this.stadiumCapacity = stadiumCapacity;
        Competition = competition;
        this.noOfPlayers = noOfPlayers;
        this.dateOfCreation = dateOfCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public Integer getStadiumCapacity() {
        return stadiumCapacity;
    }

    public void setStadiumCapacity(Integer stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    public String getCompetition() {
        return Competition;
    }

    public void setCompetition(String competition) {
        Competition = competition;
    }

    public Integer getNoOfPlayers() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(Integer noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
