package com.yy.provider1.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Integer score;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}