package io.github.aarvedahl.facades;

import io.github.aarvedahl.entities.Course;

import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
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
