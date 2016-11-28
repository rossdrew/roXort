package com.rox.search;

/**
 * @author rossdrew
 */
public interface Searcher<ComparableSearchTarget extends Comparable<ComparableSearchTarget>> {
    int search(ComparableSearchTarget searchTerm);
}
