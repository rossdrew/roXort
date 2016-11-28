package com.rox.search;

/**
 * @author rossdrew
 */
public interface Searcher<ComparableSearchTarget extends Comparable> {
    int search(ComparableSearchTarget searchTerm);
}
