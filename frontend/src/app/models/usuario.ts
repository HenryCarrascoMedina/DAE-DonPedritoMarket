import { Cliente } from "./cliente";
import { Empleado } from "./empleado";

export interface Usuario {
    idUsuario: number;
    tipo: string;
    empleado: Empleado;
    cliente: Cliente;
}
