angular.module('miApp')
.controller('AdministradorController', function($scope, $http) {

  $scope.nuevoProducto = {};
  $scope.editarProducto = {}; 
  $scope.borrarProducto = {}; 

  $scope.agregarProducto = function() {
    if (!$scope.nuevoProducto.nombre || !$scope.nuevoProducto.precio || !$scope.nuevoProducto.imagen) {
      alert('Por favor completa todos los campos.');
      return;
    }
    else
    {
      $http
        .post('/postProductos', {
        nombre: $scope.nuevoProducto.nombre,
        precio: $scope.nuevoProducto.precio,
        imagen: $scope.nuevoProducto.imagen
        })
        .then((response)=>{
          alert('Producto agregado existosamente ✅');
          $scope.nuevoProducto.nombre = '';
          $scope.nuevoProducto.precio = 0.0;
          $scope.nuevoProducto.imagen = '';
        })
        .catch(function(error) { 
        if (error.status === 409) {
          alert('Ya existe ese producto ❌');
        } else {
          alert('Error inesperado 🚨');
        }
        });
    }

  };

  $scope.editarProducto = function() {
    if (!$scope.editarProducto.nombre || (!$scope.editarProducto.precio && !$scope.editarProducto.imagen)) {
      alert('Debe ingresar el campo necesario');
      return;
    }
    else{
      $http
        .put('/putProductos', {
          nombre: $scope.editarProducto.nombre,
          precio: $scope.editarProducto.precio,
          imagen: $scope.editarProducto.imagen
        })
        .then((response)=>{
          alert('Producto editado existosamente ✅');
          $scope.editarProducto.nombre = '';
          $scope.editarProducto.precio = 0.0;
          $scope.editarProducto.imagen = '';
        })
        .catch(function(error) { 
        if (error.status === 409) {
          alert('No existe ese producto ❌');
        } else {
          alert('Error inesperado 🚨');
        }
        });
    }
  };

  $scope.eliminarProducto = function() {
    if (!$scope.borrarProducto.nombre) {
      alert('Debe ingresar el nombre del producto');
      return;
    }
    else{
      $http
        .delete('/deleteProductos/'+ $scope.borrarProducto.nombre)
        .then((response)=>{
          alert('Producto eliminado existosamente ✅');
          $scope.borrarProducto.nombre = '';
        })
        .catch(function(error) { 
        if (error.status === 409) {
          alert('No existe ese producto ❌');
        } else {
          alert('Error inesperado 🚨');
        }
        });
    }
  };

    // Función para cerrar sesión
  $scope.logout = function() {
    AuthService.logout();
    $location.path('/'); // Redirige a la pantalla de login
  };
});
