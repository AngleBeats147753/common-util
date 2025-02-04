package com.eggcampus.util.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 工具类，用于比较两个Set集合的差异，并跟踪这些差异。
 *
 * @author 黄磊
 */
public class SetUtil {
    public static SetStateTracker compare(Set<String> oldObjects, Set<String> newObjects) {
        Set<String> stableObjects = new HashSet<>();
        Set<String> deletedObjects = new HashSet<>();
        Set<String> addedObjects = new HashSet<>();
        if (oldObjects != null) {
            for (String oldImage : oldObjects) {
                if (newObjects.contains(oldImage)) {
                    stableObjects.add(oldImage);
                } else {
                    deletedObjects.add(oldImage);
                }
            }
        }
        if (newObjects != null) {
            for (String newImage : newObjects) {
                if (!stableObjects.contains(newImage)) {
                    addedObjects.add(newImage);
                }
            }
        }
        return new SetStateTracker(addedObjects, deletedObjects, stableObjects);
    }
}
