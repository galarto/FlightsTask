package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    List<Segment> getSegments() {
        return segments;
    }

    Segment getSegment(int index) {
        return segments.get(index);
    }

    boolean isValidSegments() {
        for (Segment seg : segments) {
            if (seg.getDepartureDate().isAfter(seg.getArrivalDate())) {
                return false;
            }
        }
        return true;
    }

    long getGroundTime() {
        long groundTime = 0L;
        for (int i = 0; i < segments.size(); i++) {
            if (segments.size() > i + 1) {
                groundTime += Duration
                        .between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours();
            }
        }
        return groundTime;
        //long groundTime  = Duration.between(seg1.ArrivalDate,seg2.getDepartureDate).toHours();
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
