import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ParishService } from '../../services/parish.service';
import { PriestService } from '../../services/priest.service';
import { Parish } from '../../models/parish';
import { Priest } from '../../models/priest';

@Component({
  selector: 'app-parish-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './parish-details.html',
  styleUrl: './parish-details.css',
})
export class ParishDetailsComponent implements OnInit {
  parish: Parish | undefined;
  priests: Priest[] = [];

  constructor(
    private route: ActivatedRoute,
    private parishService: ParishService,
    private priestService: PriestService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.parishService.getParish(id).subscribe({
        next: (data) => {
          this.parish = data;
          this.cdr.detectChanges();
        },
        error: (err) => console.error('Błąd pobierania parafii', err)
      });
      this.loadPriests(id);
    }
  }

  loadPriests(parishId: string): void {
    this.priestService.getPriestsByParish(parishId).subscribe({
      next: (data) => {
        this.priests = data;
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Błąd pobierania księży:', err)
    });
  }

  deletePriest(priestId: string): void {
    if (confirm('Czy na pewno chcesz usunąć tego księdza?')) {
      this.priestService.deletePriest(priestId).subscribe({
        next: () => {
          if (this.parish) {
            this.loadPriests(this.parish.id);
          }
        },
        error: (err) => alert('Nie udało się usunąć księdza.')
      });
    }
  }
}
