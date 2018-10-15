package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;


import modelo.dominio.Brinco;


public class BrincoDAO extends JpaDAO<Brinco> {
	
	public List<Brinco> filtrarBrincos(String tipo) {
		String jpql = "from Brinco b ";

		
		if (tipo != null) {
			jpql = jpql + " where b.tipo like :tipo";
		}

		jpql = jpql + " order by b.tipo";

		TypedQuery<Brinco> comando = this.getEntityManager().createQuery(jpql, Brinco.class);

		if (tipo != null)
			comando.setParameter("tipo", "%" + tipo + "%");

		return comando.getResultList();
	}

}
