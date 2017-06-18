package com.codingalgo.model;

public enum Rank {
    DIRECTOR(0),
    MANAGER(1),
    RESPONDENT(2);
    int value;

    private Rank(int v) {
        this.value = v;
    }
}
