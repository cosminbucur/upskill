package com.sda.spring.data.jpa.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    // readOnly - improve performance of read
    @Transactional(readOnly = true)
    public Card findById(Long id) {
        return cardRepository.findById(id).get();
    }

    // automatic start, commit, rollback
    @Transactional
    public void updateTransaction(Long id) {
        Card card = cardRepository.findById(id).get();
        card.setName("test");
        cardRepository.save(card);
    }

    // rollback only when a RuntimeException is thrown
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateTransactionWithRollback(Long id, boolean rollback) {
        Card card = cardRepository.findById(id).get();
        card.setName("test");
        cardRepository.save(card);

        if (rollback) {
            throw new RuntimeException("silly exception");
        }
    }

    // rollbackFor, noRollbackFor - define for which exception class to rollback
    @Transactional(rollbackFor = Exception.class, noRollbackFor = EntityNotFoundException.class)
    public void updateTransactionPreventRollback(Long id, boolean rollback) {
        Card card = cardRepository.findById(id).get();
        card.setName("test");
        cardRepository.save(card);

        if (rollback) {
            throw new EntityNotFoundException("no such entity");
        }
    }
}
