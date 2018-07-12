package com.derivedmed.mytown.repository;

import com.derivedmed.mytown.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
public interface TokensRepository extends JpaRepository<Token,Long> {
}
