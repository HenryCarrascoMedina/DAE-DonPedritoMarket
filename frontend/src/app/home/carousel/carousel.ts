import { Component, OnInit } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carousel',
  imports: [CommonModule],
  templateUrl: './carousel.html',
  styleUrl: './carousel.css'
})
export class Carousel implements OnInit {
  productosPorCategoria: { categoria: string, slides: Producto[][] }[] = [];

  constructor(private productoService: ProductoService) {}

  ngOnInit(): void {
    this.productoService.listar().subscribe(productos => {
      const filtrados = productos.filter(p => p.stock > 0);

      const agrupados: { [key: string]: Producto[] } = {};
      filtrados.forEach(p => {
        const nombreCategoria = p.categoria?.nombre ?? 'Sin categoría';
        if (!agrupados[nombreCategoria]) {
          agrupados[nombreCategoria] = [];
        }
        agrupados[nombreCategoria].push(p);
      });

      for (const [categoria, productos] of Object.entries(agrupados)) {
        const slides = [];
        for (let i = 0; i < productos.length; i += 3) {
          slides.push(productos.slice(i, i + 3));
        }
        this.productosPorCategoria.push({ categoria, slides });
      }
    });
  }
}
