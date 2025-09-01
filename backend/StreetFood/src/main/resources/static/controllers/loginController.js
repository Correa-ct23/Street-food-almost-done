angular.module('miApp')
.controller('LoginController', function($scope, $location, $http, AuthService) {
  $scope.usuario = { nombre: '', contrasena: ''};
  $scope.nuevoUsuario = { nombre: '', contrasena: '', rol: ''};
  $scope.mostrarRegistro = false;

  $http.get('/Login')
      .then(function(response) {
        $scope.usuariosRegistrados = response.data;
      });

  $scope.login = function() {
    const user = $scope.usuariosRegistrados.find(u =>
      u.username === $scope.usuario.nombre && u.password === $scope.usuario.contrasena
    );

    if (user) {
      AuthService.login(user);
      $location.path('/' + user.role);
    } else {
      alert('Usuario o contraseña incorrectos');
    }
  };

  $scope.registrar = function() {
    $http.post('/SignUp', {
      username: $scope.nuevoUsuario.nombre,
      password: $scope.nuevoUsuario.contrasena,
      role: $scope.nuevoUsuario.rol,
      registrationDate: new Date(),
      active: 1
    })
    .then(function(response) {
      alert('Usuario registrado con éxito ✅');
      AuthService.login($scope.nuevoUsuario);
      $location.path('/' + $scope.nuevoUsuario.rol);
    }) 
    .catch(function(error) { 
      if (error.status === 409) {
        alert('Ya existe ese usuario ❌');
      } else {
        alert('Error inesperado 🚨');
      }
    });
  };
});
