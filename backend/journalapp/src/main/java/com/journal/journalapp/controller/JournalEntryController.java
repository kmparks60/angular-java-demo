package com.journal.journalapp.controller;

import com.journal.journalapp.model.JournalEntry;
import com.journal.journalapp.service.JournalEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/entries")
@CrossOrigin(origins = "http://localhost:4200")
public class JournalEntryController {

    private final JournalEntryService service;

    public JournalEntryController(JournalEntryService service) {
        this.service = service;
    }

    @GetMapping
    public List<JournalEntry> getAllEntries() {
        return service.getAllEntries();
    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable Long id) {
        return service.getEntryById(id).orElse(null);
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        return service.createEntry(entry);
    }

    @PutMapping("/{id}")
    public JournalEntry updateEntry(@PathVariable Long id, @RequestBody JournalEntry entry) {
        return service.updateEntry(id, entry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
    }
}