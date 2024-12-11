package soa.dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import soa.entities.Produit;

@Repository
@Transactional
public class ProduitDaoImpl implements IProduitDao{

	@PersistenceContext
	private EntityManager em;
	public Produit save(Produit p) {
		em.persist(p);
		return p;
	}
	public List<Produit> findAll() {
		Query query=  
      em.createQuery("select p from Produit p order by p.designation");
		return query.getResultList();
	}

	public Produit findOne(Long id) {
		Produit p = em.find(Produit.class, id);
		return p;
	}

	public Produit update(Produit p) {
		em.merge(p);
		return p;
	}

	public void delete(Long id) {
		Produit p = em.find(Produit.class, id);
		em.remove(p);
		
	}

	public List<Produit> findByDesignation(String mc) {
		Query query= 
    em.createQuery("select p from Produit p where p.designation like :x");
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
	}
	@Override
	public List<Produit> findByDesignationAndPrix(String mc, double prix) {
		Query query= 
			    em.createQuery("select p from Produit p where p.designation like :x "+
		"and p.prix > :y");
					query.setParameter("x", "%"+mc+"%");
					query.setParameter("y", prix);
					return query.getResultList();
	}
}
