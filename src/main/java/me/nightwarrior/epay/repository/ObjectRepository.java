package me.nightwarrior.epay.repository;

public interface ObjectRepository<T> {

    public void store(T element);

    public T get(int id);

    public T search(String name);

    public T delete(int id);

}