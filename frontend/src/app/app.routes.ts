import { Routes } from '@angular/router';
import { App } from './app';
import { Home } from './home/home';
import { Login } from './pages/login/login';
import { MiLista } from './pages/mi-lista/mi-lista';
import { Carrito } from './pages/carrito/carrito';

export const routes: Routes = [
    {path: '', component: Home}, //Home principal
    {path: 'login', component: Login}, //Login
    {path: 'mi-lista', component: MiLista}, //Mi Lista
    {path: 'carrito', component:Carrito}, //Carrito
];
