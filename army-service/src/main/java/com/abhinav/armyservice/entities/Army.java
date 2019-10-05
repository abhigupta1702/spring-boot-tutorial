package com.abhinav.armyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Army {
    // Id from javax.persistence.Id
    @Id
    @GeneratedValue
    Long id;
    Long personId;
    int dragons;
    int ships;
    int kights;
    int soldiers;

}
