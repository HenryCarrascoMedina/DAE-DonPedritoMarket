import { DecimalPipe } from "@angular/common";
import { Producto } from "./producto";
import { Venta } from "./venta";

export interface DetalleVenta {
    idDetalleVenta: number;
    venta: Venta;
    producto: Producto;
    cantidad: number;
    precio_unitario: DecimalPipe;
    subtotal: DecimalPipe;
}
