package spring.bean.repository;

import model.Hello;

import java.util.List;

public interface HelloRepository {
    List<Hello> getAll();
    void save(Hello hello);
}
