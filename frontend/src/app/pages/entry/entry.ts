import { Component } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EntryService } from '../../core/services/entry';
import { Entry } from '../../core/models/entry';

@Component({
  standalone: true,
  selector: 'app-entry',
  templateUrl: './entry.html',
  styleUrls: ['./entry.scss'],
  imports: [CommonModule, FormsModule, DatePipe]
})
export class EntryPage {
  entries: Entry[] = [];
  newEntry: Entry = { title: '', content: '' };

  constructor(private entryService: EntryService) {}

  ngOnInit(): void {
    this.fetchEntries();
  }

  fetchEntries(): void {
    this.entryService.getEntries().subscribe((data) => {
      this.entries = data;
    });
  }

  submitEntry(): void {
    if (!this.newEntry.title || !this.newEntry.content) return;

    this.entryService.createEntry(this.newEntry).subscribe((entry) => {
      this.entries.unshift(entry);
      this.newEntry = { title: '', content: '' };
    });
  }
}
