<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Formulario reclamo</h2>

<form:form action="/reclamos/guardar" id="formReclamo" modelAttribute="reclamoForm">

	<div class="row">
		<div class="col-md-6">	
			<div class="mb-3">
			  <label class="form-label">Id</label>
			  <form:input cssClass="form-control" path="id" readonly="true"/>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Titulo</label>
			  <form:input cssClass="form-control required" path="titulo"/>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Titulo</label>
			  <form:textarea cssClass="form-control required" path="descripcion" rows="5" cols="15" />
			</div>
		
		
			<button class="btn btn-primary" id="buttonEnviar" type="button">Enviar</button>
			<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>

		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			console.log('Listo termino de cargar todo el html de la pagina....');
			
			
			$('#buttonEnviar').on('click', function() {
				if($('#formReclamo').valid() == true) {
					$('#formReclamo').submit();
				} else {
					bootbox.alert('For favor completar los campos que faltan....');
				}
			});
			
			$('#buttonCancelar').on('click', function() {
				history.back();
			});
		
			
		});
	</script>

</form:form>

<jsp:include page="../template_inferior.jsp"></jsp:include>
