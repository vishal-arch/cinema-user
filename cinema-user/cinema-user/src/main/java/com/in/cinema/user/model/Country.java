package com.in.cinema.user.model;

import static com.in.cinema.user.model.State.KAR;
import static com.in.cinema.user.model.State.MAH;
import static com.in.cinema.user.model.State.RAJ;
import static com.in.cinema.user.model.State.TN;

import java.util.List;

public enum Country {

    IN(MAH, RAJ, KAR, TN);

    private List<State> states;

    Country(State... state) {
        this.states = List.of(state);
    }

    public List<State> getStates() {
        return states;
    }

}
