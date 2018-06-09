# SISTest

Simple rest controller test

Endpoints serviced 
 1) http://localhost:8080/teams
 Returns am array of teams objects in Json format
[
  {
    "name": "White shirts",
    "stadiumCapacity": 301,
    "noOfPlayers": 11,
    "dateOfCreation": "2000-01-28T00:00:00.000+0000",
    "owner": "White house",
    "competition": "Hard"
  },
  {
    "name": "Blue shirts",
    "stadiumCapacity": 201,
    "noOfPlayers": 11,
    "dateOfCreation": "2000-01-28T00:00:00.000+0000",
    "owner": "Blue house",
    "competition": "Hard"
  },
  {
    "name": "Red shirts",
    "stadiumCapacity": 401,
    "noOfPlayers": 11,
    "dateOfCreation": "2000-01-28T00:00:00.000+0000",
    "owner": "Red house",
    "competition": "Hard"
  }
]

2)http://localhost:8080/teams-sorted/capacity
Returns am array of teams objects in Json format - sorted by 'capacity' - does not service any other sorting
[
  {
    "name": "Blue shirts",
    "stadiumCapacity": 201,
    "noOfPlayers": 11,
    "dateOfCreation": "28\/01\/2000",
    "owner": "Blue house",
    "competition": "Hard"
  },
  {
    "name": "White shirts",
    "stadiumCapacity": 301,
    "noOfPlayers": 11,
    "dateOfCreation": "28\/01\/2000",
    "owner": "White house",
    "competition": "Hard"
  },
  {
    "name": "Red shirts",
    "stadiumCapacity": 401,
    "noOfPlayers": 11,
    "dateOfCreation": "28\/01\/2000",
    "owner": "Red house",
    "competition": "Hard"
  }
]

3)http://localhost:8080/team-by-name/white shirts
Returns a single team object coresponding to the team searched - in this case 'white shirts'
{
  "name": "White shirts",
  "stadiumCapacity": 301,
  "noOfPlayers": 11,
  "dateOfCreation": "28\/01\/2000",
  "owner": "White house",
  "competition": "Hard"
}
