package com.eggcampus.util.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author 黄磊
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetStateTracker {
    private Set<String> newSets;
    private Set<String> oldSets;
    private Set<String> stableSets;
}

