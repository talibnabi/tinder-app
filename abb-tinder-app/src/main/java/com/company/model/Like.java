package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
public class Like {
    private final int from;
    private final int to;
    private final boolean like;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like like)) return false;
        return getFrom() == like.getFrom() && getTo() == like.getTo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo());
    }

}
