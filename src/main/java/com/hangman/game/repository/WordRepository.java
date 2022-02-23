package com.hangman.game.repository;

import com.hangman.game.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(value = "SELECT * FROM hangman.words order by rand() LIMIT 1", nativeQuery = true)
    public Word findRandomWord();
}
