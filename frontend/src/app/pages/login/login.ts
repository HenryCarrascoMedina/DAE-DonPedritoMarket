import { Component} from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login{
  correo = '';
  contrasena = '';

  constructor(private usuarioService: UsuarioService, private router:Router){}

  login() {
    console.log('Correo:', this.correo);
    console.log('Contraseña:', this.contrasena);

    this.usuarioService.login(this.correo, this.contrasena).subscribe(
      res => {
        console.log('RESPUESTA DEL LOGIN:', res);

        localStorage.setItem('usuario', JSON.stringify(res));

        if (res.tipo === 'cliente') {
          this.router.navigate(['/mi-lista']);
        } else if (res.tipo === 'empleado') {
          this.router.navigate(['/empleado']);
        }
      },
      err => {
        console.error('ERROR:', err);
        alert('Credenciales invalidas');
      }
    );
  }

}
