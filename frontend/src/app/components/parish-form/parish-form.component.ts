import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { ParishService } from '../../services/parish.service';
import { Parish } from '../../models/parish';

@Component({
  selector: 'app-parish-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './parish-form.html',
  styleUrl: './parish-form.css',
})
export class ParishFormComponent {
  parish: Partial<Parish> = {
    name: '',
    city: ''
  };

  constructor(
    private parishService: ParishService,
    private router: Router
  ) {}

  onSubmit(): void {
    this.parishService.createParish(this.parish).subscribe({
      next: () => {
        this.router.navigate(['parishes']);
      },
      error: (err) => {
        console.error('Błąd zapisu:', err);
        alert('Nie udało się zapisać parafii.');
      }
    });
  }
}
