import { DecimalPipe } from "@angular/common";
import { Sucursal } from "./sucursal";
import { Usuario } from "./usuario";

export interface Venta {
    idVenta: number;
    fecha_venta: Date;
    usuario: Usuario;
    sucursal: Sucursal;
    total: DecimalPipe;
    metodo_pago: string;
    estado: string;
}
