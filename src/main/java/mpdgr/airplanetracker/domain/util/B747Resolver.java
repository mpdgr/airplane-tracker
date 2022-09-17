package mpdgr.airplanetracker.domain.util;

import mpdgr.airplanetracker.domain.config.B747Operators;
import mpdgr.airplanetracker.domain.model.Flight;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class B747Resolver {

    public boolean containsB747Data(String webContent) {
        return webContent.contains("\"model\":\"747");
    }

    public List<Flight> findB747Operators(List<Flight> flightList) {
        List<String> active747OperatorsCallsigns = Arrays.stream(B747Operators.values())
                .map(B747Operators::getIcao)
                .collect(Collectors.toList());

        List<Flight> flightListOfB747Operators = flightList.stream()
                .filter(Objects::nonNull)
                .filter(f -> f.getCallsign() != null)
                .filter(f -> f.getCallsign().length() > 2)
                .filter(f -> active747OperatorsCallsigns.contains(f.getCallsign().substring(0, 3).toUpperCase()))
                .collect(Collectors.toList());

        return flightListOfB747Operators;
    }
}