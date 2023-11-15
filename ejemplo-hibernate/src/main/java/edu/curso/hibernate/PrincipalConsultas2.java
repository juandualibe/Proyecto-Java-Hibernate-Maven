package edu.curso.hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class PrincipalConsultas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); //FALTA EL RESTO DEL CODIGO PARA RECUPERAR UN SESSION
		Transaction transaction = session.beginTransaction();

		
		NativeQuery query1 = session.createSQLQuery("select p.* from productos as p where p.id = :idProducto");
		query1.addEntity(Producto.class);
		
		query1.setParameter("idProducto", 10L);
		Producto producto1 = (Producto) query1.uniqueResult();
		System.out.println("Producto recuperado: " + producto1.getNombre());
		
		
		System.out.println("******************************");
		
		NativeQuery query2 = session.createSQLQuery("select p.* from productos as p");
		query2.addEntity(Producto.class);
		
		List<Producto> productos = query2.list();
		for (Producto producto : productos) {
			System.out.println(producto.getId() + " - " + producto.getNombre());
		}
		
		/*
		Query<Producto> query1 = session.createQuery("from Producto as p where p.id = :idProducto", Producto.class);
		query1.setParameter("idProducto", 10L);
		Producto producto1 = query1.getSingleResult();
		System.out.println("Producto recuperado: " + producto1.getNombre());
		
		Query<String> query2 = session.createQuery("select p.nombre from Producto as p where p.id = :idProducto", String.class);
		query2.setParameter("idProducto", 10L);
		String nombreDelProducto = query2.getSingleResult();
		System.out.println("Nombre producto recuperado: " + nombreDelProducto);
		
		Query<Long> query3 = session.createQuery("select count(*) from Producto", Long.class);
		Long cantidadProductos = query3.getSingleResult();
		System.out.println("Cantidad productos: " + cantidadProductos);

		
		Query<CategoriaProducto> query4 = session.createQuery("select p.categoriaProducto from Producto as p where p.id = :idProducto", CategoriaProducto.class);
		query4.setParameter("idProducto", 10L);
		CategoriaProducto categoriaProducto = query4.getSingleResult();
		System.out.println("CategoriaProducto recuperado: " + categoriaProducto.getNombre());
		*/
		
		
		
		
		
		transaction.commit();
		session.close(); //IMPORTANTE CERRAR EL SESSION
		HibernateUtil.close();

	}

}
