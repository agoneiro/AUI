import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { PriestService } from '../../services/priest.service';
import { Priest } from '../../models/priest';
import { Location } from '@angular/common';

@Component({
  selector: 'app-priest-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './priest-details.html',
  styleUrl: './priest-details.css'
})
export class PriestDetailsComponent implements OnInit {
  priest: Priest | undefined;

  constructor(
    private route: ActivatedRoute,
    private priestService: PriestService,
    private location: Location,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.priestService.getPriest(id).subscribe({
        next: (data) => {
          this.priest = data;
          console.log('Szczegóły księdza:', data);
          this.cdr.detectChanges();
        },
        error: (err) => console.error('Błąd pobierania szczegółów:', err)
      });
    }
  }

  goBack(): void {
    this.location.back(); 
  }
}