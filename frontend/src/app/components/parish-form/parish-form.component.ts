import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ParishService } from '../../services/parish.service';
import { Parish } from '../../models/parish';

@Component({
  selector: 'app-parish-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './parish-form.html',
  styleUrl: './parish-form.css',
})
export class ParishFormComponent implements OnInit {
  parish: Partial<Parish> = {
    name: '',
    city: ''
  };

  isEditMode = false;
  parishId: string | null = null;

  constructor(
    private parishService: ParishService,
    private router: Router,
    private route: ActivatedRoute,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.isEditMode = true;
      this.parishId = id;
      this.loadParishData(id);
    }
  }
  
  loadParishData(id: string): void {
    this.parishService.getParish(id).subscribe({
      next: (data) => {
        this.parish = data;
        this.cdr.detectChanges()
      },
      error: (err) => console.error('Błąd pobierania parafii:', err)
    });
  }

  onSubmit(): void {
    if(this.isEditMode && this.parishId) {
      this.parishService.updateParish(this.parishId, this.parish).subscribe({
        next: () => {
          this.router.navigate(['/parishes'])
        },
        error: (err) => {
          console.error('Błąd edycji:', err);
          alert('Nie udało się edytować parafii');
        }
      });
    } else {
      this.parishService.createParish(this.parish).subscribe({
        next: () => {
          this.router.navigate(['/parishes']);
        },
        error: (err) => {
          console.error('Błąd zapisu:', err);
          alert('Nie udało się zapisać parafii.');
        }
    });
    }
  }
}
