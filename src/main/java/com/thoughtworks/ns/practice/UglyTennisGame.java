package com.thoughtworks.ns.practice;

import static java.lang.String.format;

public class UglyTennisGame implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    //public String P1res = "";
    //public String P2res = "";
    private String player1Name;
    private String player2Name;

    public UglyTennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /*public String getScore2(){
        String score = "";
        if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }
        if (P1point==P2point && P1point>=3)
            score = "Deuce";

        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = format("Advantage %s", player1Name);
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = format("Advantage %s", player2Name);
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = format("Win for %s", player1Name);
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = format("Win for %s", player2Name);
        }
        return score;
    }*/


    public String getScore()
    {
        String score = "";
        if (P1point <=4 && P2point <=4) {
            switch (P1point) {
                case 0:
                    switch (P2point){
                        case 0: score = "Love-All";break;
                        case 1: score = "Love-Fifteen"; break;
                        case 2: score = "Love-Thirty";break;
                        case 3: score = "Love-Forty";break;
                        case 4: score = format("Win for %s", player2Name);break;
                    }
                    break;
                case 1:
                    switch (P2point){
                        case 0: score = "Fifteen-Love";break;
                        case 1: score = "Fifteen-All";break;
                        case 2: score = "Fifteen-Thirty";break;
                        case 3: score = "Fifteen-Forty";break;
                        case 4: score = format("Win for %s", player2Name);break;
                    }
                    break;
                case 2:
                    switch (P2point){
                        case 0: score = "Thirty-Love";break;
                        case 1: score = "Thirty-Fifteen";break;
                        case 2: score = "Thirty-All";break;
                        case 3: score = "Thirty-Forty";break;
                        case 4: score = format("Win for %s", player2Name);break;
                    }
                    break;
                case 3:
                    switch (P2point){
                        case 0: score = "Forty-Love";break;
                        case 1: score = "Forty-Fifteen";break;
                        case 2: score = "Forty-Thirty";break;
                        case 3: score = "Deuce";break;
                        case 4: score = format("Advantage %s",player2Name);break;
                    }
                    break;
                case 4:
                    switch (P2point){
                        case 0:
                        case 1:
                        case 2: score = format("Win for %s",player1Name);break;
                        case 3: score = format("Advantage %s",player1Name);break;
                        case 4: score = "Deuce";break;
                    }
                    break;
            }
        }
        else {
            int diff = Math.abs(P1point - P2point);
            String playerName = P1point > P2point? player1Name:player2Name;
            switch (diff) {
                case 0:
                    score = "Deuce";break;
                case 1:
                    score = format("Advantage %s",playerName);
                    break;
                case 2:
                default:
                    score = format("Win for %s",playerName);
            }
        }
        return score;
    }

/*    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }
 */
    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        else
            P2Score();
    }
}
