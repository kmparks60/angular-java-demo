package com.journal.journalapp.service;

import com.journal.journalapp.model.JournalEntry;
import com.journal.journalapp.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    private final JournalEntryRepository repository;

    public JournalEntryService(JournalEntryRepository repository) {
        this.repository = repository;
    }

    public List<JournalEntry> getAllEntries() {
        return repository.findAll();
    }

    public Optional<JournalEntry> getEntryById(Long id) {
        return repository.findById(id);
    }

    public JournalEntry createEntry(JournalEntry entry) {
        return repository.save(entry);
    }

    public JournalEntry updateEntry(Long id, JournalEntry updatedEntry) {
        updatedEntry.setId(id);
        return repository.save(updatedEntry);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}

