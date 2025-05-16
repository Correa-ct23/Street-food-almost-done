angular.module('miApp')
.controller('AdministradorController', function($scope, $http) {

  $http.get('/getProductos')
    .then((response)=>{
      $scope.productos = response.data;
    })
  

  $scope.nuevoProducto = []; // Objeto para crear o editar productos
  $scope.editando = false; // Saber si estoy en modo edición

  // Agregar nuevo producto
  $scope.agregarProducto = function() {
    if (!$scope.nuevoProducto.id || !$scope.nuevoProducto.nombre || !$scope.nuevoProducto.precio || !$scope.nuevoProducto.imagen) {
      alert('Por favor completa todos los campos.');
      return;
    }
    else
    {
      $http.post('/postProductos', {
        id: $scope.nuevoProducto.id,
        nombre: $scope.nuevoProducto.nombre,
        precio: $scope.nuevoProducto.precio,
        imagen: $scope.nuevoProducto.imagen,
        })
        .then((response)=>{
          alert('Producto agregado existosamente ✅');
        });
        $scope.nuevoProducto = {}; // Limpiar el formulario
    }

  };

  // Cargar los datos del producto seleccionado para editar
  $scope.editarProducto = function(producto) {
    //update service
    $http.put('/putProductos', {}) // <--- ahi dentro va la nueva informacion del producto con su id
      .then((response)=>{
         alert('Producto editado existosamente ✅');
      });
  };

  // Eliminar producto
  $scope.eliminarProducto = function(index) {
    //delete service
    $http.delete('/deleteProductos', {}) // <-- ahi dentro va el id del producto a eliminar
      .then((response)=>{
         alert('Producto eliminado existosamente ✅');
      });
  };

    // Función para cerrar sesión
  $scope.logout = function() {
    AuthService.logout();
    $location.path('/'); // Redirige a la pantalla de login
  };
});
