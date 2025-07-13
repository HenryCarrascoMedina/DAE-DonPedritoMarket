import { Categoria } from "./categoria";
import { Proveedor } from "./proveedor";

export interface Producto {
    idProducto: number;
    nombre: string;
    precio: number;
    stock: number;
    categoria?: Categoria;
    proveedor?: Proveedor;
}
