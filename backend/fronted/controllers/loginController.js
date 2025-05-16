angular.module('miApp')
.controller('LoginController', function($scope, $location, AuthService, $http) {
  $scope.usuario = { nombre: '', contrasena: ''};
  $scope.nuevoUsuario = { nombre: '', contrasena: '', rol: '', direccion: '' };
  $scope.mostrarRegistro = false;

  $http.get('/Login')
      .then(function(response) {
        $scope.usuariosRegistrados = response.data;
      });

  $scope.login = function() {
    const user = $scope.usuariosRegistrados.find(u =>
      u.nombre === $scope.usuario.nombre && u.contrasena === $scope.usuario.contrasena
    );

    if (user) {
      AuthService.login(user);
      $location.path('/' + user.rol);
    } else {
      alert('Usuario o contraseña incorrectos');
    }
  };

  $scope.registrar = function() {
    $http.post('/SignUp', {
      nombre: $scope.nuevoUsuario.nombre,
      contrasena: $scope.nuevoUsuario.contrasena,
      rol: $scope.nuevoUsuario.rol,
      direccion: $scope.nuevoUsuario.direccion
    })
      .then((response)=>{
        alert('Usuario registrado con éxito ✅:');
      });

    // Opcionalmente: loguearlo y redirigirlo
    AuthService.login($scope.nuevoUsuario);
    $location.path('/' + $scope.nuevoUsuario.rol);
  };
});
