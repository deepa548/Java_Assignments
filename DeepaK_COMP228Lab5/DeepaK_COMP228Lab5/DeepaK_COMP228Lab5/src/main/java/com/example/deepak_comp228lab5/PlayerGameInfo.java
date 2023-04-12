package com.example.deepak_comp228lab5;

import java.sql.Date;

public class PlayerGameInfo {
    private int gameId;
    private String gameTitle;
    private int playerId;
    private Date playingDate;
    private int score;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String province;
    private String phoneNumber;

    public PlayerGameInfo(int gameId, String gameTitle, int playerId, Date playingDate, int score, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.playerId = playerId;
        this.playingDate = playingDate;
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public int getPlayerId() {
        return playerId;
    }

    public Date getPlayingDate() {
        return playingDate;
    }

    public int getScore() {
        return score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

