package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
public class Like {
    private final int userFrom;
    private final int userTo;
    private final boolean like;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like like)) return false;
        return getUserFrom() == like.getUserFrom() && getUserTo() == like.getUserTo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserFrom(), getUserTo());
    }

}
