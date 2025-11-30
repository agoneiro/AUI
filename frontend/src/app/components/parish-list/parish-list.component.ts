import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Parish } from '../../models/parish';
import { ParishService } from '../../services/parish.service'

@Component({
  selector: 'app-parish-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './parish-list.html',
  styleUrl: './parish-list.css',
})
export class ParishListComponent implements OnInit {
  parishes: Parish[] = [];

  constructor(private parishService: ParishService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadParishes()
  }

  loadParishes(): void {
    this.parishService.getParishes().subscribe({
      next: (data) => {
        this.parishes = data;
        console.log('Pobrano parafie');

        this.cdr.detectChanges();
      },
      error: (err) => console.error('Błąd pobierania parafii:', err)
    });
  }

  deleteParish(id: string): void {
    if(confirm('Czy na pewno chcesz usunąć tą parafię?')) {
      this.parishService.deleteParish(id).subscribe({
        next: () => {
          this.loadParishes();
          this.cdr.detectChanges();
        },
        error: (err) => console.error('Błąd usuwania:', err)
      });
    }
  }
}
