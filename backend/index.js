const express = require('express');
const path = require('path');
const app = express();
const PORT = 3000;

//VARIABLES A USAR EN EL FRONT (SIMULADAS DE LAS TABLAS DE LA BASE DE DATOS)
var users = [
    { nombre: 'cliente', contrasena: '123', rol: 'cliente', direccion: 'Calle 123 #45-67' },
    { nombre: 'cocinero', contrasena: '123', rol: 'cocinero', direccion: 'Calle 123 #45-67' },
    { nombre: 'domiciliario', contrasena: '123', rol: 'domiciliario', direccion: 'Calle 123 #45-67' },
    { nombre: 'admin', contrasena: '123', rol: 'admin', direccion: 'Calle 123 #45-67' }
  ];

var productos = [
    { nombre: 'Pizza', precio: 25000, imagen: 'img/pizza.jpg' },
    { nombre: 'Hamburguesa', precio: 18000, imagen: 'img/hamburguesa.jpg' },
    { nombre: 'Perro Caliente', precio: 15000, imagen: 'img/perro.jpg' },
    { nombre: 'Salchipapas', precio: 12000, imagen: 'img/salchipapa.jpg' },
    { nombre: 'Quesadillas', precio: 14000, imagen: 'img/quesadilla.jpg' },
    { nombre: 'Alitas', precio: 20000, imagen: 'img/alitas.jpg' }
  ];

app.use(express.json());
app.use(express.static(path.join(__dirname, 'fronted')));


app.listen(PORT, () => {
    console.log(`Server initialized in: http://localhost:${PORT}`);
})

//Login Service
app.get('/Login', (req, res) =>{
    //AQUI VA EL CODIGO QUE CONECTA A LA BD DE DATOS PARA OBTENER LOS USERS
    res.json(users);
});

//SignUp Service
app.post('/SignUp', (req, res) =>{
    //AQUI VA EL CODIGO QUE CONECTA A LA BD DE DATOS PARA AGREGAR UN USER
    users.push(req.body);
    res.status(203).json({message: 'usuario registrado', user: req.body});
});

//getProductos Service
app.get('/getProductos', (req, res)=>{
    //AQUI VA EL CODIGO QUE CONECTA A LA BD DE DATOS PARA OBTENER LOS PRODUCTOS
    res.json(productos);
});

//postProductos Service
app.post('/postProductos', (req, res)=>{
    //AQUI VA EL CODIGO QUE CONECTA A LA BD DE DATOS PARA AGREGAR UN PRODUCTO
    productos.push(req.body);
    res.status(203).json({message: 'producto registrado', user: req.body});
});

app.put('/putProductos', (req,res) =>{
    //AQUI VA EL CODIGO QUE CONECTA A LA BD DE DATOS PARA EDITAR UN PRODUCTO
});

app.delete('/deleteProductos', (req, res)=>{
    //AQUI VA EL CODIGO QUE CONECTA A LA BD DE DATOS PARA ELIMINAR UN PRODUCTO
})