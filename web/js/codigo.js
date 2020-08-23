/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global we, documento, Enviar */

//función autoincovada
(function(window, document, JSON){
    'use strict';
    //url, de donde se va a conectar el websocket, 
    //se usa el protocolo ws, de websockt - y no http
    var url = 'ws://'+window.location.host+'/WebsocketChat/chat',
            ws = new WebSocket(url),
            mensajes = document.getElementById('conversacion'),
            boton = document.getElementById('btnEnviar'),
            nombre = document.getElementById('usuario'),
            mensaje = document.getElementById('mensaje');
    //localhost:8080, esa seria la ubicación,  para ahorrar tiempo de usa la propiedad host del domnio de nuestro proyecto...!
    
    //eventos - funciones
    ws.onopen = onOpen;//conecta
    ws.onclose = onClose;//desconecta
    ws.onmessage = onMessage;//Recibe el mensaje del servidor
    //evento click del boton, que se dispare la función enviar
    boton.addEventListener('click', enviar);
    
    function onOpen(){//muestra por consola
        console.log('Conectado...');
    }
    function onClose(){
        console.log('Desconectado');
    }
    function enviar(){//va a crear un objeto JSON, con sus dos atributos 
        var msg={//nombre se le asigna el valor de la caja de texto
            //mensaje se le asigna el contenido del textarea
            nombre: nombre.value, 
            mensaje: mensaje.value
        };
        ws.send(JSON.stringify(msg));//que envie ese mensaje y lo envie como cadena de texto
    }
    //crea un objeto del mensaje 
    function onMessage(evt){
        var obj=JSON.parse(evt.data), msg='Nombre: '+obj.nombre+' dice: '+obj.mensaje;
        mensajes.innerHTML+='<br/>'+msg;
    }
    })
(window, document,JSON);