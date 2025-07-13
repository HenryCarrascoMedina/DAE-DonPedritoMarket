import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './home/navbar/navbar';
import { Footer } from './home/footer/footer';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'angular-frontend-donpedrito';
}
