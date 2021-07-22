package edu.cnm.deepdive.general.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand<T> implements Iterable<T> {

  private final List<T> elements;

  public Hand() {
    elements = new ArrayList<>();
  }

  public Hand(Collection<T> source) {
    this();
    addAll(source);
  }

  public boolean add(T t) {
    return elements.add(t);
  }

  public boolean addAll(Collection<T> source) {
    return elements.addAll(source);
  }

  public int size() {
    return elements.size();
  }

  public T remove(int index) {
    return elements.remove(index);
  }

  public boolean remove(T t) {
    return elements.remove(t);
  }

  public boolean removeAll(Collection<T> coll) {
    return elements.removeAll(coll);
  }

  public void clear() {
    elements.clear();
  }

  public boolean contains(T t) {
    return elements.contains(t);
  }

  @Override
  public Iterator<T> iterator() {
    return elements.iterator();
  }

  public void sort() {
    sort(null);
  }

  public void sort(Comparator<T> comparator) {
    elements.sort(comparator);
  }

  public Collection<T> allMatches(Predicate<T> predicate) {
    return filter(predicate)
        .collect(Collectors.toList());
  }

  public Optional<T> firstMatch(Predicate<T> predicate) {
    return filter(predicate)
        .findFirst();
  }

  @Override
  public int hashCode() {
    return elements.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    // This comparison is order-dependent
    boolean equal = false;
    if (this == obj) {
      equal = true;
    } else if (obj instanceof Hand) {
      //noinspection rawtypes
      equal = elements.equals(((Hand) obj).elements);
    }
    return equal;
  }

  @Override
  public String toString() {
    return elements.toString();
  }

  protected Stream<T> filter(Predicate<T> predicate) {
    return elements
        .stream()
        .filter(predicate);
  }

}
