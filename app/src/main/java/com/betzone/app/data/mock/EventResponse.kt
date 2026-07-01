package com.betzone.app.data.mock

object EventResponse {
    val succesfulResponse ="""
        {
          "events": [
            {
              "id": "e1",
              "homeTeam": "Real Madrid",
              "awayTeam": "Barcelona",
              "league": "La Liga",
              "startTime": "2026-07-15T20:00:00Z",
              "markets": [
                {
                  "id": "m1",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s1", "name": "Home", "odds": 2.10 },
                    { "id": "s2", "name": "Draw", "odds": 3.40 },
                    { "id": "s3", "name": "Away", "odds": 3.20 }
                  ]
                }
              ]
            },
            {
              "id": "e2",
              "homeTeam": "Manchester City",
              "awayTeam": "Manchester United",
              "league": "Premier League",
              "startTime": "2026-07-16T18:30:00Z",
              "markets": [
                {
                  "id": "m2",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s4", "name": "Home", "odds": 1.95 },
                    { "id": "s5", "name": "Draw", "odds": 3.60 },
                    { "id": "s6", "name": "Away", "odds": 4.20 }
                  ]
                },
                {
                  "id": "m3",
                  "name": "Over/Under 2.5 Goals",
                  "selections": [
                    { "id": "s7", "name": "Over 2.5", "odds": 1.75 },
                    { "id": "s8", "name": "Under 2.5", "odds": 2.05 }
                  ]
                }
              ]
            },
            {
              "id": "e3",
              "homeTeam": "Bayern Munich",
              "awayTeam": "Borussia Dortmund",
              "league": "Bundesliga",
              "startTime": "2026-07-17T19:45:00Z",
              "markets": [
                {
                  "id": "m4",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s9", "name": "Home", "odds": 1.85 },
                    { "id": "s10", "name": "Draw", "odds": 3.80 },
                    { "id": "s11", "name": "Away", "odds": 4.50 }
                  ]
                }
              ]
            },
            {
              "id": "e4",
              "homeTeam": "Juventus",
              "awayTeam": "AC Milan",
              "league": "Serie A",
              "startTime": "2026-07-18T20:00:00Z",
              "markets": [
                {
                  "id": "m5",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s12", "name": "Home", "odds": 2.40 },
                    { "id": "s13", "name": "Draw", "odds": 3.20 },
                    { "id": "s14", "name": "Away", "odds": 2.90 }
                  ]
                }
              ]
            },
            {
              "id": "e5",
              "homeTeam": "Paris Saint-Germain",
              "awayTeam": "Lyon",
              "league": "Ligue 1",
              "startTime": "2026-07-19T21:00:00Z",
              "markets": [
                {
                  "id": "m6",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s15", "name": "Home", "odds": 1.60 },
                    { "id": "s16", "name": "Draw", "odds": 4.50 },
                    { "id": "s17", "name": "Away", "odds": 5.50 }
                  ]
                }
              ]
            },
            {
              "id": "e6",
              "homeTeam": "Atletico Madrid",
              "awayTeam": "Sevilla",
              "league": "La Liga",
              "startTime": "2026-07-20T18:00:00Z",
              "markets": [
                {
                  "id": "m7",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s18", "name": "Home", "odds": 2.30 },
                    { "id": "s19", "name": "Draw", "odds": 3.30 },
                    { "id": "s20", "name": "Away", "odds": 3.10 }
                  ]
                }
              ]
            },
            {
              "id": "e7",
              "homeTeam": "Tottenham Hotspur",
              "awayTeam": "Chelsea",
              "league": "Premier League",
              "startTime": "2026-07-21T17:30:00Z",
              "markets": [
                {
                  "id": "m8",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s21", "name": "Home", "odds": 2.50 },
                    { "id": "s22", "name": "Draw", "odds": 3.20 },
                    { "id": "s23", "name": "Away", "odds": 2.70 }
                  ]
                }
              ]
            },
            {
              "id": "e8",
              "homeTeam": "Arsenal",
              "awayTeam": "Newcastle United",
              "league": "Premier League",
              "startTime": "2026-07-22T20:15:00Z",
              "markets": [
                {
                  "id": "m9",
                  "name": "Match Result",
                  "selections": [
                    { "id": "s24", "name": "Home", "odds": 1.90 },
                    { "id": "s25", "name": "Draw", "odds": 3.60 },
                    { "id": "s26", "name": "Away", "odds": 4.00 }
                  ]
                }
              ]
            }
          ],
          "hasMore": true
        }
    """.trimIndent()

    val errorResponse ="""
    """.trimIndent()
}