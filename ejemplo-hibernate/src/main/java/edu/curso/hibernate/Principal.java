package edu.curso.hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); //FALTA EL RESTO DEL CODIGO PARA RECUPERAR UN SESSION
		Transaction transaction = session.beginTransaction();

		/*CategoriaProducto categoriaProducto1 = new CategoriaProducto();
		categoriaProducto1.setNombre("general");
		session.save(categoriaProducto1);
		
		Producto producto1 = new Producto();
		producto1.setNombre("Ejemplo4");
		producto1.setDescripcion("Este es un ejemplo de un producto 4");
		producto1.setPrecio(31000.0);
		producto1.setCategoriaProducto(categoriaProducto1);
		session.save(producto1); //ESTO GENERA UN INSER EN LA BASE DE DATOS
		
		System.out.println("El id generado del nuevo producto es: " + producto1.getId());

		
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setNombre("fabricante1");
		session.save(fabricante1);

		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNombre("fabricante2");
		session.save(fabricante2);

		producto1.getFabricantes().add(fabricante1);
		producto1.getFabricantes().add(fabricante2);
		session.update(producto1);
		
		
		Sucursal sucursal1 = new Sucursal();
		sucursal1.setNombre("sucursal1");
		session.save(sucursal1);
		
		producto1.getSucursales().add(sucursal1);
		session.update(producto1);*/

		
		/*Long idBuscar = 10L; //EJEMPLO DE COMO RECUPERAR!!!!
		Producto productoBuscar = session.load(Producto.class, idBuscar);
		System.out.println("Nombre: " + productoBuscar.getNombre());
		System.out.println("Desc: " + productoBuscar.getDescripcion());
		System.out.println("Categoria: " + productoBuscar.getCategoriaProducto().getNombre());

		List<Fabricante> fabricantes = productoBuscar.getFabricantes();
		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + fabricante.getNombre());
		
		//System.out.println("Precio: " + productoBuscar.getPrecio());
		
		/*
		//EJEMPLO DE UPDATE
		productoBuscar.setDescripcion("Ejemplo de update....");
		session.update(productoBuscar);
		
		//EJEPLO DE DELETE
		session.delete(productoBuscar);
		*/
		
		/*
		Query<Producto> queryProductos = session.createQuery("from Producto as p where p.precio > :precio order by p.nombre", Producto.class);
		queryProductos.setParameter("precio", 10000.0);
		
		List<Producto> productos = queryProductos.list();
		for (Producto p : productos) {
			System.out.println("Id: " + p.getId());
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Desc: " + p.getDescripcion());
			System.out.println("Precio: " + p.getPrecio());
			System.out.println("****************************");
		}*/
		
		transaction.commit();
		session.close(); //IMPORTANTE CERRAR EL SESSION
		HibernateUtil.close();

	}

}
