import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../models/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  private apiUrl = 'http://lcoalhost:8085/api/categorias';

  constructor(private http: HttpClient) {}

  listar(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>(this.apiUrl);
  }

  obtener(id: number): Observable<Categoria>{
    return this.http.get<Categoria>(`${this.apiUrl}/${id}`);
  }

  registrar(categoria: Categoria): Observable<Categoria>{
    return this.http.post<Categoria>(this.apiUrl, categoria);
  }

  actualizar(categoria:Categoria): Observable<Categoria>{
    return this.http.put<Categoria>(`${this.apiUrl}/${categoria.idCategoria}`, categoria);
  }

  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
