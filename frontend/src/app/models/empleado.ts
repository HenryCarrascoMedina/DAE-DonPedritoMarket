import { Sucursal } from "./sucursal";

export interface Empleado {
    idEmpleado: number;
    nombre: string;
    correo: string;
    contrasena: string;
    rol: string;
    sucursal: Sucursal;
}
