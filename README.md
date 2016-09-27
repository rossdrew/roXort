 [![Build Status](https://travis-ci.org/rossdrew/roXort.svg?branch=master)](https://travis-ci.org/rossdrew/roXort) 
 [![codecov](https://codecov.io/gh/rossdrew/roXort/branch/master/graph/badge.svg)](https://codecov.io/gh/rossdrew/roXort) 


#roXort

This was planned to contain sorting algorithms, firstly to refresh my memory of such things and secondly to try develop in a purer TDD fashion.

It has since started to expand into searching algorithms as well

#### Current Sort Algorithms

| Algorithm     | Best Performance| Avg     |  Worst  |
| ------------- |:---------------:| -------:|---------:
| [Quick Sort](https://github.com/rossdrew/roXort/blob/master/src/main/java/com/rox/sort/QuickSort.java)    | __n__ log __n__ (var __n__) | __n__ log __n__ | __n__<sup>2</sup> |
| [Bubble Sort](https://github.com/rossdrew/roXort/blob/master/src/main/java/com/rox/sort/BubbleSort.java)   | __n__ log __n__ | __n__ log __n__ | __n__ log __n__ |
| [Heap Sort](https://github.com/rossdrew/roXort/blob/master/src/main/java/com/rox/sort/HeapSort.java)   | __n__ log __n__ | __n__ log __n__ | __n__ log __n__ |

#### Current Search Algorithms

| Algorithm     | Best Performance| Avg     |  Worst  |
| ------------- |:---------------:| -------:|---------:
| [Lineary Search](https://en.wikipedia.org/wiki/Linear_search)    | 1 | __n__ | __n__ |
| [Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm)    | 1 | log __n__ | log __n__ |


#### Next up

 - Merge Sort
 - [Others](https://en.wikipedia.org/wiki/Sorting_algorithm) and [Others Still](http://sorting.at/)
 - [Hashing](http://interactivepython.org/runestone/static/pythonds/SortSearch/Hashing.html) & Digital searches
 
#### Pitest

 A mutation testing suite for Java.
 
 __TODO__: This causes a little problem with simple sorting as Pitest will detect errors in the logic of non-stable algorithms.  In that if any item is compared with another of equal value both `a<b` and `a<=b` are valid and this is one of Pitests mutations.  I'll need to add tests to validate the stability of algorithms using objects other than integers in order to kill this mutation.

