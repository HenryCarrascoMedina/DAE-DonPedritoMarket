import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiLista } from './mi-lista';

describe('MiLista', () => {
  let component: MiLista;
  let fixture: ComponentFixture<MiLista>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MiLista]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MiLista);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
