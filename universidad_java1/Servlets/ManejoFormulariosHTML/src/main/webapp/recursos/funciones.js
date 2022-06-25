function validarForma(form1){
    var usuario=form1.usuario;
    if(usuario.value==="" || usuario.value==="Escribir usuario"){
        alert("Proporcione un nombre de usuario");
        usuario.foecus();
        usuario.select();
        return false;//retorna falso para que no se envie el formulario y el usuario vuelva a completar este campo
    }
    var password=form1.password;
    if(password.value==="" || password.value.length<3){
        alert("Proporcione un password al menos de 3 caracteres");
        password.foecus();
        password.select();
        return false;//retorna falso para que no se envie el formulario y el usuario vuelva a completar este campo
    }
    var tecnologias=form1.tecnologias;
    var checkSeleccionado=false;
    
    for(var i=0;i<tecnologias.length;i++){
        if(tecnologias[i].check){
            checkSeleccionado=true;
        }
    }
    if(!checkSeleccionado){//si no se selecciono ningun checkbox
        alert("Debe seleccionar una tecnologia");
        return false;
    }
    var generos=form1.genero;
    var radioSeleccionado=false;
    for(var i=0;i<generos.length;i++){
        if(generos[i].checked){
            radioSeleccionado=true;
        }
    }
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }
    var ocupacion = form1.ocupacion;
    if(ocupacion.value === ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
   //formulario es valido
   alert("Formulario es valido. enviando datos al servidor");
   return true;
}


