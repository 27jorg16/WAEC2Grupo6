$(document).on("click", "#btnagregar", function(){
    $("#txtnomcategoria").val("");
    $("#txtdesccategoria").val("");
    $("#txtfechacategoria").val("");
    $("#txtfarmacocategoria").val("");
    $("#hddcatcod").val("0");
    $("#modalcategoria").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomcategoria").val($(this).attr("data-catnom"));
    $("#txtdesccategoria").val($(this).attr("data-catdesc"));
    $("#txtfechacategoria").val($(this).attr("data-catfecha"));
    $("#txtfarmacocategoria").val($(this).attr("data-catfarmaco"));
    $("#hddcatcod").val($(this).attr("data-catcod"));
    $("#modalcategoria").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/categoria/register",
        contentType: "application/json",
        data: JSON.stringify({
            idcategoria: $("#hddcatcod").val(),
            nomcategoria: $("#txtnomcategoria").val(),
            descripcategoria: $("#txtdesccategoria").val(),
            fechaRegistro: $("#txtfechacategoria").val(),
            farmaco: {
                idfarmaco: $("#txtfarmacocategoria").val()
            }
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCategorias();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalcategoria").modal("hide");
});

function listarCategorias(){
    $.ajax({
        type: "GET",
        url: "/categoria/get",
        dataType: "json",
        success: function(resultado){
            $("#tblcategoria > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcategoria > tbody").append(`<tr>`+
                `<td>${value.idcategoria}</td>`+
                `<td>${value.nomcategoria}</td>`+
                `<td>${value.descripcategoria}</td>`+
                `<td>${value.fechaRegistro}</td>`+
                `<td>${value.farmaco.idfarmaco}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-catcod="${value.idcategoria}" `+
                    `data-catnom="${value.nomcategoria}" `+
                    `data-catdesc="${value.descripcategoria}" `+
                    `data-catfecha="${value.fechaRegistro}" `+
                    `data-catfarmaco="${value.farmaco.idfarmaco}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}

