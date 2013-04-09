package spring.bean.repository.impl;

import model.Hello;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.bean.repository.HelloRepository;

import java.util.List;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

    @Autowired
    private SessionFactory factory;

    @SuppressWarnings("unchecked")
    public List<Hello> getAll() {
        return this.factory.getCurrentSession().createCriteria(Hello.class).list();
    }

    @Transactional
    public void save(Hello hello){
        this.factory.getCurrentSession().save(hello);
    }
}
