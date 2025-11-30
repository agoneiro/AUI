import { Component, OnInit } from '@angular/core';
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
  styleUrl: './priest-form.css',
})
export class PriestFormComponent implements OnInit {
  priest: Partial<Priest> = {
    name: '',
    age: 0
  };

  parishId: string | null = null;

  constructor(
    private priestService: PriestService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.parishId = this.route.snapshot.paramMap.get('parishId');

    if (!this.parishId) {
      console.error('Brak ID parafii w URL.');
    }
  }

  onSubmit(): void {
    if (this.parishId) {
      this.priestService.createPriest(this.parishId, this.priest).subscribe({
        next: () => {
          this.router.navigate(['/parishes', this.parishId]);
        },
        error: (err) => {
          console.error('Błąd zapisu księdza:', err);
          alert('Nie udało się dodać księdza.');
        }
      });
    }
  }
}
