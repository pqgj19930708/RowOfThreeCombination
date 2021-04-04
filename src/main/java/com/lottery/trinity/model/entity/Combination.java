package com.lottery.trinity.model.entity;

public class Combination {
    private Long id;

    private Integer combination;

    private Long occurrenceNumber;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCombination() {
        return combination;
    }

    public void setCombination(Integer combination) {
        this.combination = combination;
    }

    public Long getOccurrenceNumber() {
        return occurrenceNumber;
    }

    public void setOccurrenceNumber(Long occurrenceNumber) {
        this.occurrenceNumber = occurrenceNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}