package io.github.aarvedahl.facades;

import io.github.aarvedahl.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CourseFacade extends AbstractFacade<Course>{

    @PersistenceContext(unitName = "school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }
}
