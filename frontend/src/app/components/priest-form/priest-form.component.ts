import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { PriestService } from '../../services/priest.service';
import { Priest } from '../../models/priest';

@Component({
  selector: 'app-priest-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './priest-form.html',
  styleUrl: './priest-form.css'
})
export class PriestFormComponent implements OnInit {

  priest: Partial<Priest> = {
    name: '',
    age: 0
  };

  isEditMode = false;
  priestId: string | null = null;
  parishId: string | null = null;

  constructor(
    private priestService: PriestService,
    private router: Router,
    private route: ActivatedRoute,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.priestId = this.route.snapshot.paramMap.get('id');
    this.parishId = this.route.snapshot.paramMap.get('parishId');

    if (this.priestId) {
      this.isEditMode = true;
      this.loadPriestData(this.priestId);
    } 
  }

  loadPriestData(id: string): void {
    this.priestService.getPriest(id).subscribe({
      next: (data) => {
        this.priest = data;
        if (data.parish) {
          this.parishId = data.parish.id;
        }
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Błąd pobierania księdza:', err)
    });
  }

  onSubmit(): void {
    if (this.isEditMode && this.priestId) {
      this.priestService.updatePriest(this.priestId, this.priest).subscribe({
        next: () => this.goBack(),
        error: (err) => alert('Błąd edycji księdza')
      });
    } else if (this.parishId) {
      this.priestService.createPriest(this.parishId, this.priest).subscribe({
        next: () => this.goBack(),
        error: (err) => alert('Błąd zapisu księdza')
      });
    }
  }

  goBack(): void {
    if (this.parishId) {
      this.router.navigate(['/parishes', this.parishId]);
    } else {
      this.router.navigate(['/parishes']);
    }
  }
}