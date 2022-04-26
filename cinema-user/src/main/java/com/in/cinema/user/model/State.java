package com.in.cinema.user.model;

import static com.in.cinema.user.model.City.BLR;
import static com.in.cinema.user.model.City.CHN;
import static com.in.cinema.user.model.City.JODH;
import static com.in.cinema.user.model.City.MUM;

import java.util.List;

public enum State {
    MAH(MUM),
    RAJ(JODH),
    KAR(BLR),
    TN(CHN);

    private List<City> cities;

    State(City... cities) {
        this.cities = List.of(cities);
    }

    public List<City> getCities() {
        return cities;
    }

}
