package com.usc;

public class RoyalCinema extends Cinema {

    public RoyalCinema() {
        super("Royal Cinema", "50$");
        mainPage();
        addApplicant("1", "First applicant", 30, 100, 45, 35, 85, 100, 200, 35);
        addApplicant("2", "Second applicant", 30, 190, 45, 35, 85, 190, 200, 35);
        addApplicant("3", "Third applicant", 30, 280, 45, 35, 85, 280, 200, 35);
    }

    @Override
    public void showMoviesScreened() {
        addMovieScreened("1", 30, 75, 45, 35, 85, 75, 200, 35, "Thor: Ragnarok", "Action", "Taika Waititi");
        addMovieScreened("2", 30, 145, 45, 35, 85, 145, 200, 35, "Jigsaw", "Criminal, Panic", "Michael Spirig");
        addMovieScreened("3", 30, 220, 45, 35, 85, 220, 200, 35, "Joker", "Drama", "Todd Phillips");
        addMovieScreened("4", 30, 295, 45, 35, 85, 295, 200, 35, "Avengers: End Game", "Action, Exciting", "Joe Russo");
    }
}
