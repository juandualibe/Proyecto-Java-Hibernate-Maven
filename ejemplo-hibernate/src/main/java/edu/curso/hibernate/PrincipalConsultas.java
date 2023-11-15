package edu.curso.hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

public class PrincipalConsultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); //FALTA EL RESTO DEL CODIGO PARA RECUPERAR UN SESSION
		Transaction transaction = session.beginTransaction();

		
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
		
		
		Query<Producto> query1 = session.createQuery("from Producto as p order by p.nombre", Producto.class);
		List<Producto> productos1 = query1.list();
		

		for (Producto producto : productos1) {
			System.out.println("Id: " + producto.getId() + " " + producto.getNombre());
		}

		System.out.println("*****************************");

		Query<Producto> query2 = session.createQuery("from Producto as p where p.precio >= :precioBuscar order by p.nombre", Producto.class);
		query2.setParameter("precioBuscar", 1000.0);
		List<Producto> productos2 = query2.list();
		

		for (Producto producto : productos2) {
			System.out.println("Id: " + producto.getId() + " " + producto.getNombre());
		}
		
		System.out.println("*****************************");

		Query<Producto> query3 = session.createQuery("from Producto as p where p.nombre like :nombreBuscar order by p.nombre", Producto.class);
		query3.setParameter("nombreBuscar", "%emplo%");
		List<Producto> productos3 = query3.list();
		

		for (Producto producto : productos3) {
			System.out.println("Id: " + producto.getId() + " " + producto.getNombre());
		}


		System.out.println("*****************************");

		Query<Producto> query4 = session.createQuery("from Producto as p where p.categoriaProducto.nombre = :nombreCategoria order by p.nombre", Producto.class);
		query4.setParameter("nombreCategoria", "general");
		List<Producto> productos4 = query4.list();
		

		for (Producto producto : productos4) {
			System.out.println("Id: " + producto.getId() + " " + producto.getNombre());
		}

		System.out.println("*****************************");

		Producto productoBuscarSimple = session.load(Producto.class, 10L);
		List<Fabricante> fabricantesSimple = productoBuscarSimple.getFabricantes();
		for (Fabricante fabricante : fabricantesSimple) {
			System.out.println(fabricante.getId() + " " + fabricante.getNombre());
		}
		
		System.out.println("*****************************");

		
		Query<Fabricante> query5 = session.createQuery("select f from Producto as p inner join p.fabricantes as f where p.id = :idPorducto", Fabricante.class);
		query5.setParameter("idPorducto", 10L);
		List<Fabricante> fabricantes2 = query5.list();
		for (Fabricante fabricante : fabricantes2) {
			System.out.println(fabricante.getId() + " " + fabricante.getNombre());
		}
		
		
		
		transaction.commit();
		session.close(); //IMPORTANTE CERRAR EL SESSION
		HibernateUtil.close();

	}

}
