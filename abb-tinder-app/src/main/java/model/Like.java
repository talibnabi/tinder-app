package model;

import java.util.Objects;

public class Like {
    private final int userFrom;
    private final int userTo;
    private final boolean like;

    public Like(int userFrom, int userTo, boolean like) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.like = like;
    }

    public int getUserFrom() {
        return userFrom;
    }

    public int getUserTo() {
        return userTo;
    }

    public boolean isLike() {
        return like;
    }

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

    @Override
    public String toString() {
        return "Like{" +
                "userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", like=" + like +
                '}';
    }
}
