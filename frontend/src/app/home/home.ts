import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

// Importas tus componentes internos
import { Carousel} from './carousel/carousel';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, Carousel],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class Home {}
