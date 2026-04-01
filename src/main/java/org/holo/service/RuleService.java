package org.holo.service;

import lombok.RequiredArgsConstructor;
import org.holo.entity.Rule;
import org.holo.repo.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleService {
  final RuleRepository ruleRepository;

  public List<Rule> queryAll() {
    return ruleRepository.findAll();
  }

  public void saveAll(List<Rule> rules) {
    ruleRepository.saveAll(rules);
  }
}
