CREATE DATABASE DonPedritoMarket;
USE DonPedritoMarket;

-- TABLAS --

-- Categorías
CREATE TABLE IF NOT EXISTS Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- Proveedores
CREATE TABLE IF NOT EXISTS Proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    telefono BIGINT,
    correo VARCHAR(100),
    direccion VARCHAR(255)
);

-- Sucursal
CREATE TABLE IF NOT EXISTS Sucursal (
    id_sucursal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono BIGINT
);

-- Empleados
CREATE TABLE IF NOT EXISTS Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL,
    id_sucursal INT,
    FOREIGN KEY (id_sucursal) REFERENCES Sucursal(id_sucursal)
);

-- Clientes
CREATE TABLE IF NOT EXISTS Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre TEXT NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    documento VARCHAR(50),
    telefono BIGINT,
    direccion VARCHAR(255)
);

-- Usuarios (relación entre cliente o empleado)
CREATE TABLE IF NOT EXISTS Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Empleado', 'Cliente') NOT NULL,
    id_empleado INT NULL,
    id_cliente INT NULL,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Productos
CREATE TABLE IF NOT EXISTS Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    id_categoria INT,
    id_proveedor INT,
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);

-- Ventas
CREATE TABLE IF NOT EXISTS Venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    fecha_venta DATETIME NOT NULL,
    id_usuario INT NOT NULL,
    id_sucursal INT,
    total DECIMAL(10, 2) NOT NULL,
    metodo_pago VARCHAR(50),
    estado ENUM('Pendiente', 'Esperando pago', 'Pagado', 'Por entregar', 'Enviado', 'Cancelado') NOT NULL DEFAULT 'Pendiente',
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_sucursal) REFERENCES Sucursal(id_sucursal)
);

-- Detalle de venta
CREATE TABLE IF NOT EXISTS Detalle_Venta (
    id_detalle_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-- ----------------------------------------------------------------
-- INSERTAR DATOS
USE DonPedritoMarket;

-- Categorías
INSERT INTO Categoria (nombre, descripcion) VALUES
('Alimentos', 'Productos de consumo diario como arroz, azúcar, fideos'),
('Bebidas', 'Gaseosas, jugos, agua, cervezas'),
('Higiene', 'Papel higiénico, pañales, jabón, champú'),
('Baterías y Pilas', 'Pilas AA, AAA, baterías para linternas');

-- Proveedores
INSERT INTO Proveedor (nombre, contacto, telefono, correo, direccion) VALUES
('Arroz Superior S.A.', 'Luis Andrade', 981234567, 'ventas@arrozsuperior.com', 'Av. Agraria 123, Lima'),
('Distribuidora Coca-Cola Perú', 'Sandra Vega', 987654321, 'contacto@cocacola.pe', 'Av. Industrial 456, Lima'),
('Productos Higiénicos S.R.L.', 'Carlos Quispe', 985432198, 'ventas@higienicos.com', 'Jr. Salubridad 321, Lima'),
('Energizer Distribución Perú', 'María Castro', 983112233, 'info@energizer.pe', 'Calle Energía 101, Lima');

-- Sucursal
INSERT INTO Sucursal (nombre, direccion, telefono) VALUES
('Sucursal Central - San Juan', 'Av. Los Héroes 456, SJL - Lima', 012223344);

-- Empleados
INSERT INTO Empleado (nombre, correo, contrasena, rol, id_sucursal) VALUES
('Juan Torres', 'juan.torres@donpedrito.com', '123456', 'Administrador', 1),
('Lucía Díaz', 'lucia.diaz@donpedrito.com', '123456', 'Cajero', 1),
('Pedro Gutiérrez', 'pedro.gutierrez@donpedrito.com', '123456', 'Almacenero', 1);

-- Clientes
INSERT INTO Cliente (nombre, correo, contrasena, documento, telefono, direccion) VALUES
('Rosa Flores', 'rosa.flores@gmail.com', '123456', 'DNI 12345678', 998877665, 'Mz A Lt 4, SJL'),
('Luis Mendoza', 'luis.mendoza@gmail.com', '123456', 'DNI 23456789', 997766554, 'Mz B Lt 6, VES');

-- Usuarios (Empleados)
INSERT INTO Usuario (tipo, id_empleado, id_cliente) VALUES
('Empleado', 1, NULL),
('Empleado', 2, NULL),
('Empleado', 3, NULL);

-- Usuarios (Clientes)
INSERT INTO Usuario (tipo, id_empleado, id_cliente) VALUES
('Cliente', NULL, 1),
('Cliente', NULL, 2);

-- Productos
INSERT INTO Producto (nombre, precio, stock, id_categoria, id_proveedor) VALUES
('Arroz Superior 5kg', 25.00, 50, 1, 1),
('Azúcar Rubia 1kg', 4.50, 80, 1, 1),
('Fideos Don Vittorio 500g', 3.00, 100, 1, 1),
('Gaseosa Coca-Cola 1.5L', 6.00, 60, 2, 2),
('Gaseosa Inka Kola 1.5L', 6.00, 50, 2, 2),
('Agua San Luis 625ml', 2.00, 100, 2, 2),
('Papel Higiénico Elite 4 rollos', 7.50, 40, 3, 3),
('Pañales Huggies Talla M x20', 35.00, 30, 3, 3),
('Jabón Bolívar x3 und', 5.50, 50, 3, 3),
('Pilas Energizer AA x4', 12.00, 40, 4, 4),
('Pilas Energizer AAA x4', 11.50, 30, 4, 4);
