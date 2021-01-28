package com.example.model;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class SamplingOrderDAO {

    @Inject
    EntityManager em;

    public List<SamplingOrder> listAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SamplingOrder> cq = cb.createQuery(SamplingOrder.class);
        Root<SamplingOrder> root = cq.from(SamplingOrder.class);
        Join<SamplingOrder, Customer> custJoin = (Join<SamplingOrder, Customer>) root.fetch(SamplingOrder_.customer);

        TypedQuery<SamplingOrder> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Transactional(Transactional.TxType.NEVER)
    public List<SamplingOrder> listAllWithoutTx() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SamplingOrder> cq = cb.createQuery(SamplingOrder.class);
        Root<SamplingOrder> root = cq.from(SamplingOrder.class);
        Join<SamplingOrder, Customer> custJoin = (Join<SamplingOrder, Customer>) root.fetch(SamplingOrder_.customer);

        TypedQuery<SamplingOrder> query = em.createQuery(cq);
        return query.getResultList();
    }

}
