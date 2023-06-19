
var usserLOGIN;

$(document).ready(function () {


})

function cssLoginDiv() {
    $('#divButtons').hide();
    $("#divForm").toggle();

}

function saveUser() {
   
    
    var nameUser = $('#nameUser').val()
    var cpf = parseInt($('#cpf').val())
    var altura = parseFloat($('#altura').val())
    var peso = parseFloat($('#peso').val())
    var dsEmail = $('#dsEmail').val()
    


    $.ajax({
        headers: {
            'Access-Control-Allow-Origin': '*'
        },
        method: "POST",
        url: "http://localhost:8082/save",
        data: JSON.stringify({ "nameUser": nameUser, "cpf": cpf, "height": altura, "weight": peso, "dsEmail": dsEmail}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            if( data.idUser != null){
                $('#divCad').hide();
                $('#divPay').show();
                usserLOGIN = data.idUser
            }
            
        }
    }).fail(function (xhr, textStatus, errorThrown) {
        alert('erro ao salvar' + xhr.responseText)
    })


    
}


function toGoPay() {
    
   
    var vlPlay = parseInt($('#vlPay').val()) 
    


    $.ajax({
        headers: {
            'Access-Control-Allow-Origin': '*'
        },
        method: "POST",
        url: "http://localhost:8082/saveBalance",
        data: JSON.stringify({ "userId": usserLOGIN, "vlPay": vlPlay}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
           alert('Cadastro feito com sucesso')
    
            
        }
    }).fail(function (xhr, textStatus, errorThrown) {
        alert('erro ao salvar' + xhr.responseText)
    })


    
}


// ============================================
$("#backLogin").click(function () {
    $('#divForm').hide();
    $("#divButtons").toggle();
});

$("#cadastro").click(function () {
    $('#divButtons').hide();
    $("#divCad").toggle();
});

$("#backCad").click(function () {
    $('#divCad').hide();
    $("#divButtons").toggle();
});